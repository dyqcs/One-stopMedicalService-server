package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.DrugOrder;
import com.example.onestopmedicalserviceserver.entry.DrugOrderForm;

import java.util.List;

public interface DrugOrderService {
    List<DrugOrder> selectAll();
    DrugOrder selectOneById(String id);
    DrugOrderForm selectDrugOrderFormById(String id);
    String insertDrugOrderForm(DrugOrderForm drugOrderForm);
}
