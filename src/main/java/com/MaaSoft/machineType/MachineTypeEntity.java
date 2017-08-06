package com.MaaSoft.machineType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.MaaSoft.configuration.BaseInfo;

@Entity
@Table(name="machine_type")
public class MachineTypeEntity extends BaseInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer machineId;
	private String machineName;
	private String chainInch;
	
	public MachineTypeEntity() {
	}

	public MachineTypeEntity(String machineName, String chainInch) {
		this.machineName = machineName;
		this.chainInch = chainInch;
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getChainInch() {
		return chainInch;
	}

	public void setChainInch(String chainInch) {
		this.chainInch = chainInch;
	}
	
	

}
