package com.example.productsservice.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "typies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "types_categories",schema = "public")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = TypeCategory.class,
        resolver =EntityIdResolver.class
)
public class TypeCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;
    private String nameOfTypeCategory;



    @OneToMany(mappedBy = "typeCategory",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ProductCategory> categoryList = new ArrayList<>();


}
