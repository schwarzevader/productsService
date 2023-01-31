package com.example.productsservice.searchClass;

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
public class SearchCategory {
    private List<String> searchCategories = new ArrayList<>();

    public void setSearchCategories(List<String> searchCategories) {
        this.searchCategories = searchCategories;
    }

    public List<String> getSearchCategories() {
        return searchCategories;
    }

    @Override
    public String toString() {
        return "SearchCategory{" +
                "searchCategories=" + searchCategories.toString() +
                '}';
    }
}
