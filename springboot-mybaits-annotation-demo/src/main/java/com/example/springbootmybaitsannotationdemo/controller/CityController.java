package com.example.springbootmybaitsannotationdemo.controller;

import com.example.springbootmybaitsannotationdemo.domain.City;
import com.example.springbootmybaitsannotationdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city",method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityname",required = true)String name){
        return cityService.findCityByName(name);
    }
}
