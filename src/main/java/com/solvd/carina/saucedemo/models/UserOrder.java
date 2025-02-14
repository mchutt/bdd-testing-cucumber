package com.solvd.carina.saucedemo.models;

import lombok.Data;

@Data
public class UserOrder {
    private int id;
    private int userId;
    private String productName;
}
