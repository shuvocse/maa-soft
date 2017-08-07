package com.MaaSoft.machineType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineTypeService {
	@Autowired
	private MachineTypeDao machineTypeDao;

	public List<MachineTypeEntity> getAllMachineType() {
		return machineTypeDao.getAllMachineType();
	}

	public void saveMachineType(MachineTypeEntity machineTypeEntity) {
		machineTypeDao.saveMachineType(machineTypeEntity);
	}

	public MachineTypeEntity getMachineTypeById(int id) {
		return machineTypeDao.getMachineTypeById(id);
	}

	public void delete(int id) {
		machineTypeDao.delete(id);
		
	}

}
