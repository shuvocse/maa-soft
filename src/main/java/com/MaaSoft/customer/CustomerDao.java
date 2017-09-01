package com.MaaSoft.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class CustomerDao {
	@Autowired
	SessionFactory _sessionFactory;

	public Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	public void saveOrUpdateCustomer(CustomerEntity customerEntity ){
		getSession().saveOrUpdate(customerEntity);
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerEntity> findAll(){
		return getSession().createCriteria(CustomerEntity.class).list();
	}
	
	public CustomerEntity findById(int id){
		return (CustomerEntity)getSession().createCriteria(CustomerEntity.class).add(Restrictions.eq("customerId", id)).uniqueResult();
		
		
	}
	
	public CustomerEntity findByMobile(String mobile){
		return (CustomerEntity)getSession().createCriteria(CustomerEntity.class).add(Restrictions.eq("mobile", mobile)).uniqueResult();
		
		
	}

}
