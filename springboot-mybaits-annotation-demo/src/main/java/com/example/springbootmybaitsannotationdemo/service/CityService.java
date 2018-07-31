package com.example.springbootmybaitsannotationdemo.service;

import com.example.springbootmybaitsannotationdemo.domain.City;

public interface CityService {
    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);
}
