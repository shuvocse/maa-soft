package com.MaaSoft.item;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ItemDao {
	@Autowired
	private SessionFactory _sessionFactory;
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}
	
	public ItemEntity saveItem(ItemEntity itemEntity){
		getSession().saveOrUpdate(itemEntity);
		return itemEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemEntity> getAllItemByVId(int voucherId){
		 Criteria criteria= getSession().createCriteria(ItemEntity.class,"ie");
				criteria.createCriteria("ie.voucherEntity", "ve", JoinType.INNER_JOIN);
				criteria.add(Restrictions.eq("ve.voucherId", voucherId));
				return criteria.list();
		
	}

	public void deleteItem(ItemEntity itemEntity) {
		 getSession().delete(itemEntity);;
	}

}
