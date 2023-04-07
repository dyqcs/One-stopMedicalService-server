package com.example.onestopmedicalserviceserver.drugRelated.service;

import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugOrderInfo;

import java.util.List;

public interface DrugOrderInfoService {
    List<DrugOrderInfo> selectAll();
    List<DrugOrderInfo> selectListByDrugOrderId(String drugOrderId);
    DrugOrderInfo selectOneById(String id);
    int insertOne(DrugOrderInfo drugOrderInfo);
}
