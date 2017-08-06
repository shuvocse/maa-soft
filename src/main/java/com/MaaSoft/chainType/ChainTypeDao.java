package com.MaaSoft.chainType;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class ChainTypeDao {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void saveChainType(ChainTypeEntity chainTypeEntity) {
		getSession().saveOrUpdate(chainTypeEntity);
		
	}

	@SuppressWarnings("unchecked")
	public  List<ChainTypeEntity> getAllChainType() {
		Criteria criteria=getSession().createCriteria(ChainTypeEntity.class);
		 return criteria.list();
		
	}

	public ChainTypeEntity getChainTypeById(int id) {
		Criteria criteria = getSession().createCriteria(ChainTypeEntity.class);
		criteria.add(Restrictions.eq("chainId", id));
		return (ChainTypeEntity) criteria.uniqueResult();
		
		
	}
	
	public void delete(int id){
		getSession().delete(new ChainTypeEntity(id));
	}

	

}
