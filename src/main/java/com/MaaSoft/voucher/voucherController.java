package com.MaaSoft.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "voucher/createVoucher";
	}
	
	@PostMapping(value="/voucher-save")
	@ResponseBody
	public VoucherEntity createVoucher(Model model,@RequestBody VoucherEntity voucherEntity){
		System.err.println(voucherEntity.toString());
		voucherService.saveVoucher(voucherEntity);
		return voucherEntity;
	}

}
