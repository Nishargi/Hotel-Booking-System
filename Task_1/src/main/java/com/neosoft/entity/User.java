package com.neosoft.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
	
	 @Id
	 private String userName;
	 
	 private String userFirstName;
	 
	 private String userLastName;
	 
	 private String userEmail;
		
	 private String userPassword;
	 
	 // Many users may have many different roles
	 // Fetch Type = EAGER -> When  we retrieve a User_ID from the database,
	 // we'll also automatically retrieve all of its corresponding Roles as well.
	 // cascadeType.ALL = Defines the set of cascadable operations that are propagated 
	 // to the associated entity
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinTable(name = "USER_ROLE",
	    joinColumns = { @JoinColumn(name = "USER_ID")
	       },
	    inverseJoinColumns = { @JoinColumn(name = "ROLE_ID")
	       }
	    )
	 private Set<Role> role;
	

}
