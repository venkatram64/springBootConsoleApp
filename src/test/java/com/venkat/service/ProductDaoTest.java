package com.venkat.service;

import com.venkat.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDaoTest {

    private static Logger logger = LoggerFactory.getLogger(ProductDaoTest.class);

    @Autowired
    private ProductDao productDao;

    @BeforeEach
    public void setup(){

    }

    @Test
    void getAll() {
        List<Product> productList = productDao.getAll();
        logger.info("Size of products " + productList.size());
        productList.forEach(p -> {
            System.out.println("Product Id: " + p.getProductId());
        });
        assertTrue(productList.size() > 0);
    }

    @Test
    void create() {
        Product product = new Product();
        product.setProductName("Sports Bycycle");
        product.setModelYear(2018);
        product.setListPrice(12000);
        Product p = productDao.create(product);
        assertTrue(p.getProductName() != null);
    }

    @Test
    void get() {
        List<Product> productList = productDao.getAll();
        int id = productList.get(0).getProductId();
        Optional<Product> p = productDao.get(id);
        assertNotNull(p.get().getProductName());
    }

    @Test
    void update() {
        List<Product> productList = productDao.getAll();
        int id = productList.get(0).getProductId();
        Product product = new Product();
        product.setProductName("Sports Bycycle");
        product.setModelYear(2018);
        product.setListPrice(12000);
        Product p = productDao.update(product, id);
        assertTrue(p.getProductName() != null);
    }

    @Test
    void delete() {
        List<Product> productList = productDao.getAll();
        int id = productList.get(0).getProductId();
        boolean isDeleted = productDao.delete(id);
        assertTrue(isDeleted);
    }
}