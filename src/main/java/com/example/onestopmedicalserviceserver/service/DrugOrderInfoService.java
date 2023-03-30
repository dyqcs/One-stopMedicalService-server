package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.DrugOrder;
import com.example.onestopmedicalserviceserver.domain.DrugOrderInfo;

import java.util.List;

public interface DrugOrderInfoService {
    List<DrugOrderInfo> selectAll();
    List<DrugOrderInfo> selectListByDrugOrderId(String drugOrderId);
    DrugOrderInfo selectOneById(String id);
    int insertOne(DrugOrderInfo drugOrderInfo);
}
