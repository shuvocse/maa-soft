package com.MaaSoft.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MaaSoft.chainType.ChainTypeDao;
import com.MaaSoft.customer.CustomerDao;
import com.MaaSoft.machineType.MachineTypeDao;

@Service
public class VoucherService {
	@Autowired
	private ChainTypeDao chainTypeDao;
	@Autowired
	private VoucherDao voucherDao;
	@Autowired
	private CustomerDao customerDao;
	@Transactional
	public void saveVoucher(VoucherEntity voucherEntity ) {
		customerDao.saveOrUpdateCustomer(voucherEntity.getCustomerEntity());
	
		
		voucherDao.saveVoucher(voucherEntity);
		
	}
	public VoucherEntity getVoucherById(int id) {
		return voucherDao.getVoucherById(id);
	}
	

	
}
