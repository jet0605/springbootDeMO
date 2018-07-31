package com.example.springbootdruid.service.Impl;

import com.example.springbootdruid.dao.cluster.CityDao;
import com.example.springbootdruid.dao.master.UserDao;
import com.example.springbootdruid.domain.City;
import com.example.springbootdruid.domain.User;
import com.example.springbootdruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private CityDao cityDao;
    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("JiuJiang");
        user.setCity(city);
        return user;
    }
}
