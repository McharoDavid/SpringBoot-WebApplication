package com.mcharoprojects.springboot.SpringBootWebApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomersController {
	
	@Autowired
	CustomersRepo repo;
	
	@RequestMapping("/")
	public String CustomersHandler() {
		return "enterCustomers";
	}
	
	@RequestMapping("/enterCustomer")
	public String CustomersHandler(Customers customers) {
		
		repo.save(customers);
		return "enterCustomers";
	}
	
	@RequestMapping("/searchCustomer")
	public String SearchCustomers() {
		
		return "searchCustomer";
	}
	
	@PostMapping("/searchCustomer")
	public ModelAndView ViewCustomer(@RequestParam("cid") int customerID ) {
		
		Customers customer = repo.findById(customerID).orElse(null);
		ModelAndView mv = new ModelAndView("retrive");
		mv.addObject(customer);
		return mv;
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers() {
		
		return repo.findAll();
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomers(@PathVariable("cid") int cid) {
		
		return repo.findById(cid);
	}
	
	@PostMapping("/customers")
	public Customers PostCustomers(@RequestBody Customers customers) {
		
		repo.save(customers);
		
		return customers;
	}
	
	@DeleteMapping("/customers/{cid}")
	public Customers DeleteCustomers(@PathVariable("cid") int customersID) {
		
		Customers c = repo.getOne(customersID);
		repo.delete(c);
		return c;
	}
	
	@PutMapping(path = "/customers", consumes = {"application/json"})
	public Customers UpdateCustomers(@RequestBody Customers customers) {
		
		repo.save(customers);
		return customers;
	}

}
