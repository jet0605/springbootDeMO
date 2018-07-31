package com.example.springbootrestfulredisdemo.dao;

import com.example.springbootrestfulredisdemo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "cityDao")
public interface CityDao {
    /**
     * 获取城市列表
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市ID，获取城市信息
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
