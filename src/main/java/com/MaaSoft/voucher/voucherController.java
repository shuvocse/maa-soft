package com.MaaSoft.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.MaaSoft.chainType.ChainTypeService;
import com.MaaSoft.machineType.MachineTypeService;

@Controller
public class voucherController {
	@Autowired
	private VoucherService voucherService;
	@Autowired
	private ChainTypeService chainTypeService;
	@Autowired
	private MachineTypeService machineTypeService;
	
	@GetMapping(value="/voucher")
	public String createVoucher(Model model){
		VoucherDto voucherDto=new VoucherDto();
		model.addAttribute("voucherDto", voucherDto);
		model.addAttribute("chainTypeList", chainTypeService.getAllChainType());
		model.addAttribute("machineTypeList", machineTypeService.getAllMachineType());
		return "voucher/createVoucher";
	}
	
	@PostMapping(value="/voucher")
	public String createVoucher(Model model, VoucherDto voucherDto){
		voucherService.saveVoucher(voucherDto);
		return "";
	}

}
