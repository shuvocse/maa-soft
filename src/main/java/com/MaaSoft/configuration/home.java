package com.MaaSoft.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {
	
	@GetMapping(value="/")
	public String homeIndex(Model model){
		model.addAttribute("body", "home/home");
		return "layout/default";
	}

}
