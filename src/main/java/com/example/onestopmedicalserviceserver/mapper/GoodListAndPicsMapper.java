package com.example.onestopmedicalserviceserver.mapper;

import com.example.onestopmedicalserviceserver.entry.GoodListAndPics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodListAndPicsMapper {
    List<GoodListAndPics> selectAll();

}
