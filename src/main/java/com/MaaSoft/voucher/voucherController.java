package com.MaaSoft.voucher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class voucherController {
	
	@GetMapping(value="/voucher")
	public String createVoucher(Model model){
		return "voucher/createVoucher";
	}

}
