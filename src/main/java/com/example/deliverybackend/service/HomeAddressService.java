package com.example.deliverybackend.service;

import com.example.deliverybackend.entity.FavoriteDao;
import com.example.deliverybackend.entity.HomeAddressDao;
import com.example.deliverybackend.entity.HomeAddressDto;
import com.example.deliverybackend.entity.UserDao;
import com.example.deliverybackend.repository.HomeAddressRepository;
import com.example.deliverybackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeAddressService {

    @Autowired
    private HomeAddressRepository homeAddressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<HomeAddressDao> getAllUserAddress(UserDao user) {
        // 사용자 객체에 해당하는 주소 목록을 반환합니다.
        return homeAddressRepository.findByAddressUserNumber(user);
    }

    public HomeAddressDao saveHomeAddress(HomeAddressDto homeAddressDto) {
        HomeAddressDao homeAddressDao = new HomeAddressDao();
        homeAddressDao.setHomeAddressNumber(homeAddressDto.getHomeAddressNumber());
        homeAddressDao.setAddressUserNumber(homeAddressDto.getAddressUserNumber());
        homeAddressDao.setAddressCategory(homeAddressDto.getAddressCategory());
        homeAddressDao.setAddress(homeAddressDto.getAddress());
        homeAddressDao.setAddressSelect(homeAddressDto.isAddressSelect());
        return homeAddressRepository.save(homeAddressDao);
    }
    @Transactional
    public void updateAddressSelectStatus(Long HomeAddressNumber, boolean addressSelect) {
        Optional<HomeAddressDao> optionalAddress = homeAddressRepository.findById(HomeAddressNumber);
        if (optionalAddress.isPresent()) {
            HomeAddressDao homeAddressDao = optionalAddress.get();
            homeAddressDao.setAddressSelect(addressSelect);
            homeAddressRepository.save(homeAddressDao);
        } else {
            System.out.println("주소셀렉트 못받아옴");
        }
    }
    @Transactional
    public void deleteAddress(UserDao userNumber, Long addressId) {
            homeAddressRepository.deleteByAddressUserNumberAndAddress(userNumber,addressId);
    }
}
