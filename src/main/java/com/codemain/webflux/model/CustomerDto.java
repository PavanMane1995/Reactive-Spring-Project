package com.codemain.webflux.model;

import lombok.Data;

@Data
public class CustomerDto {


    private String name;
    private int id;

    public CustomerDto(int a, String s) {
        this.id =a;
        this.name = s;
    }
}
