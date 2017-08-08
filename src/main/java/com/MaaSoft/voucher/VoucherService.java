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
		
		VoucherEntity voucherEntity=new VoucherEntity();
		voucherEntity.setAna(voucherDto.getAna());
		voucherEntity.setVori(voucherDto.getVori());
		voucherEntity.setRoti(voucherDto.getRoti());
		voucherEntity.setPoint(voucherDto.getPoint());
		voucherEntity.setWeightReceive((voucherDto.getVori()*960) + (voucherDto.getAna()*60) + (voucherDto.getRoti()*10) + voucherDto.getPoint());
		
		
		
		voucherEntity.setMachineTypeEntity(new MachineTypeEntity(voucherDto.getMachineId()));
		double chainIn=voucherEntity.getMachineTypeEntity().getChainInch();
		double estInch=(voucherEntity.getWeightReceive()/60)*chainIn;
		voucherEntity.setEstInch(estInch);
		
		voucherEntity.setChainTypeEntity(new ChainTypeEntity(voucherDto.getChainId()));
		double cutPo=voucherEntity.getChainTypeEntity().getCutPoint();
		
		voucherDao.saveVoucher(voucherEntity);
		
	}

	
}
