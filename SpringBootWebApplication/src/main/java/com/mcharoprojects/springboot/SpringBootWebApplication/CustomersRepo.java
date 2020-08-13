package com.mcharoprojects.springboot.SpringBootWebApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customers, Integer>{
	
	

}
