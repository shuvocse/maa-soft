package com.MaaSoft.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {
	
	@GetMapping(value="/")
	public String homeIndex(){
		return "home/home";
	}

}
