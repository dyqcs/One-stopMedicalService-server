package com.example.onestopmedicalserviceserver.service.weChat.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.weChat.GoodListDao;
import com.example.onestopmedicalserviceserver.dao.weChat.PicsDao;
import com.example.onestopmedicalserviceserver.domain.weChat.GoodList;
import com.example.onestopmedicalserviceserver.domain.weChat.Pics;
import com.example.onestopmedicalserviceserver.entry.GoodListAndPics;
import com.example.onestopmedicalserviceserver.service.weChat.GoodListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodListServiceImpl implements GoodListService {

    @Autowired
    GoodListDao goodListDao;
    @Autowired
    PicsDao picsDao;

    @Override
    public List<GoodList> selectAll() {
        return goodListDao.selectList(null);
    }

    @Override
    public GoodListAndPics selectOneById(int goodsId) {
        LambdaQueryWrapper<GoodList> lqw = new LambdaQueryWrapper<>();
        lqw.eq(GoodList::getGoodsId,goodsId);
        GoodList goodList = goodListDao.selectOne(lqw);

        if (goodList==null)
            return null;

        LambdaQueryWrapper<Pics> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Pics::getGoodsId,goodsId);
        List<Pics> picsList = picsDao.selectList(lqw1);


        GoodListAndPics goodListAndPics = new GoodListAndPics();
        BeanUtils.copyProperties(goodList, goodListAndPics);
        goodListAndPics.setPics(picsList);

        return goodListAndPics;
    }

    @Override
    public GoodList selectOneByName(String name) {
        LambdaQueryWrapper<GoodList> lqw  = new LambdaQueryWrapper<>();
        lqw.eq(GoodList::getName,name);
        return goodListDao.selectOne(lqw);
    }
}
