package com.example.springbootdruid.dao.cluster;

import com.example.springbootdruid.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "cityDao")
public interface CityDao {
    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     * @return 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
