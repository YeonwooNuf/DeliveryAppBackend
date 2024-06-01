package com.example.deliverybackend.service;

import com.example.deliverybackend.entity.MenuDao;
import com.example.deliverybackend.entity.MenuDto;
import com.example.deliverybackend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDao> getAllMenus(){
        return menuRepository.findAll();
    };
}
