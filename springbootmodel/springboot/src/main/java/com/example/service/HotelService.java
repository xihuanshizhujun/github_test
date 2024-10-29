package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.HotelDao;
import com.example.entity.Hotel;
import com.example.entity.Params;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Resource
    private HotelDao hotelDao;


    public PageInfo<Hotel> findBySearch(Params params) {
        // 开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        // 接下来的查询会自动按照当前开启的分页设置来查询
        List<Hotel> list = hotelDao.findBySearch(params);
        if (CollectionUtil.isEmpty(list)) {
            return PageInfo.of(new ArrayList<>());
        }
        return PageInfo.of(list);
    }

    public void add(Hotel hotel) {
        hotelDao.insertSelective(hotel);
    }

    public void update(Hotel hotel) {
        hotelDao.updateByPrimaryKeySelective(hotel);
    }

    public void delete(Integer id) {
        hotelDao.deleteByPrimaryKey(id);
    }
}
