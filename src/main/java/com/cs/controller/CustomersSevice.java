package com.cs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.model.CustomerToken;
import com.cs.service.CustomersDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomersSevice {
	public static final Logger LOG=LoggerFactory.getLogger(CustomersSevice.class);
	
    @Autowired
    private CustomersDetailsService customersService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveCustomer(@RequestBody CustomerToken customerToken) {
    	LOG.info("adding customerToken : "+customerToken.getId());
        return customersService.saveCustomer(customerToken);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/{customer-id}")
    public CustomerToken getCustomer(@PathVariable("customer-id") String customerId) {
    	LOG.info("fetching customerToken : "+customerId);
        return customersService.getCustomer(customerId);
    }
}