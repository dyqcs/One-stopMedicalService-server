package com.example.onestopmedicalserviceserver.drugRelated.service;

import com.example.onestopmedicalserviceserver.other.pdf.PrescriptionInfo;

import java.util.List;

public interface PrescriptionInfoService {
    List<PrescriptionInfo> selectAll();
    PrescriptionInfo selectOneByName(String name);
    PrescriptionInfo selectOneById(int id);
    int insertOne(PrescriptionInfo prescriptionInfo);
    List<PrescriptionInfo> selectListByPrescriptionId(String id);
}
