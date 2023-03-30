package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.PrescriptionInfo;
import com.example.onestopmedicalserviceserver.entry.DrugstoreInfo;

import java.util.List;

public interface PrescriptionInfoService {
    List<PrescriptionInfo> selectAll();
    PrescriptionInfo selectOneByName(String name);
    PrescriptionInfo selectOneById(int id);
    int insertOne(PrescriptionInfo prescriptionInfo);
    List<PrescriptionInfo> selectListByPrescriptionId(String id);
}
