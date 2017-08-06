package com.MaaSoft.chainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChainTypeController {
	
	@Autowired
	private ChainTypeService chainTypeService;
	

	//show list
	@GetMapping(value="/chainType")
	public String showChainList(Model model){
		model.addAttribute("chainTypeList", chainTypeService.getAllChainType());
		return "chainType/chainTypeList";
	}
	
	//create 
	@GetMapping(value="/chainType/createChain")
	public String createChainType(Model model){
		ChainTypeEntity typeEntity=new ChainTypeEntity();
		model.addAttribute("chainTypeEntity", typeEntity);
		return "chainType/createChainType";
	}
	@PostMapping(value="/chainType/createChain")
	public String createChainType(Model model,@ModelAttribute ChainTypeEntity chainTypeEntity){
		chainTypeService.saveChainType(chainTypeEntity);
		return "redirect:/chainType";
	}
	
	
	//update
	@GetMapping(value="/chainType/update/{id}")
	public String updateChainType(Model model,@PathVariable String id){
		ChainTypeEntity chainTypeEntity= chainTypeService.getChainTypeById(Integer.parseInt(id));
		model.addAttribute("chainTypeEntity", chainTypeEntity);
		return "chainType/updateChainType";
	}
	
	//delete
	@GetMapping(value="/chainType/delete/{id}")
	public String deleteChainType(Model model, @PathVariable int id){
		chainTypeService.delete(id);
		return "redirect:/chainType";
	}

}
