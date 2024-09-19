package com.example.deliverybackend.entity;

import com.example.deliverybackend.entity.UserDao;

public class HomeAddressDto {


    private Long HomeAddressNumber;

    private UserDao addressUserNumber;

    private String address;

    private String addressCategory;
    private boolean addressSelect ;

    @Override
    public String toString() {
        return "HomeAddressDto{" +
                "HomeAddressNumber=" + HomeAddressNumber +
                ", addressUserNumber=" + addressUserNumber +
                ", address='" + address + '\'' +
                ", addressCategory='" + addressCategory + '\'' +
                ", addressSelect=" + addressSelect +
                '}';
    }

    public boolean isAddressSelect() {
        return addressSelect;
    }

    public void setAddressSelect(boolean addressSelect) {
        this.addressSelect = addressSelect;
    }

    public Long getHomeAddressNumber() {
        return HomeAddressNumber;
    }

    public void setHomeAddressNumber(Long homeAddressNumber) {
        HomeAddressNumber = homeAddressNumber;
    }

    public UserDao getAddressUserNumber() {
        return addressUserNumber;
    }

    public void setAddressUserNumber(UserDao addressUserNumber) {
        this.addressUserNumber = addressUserNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressCategory() {
        return addressCategory;
    }

    public void setAddressCategory(String addressCategory) {
        this.addressCategory = addressCategory;
    }
}
