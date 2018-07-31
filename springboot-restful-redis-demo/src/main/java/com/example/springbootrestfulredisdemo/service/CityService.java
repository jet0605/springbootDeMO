package com.example.springbootrestfulredisdemo.service;

import com.example.springbootrestfulredisdemo.domain.City;

import java.util.List;


public interface CityService {
    /**
     * 查询所有城市信息
     * @return
     */
    List<City> findAllCity();
    /**
     * 根据城市ID，查询城市信息
     * @return
     */
    City findCityById(Long id);

    /**
     * 新增城市信息
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 根据城市ID，删除城市信息
     * @param city
     * @return
     */
    Long updateCity(City city);

    /**
     * 根据城市ID，删除城市信息
     * @param id
     * @return
     */
    Long deleteCity(Long id);
}
