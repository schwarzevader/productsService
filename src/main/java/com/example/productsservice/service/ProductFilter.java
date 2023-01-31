package com.example.productsservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter {

    private double min;
    private double max;

    private List<String> filters = new ArrayList<>();

    //превратить в одну строку
    @Override
    public String toString() {
        return filters.toString();
    }
}
