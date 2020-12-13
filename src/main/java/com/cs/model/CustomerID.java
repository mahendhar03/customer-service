package com.cs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table
public class CustomerID {
	@Id
    private String id;
    private int type;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String emailId;
    private String activationDate;
    private Status status;
    
}
