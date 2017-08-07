package com.MaaSoft.machineType;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MaaSoft.machineType.MachineTypeEntity;

@Repository
@Transactional
public class MachineTypeDao {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void saveMachineType(MachineTypeEntity machineTypeEntity) {
		getSession().saveOrUpdate(machineTypeEntity);
		
	}

	@SuppressWarnings("unchecked")
	public  List<MachineTypeEntity> getAllMachineType() {
		Criteria criteria=getSession().createCriteria(MachineTypeEntity.class);
		 return criteria.list();
		
	}

	public MachineTypeEntity getMachineTypeById(int id) {
		Criteria criteria = getSession().createCriteria(MachineTypeEntity.class);
		criteria.add(Restrictions.eq("machineId", id));
		return (MachineTypeEntity) criteria.uniqueResult();
		
		
	}
	
	public void delete(int id){
		getSession().delete(new MachineTypeEntity(id));
	}

}
