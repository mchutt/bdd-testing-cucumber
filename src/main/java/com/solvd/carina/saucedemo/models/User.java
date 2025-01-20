package com.solvd.carina.saucedemo.models;

import lombok.Data;

import java.util.List;
@Data
public class User {
        private int id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String zipCode;
        private List<UserOrder> userOrderList;
}

