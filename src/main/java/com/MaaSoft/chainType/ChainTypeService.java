package com.MaaSoft.chainType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChainTypeService {
	@Autowired
	private ChainTypeDao chainTypeDao;

	public void saveChainType(ChainTypeEntity chainTypeEntity) {
		 chainTypeDao.saveChainType(chainTypeEntity);
		
	}

	public List<ChainTypeEntity> getAllChainType() {
		return chainTypeDao.getAllChainType();
	}

	public ChainTypeEntity getChainTypeById(int id) {
		 return chainTypeDao.getChainTypeById(id);
	}

	public void delete(int id) {
		chainTypeDao.delete(id);
	}

	
	

}
