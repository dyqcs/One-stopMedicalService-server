package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Drug;
import com.example.onestopmedicalserviceserver.entry.DrugIdAndDrugName;
import com.example.onestopmedicalserviceserver.entry.drug.DrugInfo;

import java.util.List;
import java.util.Set;

public interface DrugService {
    List<Drug> selectAll();
    Set<DrugIdAndDrugName> selectALlDrugNameAndDrugId();
    List<Drug> selectListByName(String name);
    List<Drug> fuzzySearchListByName(String name);
    DrugInfo selectOneById(Integer id);
    Drug selectOneByNameAndDrugstoreId(String drugName, Integer drugstoreId);
    List<Drug> selectListByDrugstoreId(Integer id);
}
