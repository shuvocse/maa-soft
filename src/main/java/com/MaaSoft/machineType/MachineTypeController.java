package com.MaaSoft.machineType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.MaaSoft.machineType.MachineTypeEntity;
import com.MaaSoft.machineType.MachineTypeService;
@Controller
public class MachineTypeController {
	@Autowired
	private MachineTypeService machineTypeService;
	

	//show list
	@GetMapping(value="/machineType")
	public String showMachineList(Model model){
		model.addAttribute("machineTypeList", machineTypeService.getAllMachineType());
		return "machineType/machineTypeList";
	}
	
	//create 
	@GetMapping(value="/machineType/createMachine")
	public String createMachineType(Model model){
		MachineTypeEntity typeEntity=new MachineTypeEntity();
		model.addAttribute("machineTypeEntity", typeEntity);
		return "machineType/createMachineType";
	}
	@PostMapping(value="/machineType/createMachine")
	public String createMachineType(Model model,@ModelAttribute MachineTypeEntity machineTypeEntity){
		machineTypeService.saveMachineType(machineTypeEntity);
		return "redirect:/machineType";
	}
	
	
	//update
	@GetMapping(value="/machineType/update/{id}")
	public String updateMachineType(Model model,@PathVariable String id){
		MachineTypeEntity machineTypeEntity= machineTypeService.getMachineTypeById(Integer.parseInt(id));
		model.addAttribute("machineTypeEntity", machineTypeEntity);
		return "machineType/updateMachineType";
	}
	
	//delete
	@GetMapping(value="/machineType/delete/{id}")
	public String deleteMachineType(Model model, @PathVariable int id){
		machineTypeService.delete(id);
		return "redirect:/machineType";
	}

}
