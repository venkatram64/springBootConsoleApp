package com.venkat;

import com.venkat.model.Product;
import com.venkat.service.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class MyJdbcConsoleAppApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(MyJdbcConsoleAppApplication.class);

	@Autowired
	private ProductDao productDao;

	public static void main(String[] args) {
		SpringApplication.run(MyJdbcConsoleAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		logger.trace("Run method execution is started.");
		List<Product> productList = productDao.getAll();

		productList.forEach(p ->{
			System.out.println(p.getProductId());
			System.out.println(p.getProductName());
			System.out.println(p.getModelYear());
			System.out.println(p.getListPrice());
		});
	}
}
