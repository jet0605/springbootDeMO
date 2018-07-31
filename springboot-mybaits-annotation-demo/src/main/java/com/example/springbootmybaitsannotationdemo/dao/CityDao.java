package com.example.springbootmybaitsannotationdemo.dao;

import com.example.springbootmybaitsannotationdemo.domain.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "cityDao")
public interface CityDao {
    @Select("SELECT * FROM city where city_name = #{cityName}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);
}
