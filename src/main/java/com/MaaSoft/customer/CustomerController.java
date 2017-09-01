package com.MaaSoft.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	
	
	@GetMapping("/fetch")
	@ResponseBody
	public CustomerEntity fetchCustomer(@RequestParam (value="mobile") String mobile){
		return customerDao.findByMobile(mobile);	
	}
	

}
