package com.example.productsservice;

import com.example.productsservice.dto.ProductDTO;
import com.example.productsservice.entity.*;
import com.example.productsservice.repositories.Category.CategoryRepositoryImp;
import com.example.productsservice.repositories.product.ProductRepositoryImp;
import com.example.productsservice.repositories.productCharacteristic.ProductCharacteristicRepoImp;
import com.example.productsservice.repositories.productCharacteristicItem.ProductChartemRepoImp;
import com.example.productsservice.service.typeCategory.TypeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class ProductsServiceApplication implements CommandLineRunner {
    @Autowired
    ProductRepositoryImp productRepositoryImp ;

    @Autowired
    CategoryRepositoryImp categoryRepositoryImp;

    @Autowired
    ProductCharacteristicRepoImp productCharacteristicRepoImp ;

//    @Autowired
//    ProductChartemRepoImp productCharacteristicItemRepoImp ;

    @Autowired
    TypeCategoryService typeCategoryService;
    public static void main(String[] args) {
        SpringApplication.run(ProductsServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        ProductCharacteristic sizeSneakers44point5 = new ProductCharacteristic();
//        sizeSneakers44point5.setName("sneakersSize");
//        sizeSneakers44point5.setValue("44.5");
//        ProductCharacteristic phoneScreenSize6point5 = new ProductCharacteristic();
//        phoneScreenSize6point5.setName("phoneScreenSize");
//        phoneScreenSize6point5.setValue("6.5");
//        ProductCharacteristic phoneScreenSize6point1 = new ProductCharacteristic();
//        phoneScreenSize6point1.setName("phoneScreenSize");
//        phoneScreenSize6point1.setValue("6.1");
//        productCharacteristicRepoImp.save(sizeSneakers44point5);
//        productCharacteristicRepoImp.save(phoneScreenSize6point1);
//        productCharacteristicRepoImp.save(phoneScreenSize6point5);
//
//
//
//        Product adidasSneakers = new Product();
//        Product adidasPolo = new Product();
//        Product nike = new Product();
//        Product puma = new Product();
//        Product saucony = new Product();
//        Product NB = new Product();
//        Product samsung = new Product();
//        Product pixel = new Product();
//        TypeCategory closeAndShoes = new TypeCategory();
//        TypeCategory electronics = new TypeCategory();
//        closeAndShoes.setNameOfTypeCategory("closeAndShoes");
//        electronics.setNameOfTypeCategory("electronics");
//
//        typeCategoryService.save(closeAndShoes);
//        typeCategoryService.save(electronics);
//
//
//        ProductCategory sneakers = new ProductCategory();
//        ProductCategory close = new ProductCategory();
//        ProductCategory cellPhone = new ProductCategory();
//        close.setNameOfCategory("close");
//        cellPhone.setNameOfCategory("smartphones");
//        sneakers.setNameOfCategory("sneakers");
//        close.setTypeCategory(closeAndShoes);
//        sneakers.setTypeCategory(closeAndShoes);
//        cellPhone.setTypeCategory(electronics);
//        categoryRepositoryImp.saveCategory(cellPhone);
//        categoryRepositoryImp.saveCategory(sneakers);
//        categoryRepositoryImp.saveCategory(close);
//
//        samsung.setName("samsung s23 smartphone ");
//        samsung.setCategory(cellPhone);
//        samsung.setPrice(1000);
//        pixel.setName("smartphone google pixel 7");
//        pixel.setCategory(cellPhone);
//        pixel.setPrice(700);
//        adidasPolo.setName("adidas polo");
//        adidasSneakers.setName("adidas Sneakers ");
//        adidasSneakers.setCategory(sneakers);
//        adidasPolo.setCategory(close);
//        nike.setName("nike air");
//        nike.setCategory(sneakers);
//        puma.setName("puma polo");
//        puma.setCategory(close);
//        saucony.setName("saucony sneakers");
//        saucony.setCategory(sneakers);
//        NB.setName("NB sneakers ");
//        NB.setCategory(sneakers);
//        adidasSneakers.setPrice(170);
//        nike.setPrice(100);
//        puma.setPrice(11);
//        saucony.setPrice(70);
//        NB.setPrice(110);
//        adidasPolo.setPrice(17);
//
//
//
//
//        productRepositoryImp.saveProduct(pixel);
//        productRepositoryImp.saveProduct(samsung);
//        productRepositoryImp.saveProduct(adidasSneakers);
//        productRepositoryImp.saveProduct(adidasPolo);
//        productRepositoryImp.saveProduct(nike);
//        productRepositoryImp.saveProduct(puma);
//        productRepositoryImp.saveProduct(saucony);
//        productRepositoryImp.saveProduct(NB);
//        productRepositoryImp.saveProduct(adidasPolo);

//        ProductCharacteristicItem sizeSneak = new ProductCharacteristicItem();
//        sizeSneak.setProduct(productRepositoryImp.findById((Long) 3L));
//        sizeSneak.setProductCharacteristic(productCharacteristicRepoImp.findByID((Long) 1L));
//        ProductCharacteristicItem sizePhone = new ProductCharacteristicItem();
//        sizePhone.setProduct(productRepositoryImp.findById(2L));
//        sizePhone.setProductCharacteristic(productCharacteristicRepoImp.findByID(2L));
//
//        ProductCharacteristicItem sizePhonee = new ProductCharacteristicItem();
//        sizePhonee.setProduct(productRepositoryImp.findById(1L));
//        sizePhonee.setProductCharacteristic(productCharacteristicRepoImp.findByID(3L));
//
//        productCharacteristicItemRepoImp.saveItem(sizePhonee);
//        productCharacteristicItemRepoImp.saveItem(sizePhone);
//        productCharacteristicItemRepoImp.saveItem(sizeSneak);

        //System.out.println(productCharacteristicRepoImp.findByID(1L).toString());





//




        String asc = "asc";
        String desc = "desc";

//      adidas sneakers  or sneakers
//        List<Product> productList = productRepositoryImp.paginationProductOrderByPrice("closeAndShoes",0,5,asc);

//        System.out.println("productLIst-------------");
//        System.out.println(productList.toString());

//        List<ProductDTO> productDTOList = productRepositoryImp.searchAndPaginationProductDTOOrderByPrice("Sneakers",0,10,desc);
//        System.out.println("productDTOList-------------");
//        System.out.println(productDTOList.toString());
//        System.out.println();

//
//        System.out.println("productList------");
//        System.out.println(productRepositoryImp.getPageableProduct(1,5,"Sneakers").toString());
//        System.out.println();

//        System.out.println("product by category and product characteristics-------");
//        System.out.println(productCharacteristicItemRepoImp.getProductDTOByCategoryAndProductCharacteristics("smartphones","phoneScreenSize","6.5").toString());
//        System.out.println("");








    }
}
