package com.MaaSoft.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MaaSoft.chainType.ChainTypeDao;
import com.MaaSoft.chainType.ChainTypeEntity;
import com.MaaSoft.customer.CustomerEntity;
import com.MaaSoft.machineType.MachineTypeDao;
import com.MaaSoft.machineType.MachineTypeEntity;

@Service
public class VoucherService {
	@Autowired
	private ChainTypeDao chainTypeDao;
	@Autowired
	private VoucherDao voucherDao;
	@Autowired
	private MachineTypeDao machineTypeDao;
	@Transactional
	public void saveVoucher(VoucherDto voucherDto) {
		
		VoucherEntity voucherEntity=new VoucherEntity();
		voucherEntity.setAna(voucherDto.getAna());
		voucherEntity.setVori(voucherDto.getVori());
		voucherEntity.setRoti(voucherDto.getRoti());
		voucherEntity.setPoint(voucherDto.getPoint());
		voucherEntity.setWeightReceive((voucherDto.getVori()*960) + (voucherDto.getAna()*60) + (voucherDto.getRoti()*10) + voucherDto.getPoint());
		
		voucherEntity.setActCutPoint(voucherDto.getActCutPoint());
		voucherEntity.setActInch(voucherDto.getActInch());
		voucherEntity.setWeightReturn(voucherDto.getWeightReturn());
		voucherEntity.setCustomerEntity(new CustomerEntity(100));
		
		
		voucherEntity.setMachineTypeEntity(machineTypeDao.getMachineTypeById(voucherDto.getMachineId()));
		double chainIn=voucherEntity.getMachineTypeEntity().getChainInch();

		
		double estInch=((voucherEntity.getWeightReceive()/60)*chainIn);
		System.err.println("inch"+estInch);
		voucherEntity.setEstInch(estInch);
		
		voucherEntity.setChainTypeEntity(chainTypeDao.getChainTypeById(voucherDto.getChainId()));
		double cutPo=voucherEntity.getChainTypeEntity().getCutPoint();
		double estCutPoint=estInch*cutPo;
		voucherEntity.setEstCutPoint(estCutPoint);
		
		voucherDao.saveVoucher(voucherEntity);
		
	}

	
}
