package com.venkat.service;

import com.venkat.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao implements MyDao<Product> {

    private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);
    private JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Product> rowMapper = (rs, rowNum) -> {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setModelYear(rs.getInt("model_year"));
        product.setListPrice(rs.getFloat("list_price"));
        return product;
    };

    @Override
    public List<Product> getAll() {
        logger.info("Fetching all records");
        String sql = "select * from products";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Product create(Product product) {
        logger.info("Creating a record");
        String sql = "insert into products(product_name, model_year, list_price) values(?,?,?)";
        int insert = jdbcTemplate.update(sql, product.getProductName(), product.getModelYear(), product.getListPrice());
        if(insert == 1){
            logger.info("New Product is created: " + product.getProductName());
            return product;
        }
        return null;
    }

    @Override
    public Optional<Product> get(int id) {
        logger.info("Fetching a record by id: " + id);
        String sql = "select * from products where product_id = ?";
        Product product = null;
        try{
            product = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException ex){
            logger.error("Product not found: " + id);
        }
        return Optional.ofNullable(product);
    }

    @Override
    public Product update(Product product, int id) {
        logger.info("Updating a record: ");
        String sql = "update products set product_name = ?, model_year = ?, list_price = ? where product_id = ?";
        int update = jdbcTemplate.update(sql, product.getProductName(), product.getModelYear(), product.getListPrice(), id);
        if(update == 1){
            logger.info("Product is updated: " + product.getProductName());
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Deleting a record");
        String sql = "delete from products where product_id = ?";
        int delete = jdbcTemplate.update(sql, id);
        if(delete == 1){
            logger.info("Product is deleted: " + id);
            return true;
        }
        return false;
    }
}
