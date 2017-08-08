package com.MaaSoft.chainType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.MaaSoft.configuration.BaseInfo;

@Entity
@Table(name="chain_type")
public class ChainTypeEntity extends BaseInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer chainId;
	private String chainName;
	private double cutPoint;
	
	
	public ChainTypeEntity() {
	}
	

	public ChainTypeEntity(Integer chainId) {
		this.chainId = chainId;
	}


	public ChainTypeEntity(String chainName, double cutPoint) {
		this.chainName = chainName;
		this.cutPoint = cutPoint;
	}

	public Integer getChainId() {
		return chainId;
	}

	public void setChainId(Integer chainId) {
		this.chainId = chainId;
	}

	public String getChainName() {
		return chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}

	public double getCutPoint() {
		return cutPoint;
	}

	public void setCutPoint(double cutPoint) {
		this.cutPoint = cutPoint;
	}

	
	
	

}
