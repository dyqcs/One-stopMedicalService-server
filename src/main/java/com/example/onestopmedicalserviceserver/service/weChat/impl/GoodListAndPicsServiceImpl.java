package com.example.onestopmedicalserviceserver.service.weChat.impl;


import com.example.onestopmedicalserviceserver.entry.GoodListAndPics;
import com.example.onestopmedicalserviceserver.mapper.GoodListAndPicsMapper;
import com.example.onestopmedicalserviceserver.service.weChat.GoodListAndPicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodListAndPicsServiceImpl implements GoodListAndPicsService {

    @Autowired
    GoodListAndPicsMapper goodListAndPicsMapper;

    @Override
    public List<GoodListAndPics> selectAll() {
        return goodListAndPicsMapper.selectAll();
    }


}
