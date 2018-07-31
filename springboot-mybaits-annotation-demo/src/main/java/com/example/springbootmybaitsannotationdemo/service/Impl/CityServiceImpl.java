package com.example.springbootmybaitsannotationdemo.service.Impl;

import com.example.springbootmybaitsannotationdemo.dao.CityDao;
import com.example.springbootmybaitsannotationdemo.domain.City;
import com.example.springbootmybaitsannotationdemo.service.CityService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}
