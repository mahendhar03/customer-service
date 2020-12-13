package com.cs.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.model.CustomerID;
import com.cs.model.CustomerToken;
import com.cs.repository.CustomersRepository;

@Service
public class CustomersDetailsService {
    @Autowired
    private CustomersRepository customersRepository;

    public String saveCustomer(CustomerToken customerToken) {
    	CustomerID customerID = new CustomerID();
    	customerID.setId(customerToken.getId());
    	customerID.setType(customerToken.getType());
    	customerID.setActivationDate(customerToken.getActivationDate());
    	customerID.setContactNumber(customerToken.getContactNumber());
    	customerID.setEmailId(customerToken.getEmailId());
    	customerID.setFirstName(customerToken.getFirstName());
    	customerID.setLastName(customerToken.getLastName());
    	customerID.setStatus(customerToken.getStatus());
        return customersRepository.save(customerID).getStatus().name();
    }

	public CustomerToken getCustomer(String customerId) {
		Optional<CustomerID> optional=customersRepository.findById(customerId);
		if (optional.isPresent()) {
			CustomerID customerID=optional.get();
			CustomerToken customerToken=new CustomerToken();
			customerToken.setId(customerID.getId());
			customerToken.setType(customerID.getType());
			customerToken.setActivationDate(customerID.getActivationDate());
			customerToken.setContactNumber(customerID.getContactNumber());
			customerToken.setEmailId(customerID.getEmailId());
			customerToken.setFirstName(customerID.getFirstName());
			customerToken.setLastName(customerID.getLastName());
			customerToken.setStatus(customerID.getStatus());
			return customerToken;
		}else {
			return null;
		}
	}
}
