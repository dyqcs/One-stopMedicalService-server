package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.PrescriptionInfo;
import com.example.onestopmedicalserviceserver.entry.DrugstoreInfo;
import com.example.onestopmedicalserviceserver.entry.DrugstoreInfoDrugMoney;
import com.example.onestopmedicalserviceserver.entry.GeographicInfo;

import java.util.List;

public interface DrugstoreService {

    Double distanceBetweenWwoPlaces(Integer drugstore01Id,Integer drugstore02Id);
    List<Drugstore> selectAll();
    Drugstore selectOneByName(String name);
    List<Drugstore> selectListByDrugName(String name);
    List<DrugstoreInfo> geoNearByPlace(Double longitude,Double latitude,Integer distance,Integer limit);
    List<DrugstoreInfo> geoNearByPlaceAllDrugstoreInfo(Double longitude,Double latitude,Integer distance,Integer limit);
    List<DrugstoreInfoDrugMoney> geoNearByPlaceAccordingToMoney(Double longitude, Double latitude, Integer distance, Integer limit, String drugName);
    List<DrugstoreInfo> geoNearByPlaceAccordingToDistance(Double longitude, Double latitude, Integer distance, Integer limit, String drugName);
    List<DrugstoreInfo> calculateDistanceByPrescriptionInfo(GeographicInfo geographicInfo);
    List<DrugstoreInfo> calculateMoneyByPrescriptionInfo(GeographicInfo geographicInfo);
}
