package com.example.onestopmedicalserviceserver.service.weChat;

import com.example.onestopmedicalserviceserver.domain.weChat.GoodList;
import com.example.onestopmedicalserviceserver.entry.GoodListAndPics;

import java.util.List;

public interface GoodListService {
    List<GoodList> selectAll();

    GoodListAndPics selectOneById(int goodsId);

    GoodList selectOneByName(String name);
}
