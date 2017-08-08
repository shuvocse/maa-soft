package com.MaaSoft.voucher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VoucherDao {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void saveVoucher(VoucherEntity voucherEntity) {
		getSession().saveOrUpdate(voucherEntity);
		
	}

}
