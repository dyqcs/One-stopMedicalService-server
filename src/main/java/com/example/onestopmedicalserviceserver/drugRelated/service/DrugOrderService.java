package com.example.onestopmedicalserviceserver.drugRelated.service;

import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugOrder;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugOrderForm;

import java.util.List;

public interface DrugOrderService {
    List<DrugOrder> selectAll();
    DrugOrder selectOneById(String id);
    DrugOrderForm selectDrugOrderFormById(String id);
    String insertDrugOrderForm(DrugOrderForm drugOrderForm);
}
