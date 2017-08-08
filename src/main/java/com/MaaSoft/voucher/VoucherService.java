package com.MaaSoft.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MaaSoft.chainType.ChainTypeEntity;
import com.MaaSoft.customer.CustomerEntity;
import com.MaaSoft.machineType.MachineTypeEntity;

@Service
public class VoucherService {
	@Autowired
	private VoucherDao voucherDao;

	public void saveVoucher(VoucherDto voucherDto) {
		
		VoucherEntity voucherEntity=new VoucherEntity(voucherDto.getVori(), voucherDto.getAna(), voucherDto.getRoti(),
				voucherDto.getPoint(), new ChainTypeEntity(voucherDto.getChainId()), new MachineTypeEntity(voucherDto.getMachineId()),
				new CustomerEntity(voucherDto.getCustomerId()));
		voucherEntity.setWeightReceive((voucherDto.getVori()*960)+ (voucherDto.getAna()*60)+(voucherDto.getRoti()*6)+voucherDto.getPoint());
		voucherDao.saveVoucher(voucherEntity);
		
	}

	
}
