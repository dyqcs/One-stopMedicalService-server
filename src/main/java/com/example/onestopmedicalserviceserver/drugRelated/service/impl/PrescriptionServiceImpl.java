package com.example.onestopmedicalserviceserver.drugRelated.service.impl;

import com.example.onestopmedicalserviceserver.other.pdf.dao.PrescriptionDao;
import com.example.onestopmedicalserviceserver.other.pdf.Prescription;
import com.example.onestopmedicalserviceserver.other.pdf.PrescriptionInfo;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugInfo;
import com.example.onestopmedicalserviceserver.other.pdf.entry.PrescriptionForm;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugService;
import com.example.onestopmedicalserviceserver.drugRelated.service.PrescriptionInfoService;
import com.example.onestopmedicalserviceserver.drugRelated.service.PrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    PrescriptionDao prescriptionDao;
    @Autowired
    DrugService drugService;
    @Autowired
    PrescriptionInfoService prescriptionInfoService;
    @Value("${network_localhost}")
    String network_localhost;

    @Override
    public List<Prescription> selectAll() {
        return prescriptionDao.selectList(null);
    }

    @Override
    public PrescriptionForm selectOneById(String id) {
        PrescriptionForm pf = new PrescriptionForm();
        Prescription prescription = prescriptionDao.selectById(id);
        if (prescription==null)
            return null;
        //父类属性传给子类
        BeanUtils.copyProperties(prescription,pf);
        pf.setInfos(prescriptionInfoService.selectListByPrescriptionId(id));
        return pf;
    }

    @Override
    public String createPrescriptionForm(PrescriptionForm pf) {
        Prescription prescription = pf;
        //处方单存储
        prescriptionDao.insert(pf);

        if (pf.getInfos()==null){
            pf.setInfos(new ArrayList<>());
        }

        //处方信息存储
        List<PrescriptionInfo> infos = pf.getInfos();
        if (pf.getDrugsId().size()!=0){
            List<Integer> drugsId = pf.getDrugsId();
            for (Integer id:drugsId){
                DrugInfo drugInfo = drugService.selectOneById(id);
                PrescriptionInfo prescriptionInfo = new PrescriptionInfo();
                prescriptionInfo.setNum(2);
                prescriptionInfo.setName(drugInfo.getName());
                prescriptionInfo.setUsageDosage("1片/次;每日一次;口服");
                prescriptionInfo.setSpecifications(drugInfo.getStandards());
                infos.add(prescriptionInfo);
            }
        }

        for (PrescriptionInfo info :infos){
            info.setPrescriptionId(pf.getId());
            prescriptionInfoService.insertOne(info);
        }

        return network_localhost+"pdf/prescriptionDownload?id="+pf.getId();
    }
}
