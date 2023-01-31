package com.example.productsservice.searchClass;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryBooleanNode {

    private Boolean value;
    private String categoryLabel;


}