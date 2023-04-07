package com.example.onestopmedicalserviceserver.drugRelated.service;

import com.example.onestopmedicalserviceserver.drugRelated.domain.Drug;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugIdAndDrugName;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugInfo;

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
