package com.venkat.repository;

import com.venkat.model.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("select * from customers where last_name = :firstName")
    List<Customer> findByLastName(@Param("firstName") String lastName);
}
