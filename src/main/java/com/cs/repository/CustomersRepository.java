package com.cs.repository;


import org.springframework.data.repository.CrudRepository;

import com.cs.model.CustomerID;

public interface CustomersRepository extends CrudRepository<CustomerID, String> {

}
