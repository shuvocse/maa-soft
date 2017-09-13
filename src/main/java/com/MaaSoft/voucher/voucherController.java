package com.MaaSoft.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MaaSoft.chainType.ChainTypeService;
import com.MaaSoft.item.ItemDao;
import com.MaaSoft.item.ItemService;
import com.MaaSoft.machineType.MachineTypeService;

@Controller
public class voucherController {
	@Autowired
	private VoucherService voucherService;
	@Autowired
	private ChainTypeService chainTypeService;
	@Autowired
	private MachineTypeService machineTypeService;
	@Autowired
	private ItemService itemService;
	
	
	@GetMapping(value="/voucher")
	public String createVoucher(Model model){
		model.addAttribute("chainTypeList", chainTypeService.getAllChainType());
		model.addAttribute("machineTypeList", machineTypeService.getAllMachineType());
		model.addAttribute("body", "voucher/createVoucher");
		return "layout/default";
	}
	
	@PostMapping(value="/voucher-save")
	@ResponseBody
	public VoucherEntity createVoucher(Model model,@RequestBody VoucherEntity voucherEntity){
		System.err.println(voucherEntity.toString());
		voucherService.saveVoucher(voucherEntity);
		return voucherEntity;
	}
	
	@GetMapping(value="/voucher/{id}")
	public String showVoucher(Model model, @PathVariable int id){
		
		model.addAttribute("itemList", itemService.getAllItemByVId(id));
		model.addAttribute("voucher", voucherService.getVoucherById(id));
		model.addAttribute("body", "voucher/show-voucher");
		return "layout/default";
	}

}
