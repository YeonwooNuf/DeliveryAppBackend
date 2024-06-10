//package com.example.deliverybackend.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class HomeAddressId implements Serializable {
//
//    @Column(name = "HomeAddressNumber")
//    private Long HomeAddressNumber;
//
//    @Column(name = "addressUserNumber")
//    private Long addressUserNumber; // This should match the type of the UserDao's ID field
//
//    // Default constructor
//    public HomeAddressId() {}
//
//    // Parameterized constructor
//    public HomeAddressId(Long homeAddressNumber, Long addressUserNumber) {
//        this.HomeAddressNumber = homeAddressNumber;
//        this.addressUserNumber = addressUserNumber;
//    }
//
//    // equals and hashCode methods
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HomeAddressId that = (HomeAddressId) o;
//        return Objects.equals(HomeAddressNumber, that.HomeAddressNumber) &&
//                Objects.equals(addressUserNumber, that.addressUserNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(HomeAddressNumber, addressUserNumber);
//    }
//}
