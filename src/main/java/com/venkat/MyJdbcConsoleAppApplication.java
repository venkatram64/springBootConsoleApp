package com.venkat;

import com.venkat.model.Customer;
import com.venkat.model.Product;
import com.venkat.service.CustomerService;
import com.venkat.service.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class MyJdbcConsoleAppApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(MyJdbcConsoleAppApplication.class);

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CustomerService customerService;

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

	@Bean
	public ApplicationRunner applicationRunner(CustomerService customerService){
		return args -> {
			/*Customer customer = new Customer();
			customer.setFirstName("Venkatram");
			customer.setLastName("Veerareddy");
			customer.setEmail("venkat@venkat.com");
			customer.setCity("Hyd");
			customer.setStreet("Narayanaguda");
			customer.setPhone("123 123 1234");
			customer.setState("TS");
			customer.setZipCode("123456");
			Customer customerNew = customerService.create(customer);

			Customer customer2 = new Customer();
			customer2.setFirstName("Srijan");
			customer2.setLastName("Veerareddy");
			customer2.setEmail("srijan@srijan.com");
			customer2.setCity("Hyd");
			customer2.setStreet("Narayanaguda");
			customer2.setPhone("123 123 1234");
			customer2.setState("TS");
			customer2.setZipCode("123456");
			Customer customerNew2 = customerService.create(customer2);*/

			List<Customer> customers = customerService.findByLastName("Veerareddy");
			customers.forEach(c ->{
				System.out.println(c);
			});

		};
	}
}
