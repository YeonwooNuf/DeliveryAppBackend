package com.example.deliverybackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HomeAddress")
//@IdClass(HomeAddressId.class)
public class HomeAddressDao {

    @Id
    @Column(name = "HomeAddressNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long HomeAddressNumber;

    //@Column(name = "addressUserNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserDao addressUserNumber;

    private String address;
    private String addressCategory;
    private boolean addressSelect = false;




    public boolean isAddressSelect() {
        return addressSelect;
    }

    public void setAddressSelect(boolean addressSelect) {
        this.addressSelect = addressSelect;
    }

    @Transient
    private UserDao userDao;

    public UserDao getAddressUserNumber() {
        return addressUserNumber;
    }

    public void setAddressUserNumber(UserDao addressUserNumber) {
        this.addressUserNumber = addressUserNumber;
    }


    // Getters and Setters

    public Long getHomeAddressNumber() {
        return HomeAddressNumber;
    }

    public void setHomeAddressNumber(Long homeAddressNumber) {
        HomeAddressNumber = homeAddressNumber;
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

//    public HomeAddressDto toDto(){
//        HomeAddressDto homeAddressDto = new HomeAddressDto();
//        homeAddressDto.setAddressUserNumber(this.getAddressUserNumber());
//        homeAddressDto.setAddress(this.getAddress());
//        homeAddressDto.setAddressCategory(this.getAddressCategory());
//
//        return homeAddressDto;
//    }

//    public void loadUser(UserDao userDao,Long HomeAddressNumber) {
//        this.userDao = userDao;
//        this.HomeAddressNumber = HomeAddressNumber;
//    }
@Override
public String toString() {
    return "HomeAddressDao{" +
            "HomeAddressNumber=" + HomeAddressNumber +
            ", addressUserNumber=" + addressUserNumber +
            ", address='" + address + '\'' +
            ", addressCategory='" + addressCategory + '\'' +
            '}';
}

}
