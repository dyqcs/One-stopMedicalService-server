package com.example.onestopmedicalserviceserver.init;

import com.example.onestopmedicalserviceserver.drugRelated.domain.Drugstore;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugstoreService;
import com.example.onestopmedicalserviceserver.util.GeoHashUtil;
import com.example.onestopmedicalserviceserver.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 启动加载redis
 */
@Component
public class RedisDataInit {

    @Autowired
    DrugstoreService drugstoreService;

    @Autowired
    GeoHashUtil geoHashUtil;

    @Autowired
    RedisUtil redisUtil;

    @Value("${redisKeys.geoDrugstore}")
    String geoKey;

    @PostConstruct
    void init(){
        //药店信息加入到redis中
        List<Drugstore> drugstores = drugstoreService.selectAll();
        for(Drugstore drugstore:drugstores){
            //地理位置
            geoHashUtil.geoAdd(geoKey,drugstore.getLongitude(),drugstore.getLatitude(),drugstore.getId().toString());

        }

    }
}
