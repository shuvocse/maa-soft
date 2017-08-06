package com.MaaSoft.voucher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.MaaSoft.chainType.ChainTypeEntity;
import com.MaaSoft.configuration.BaseInfo;
import com.MaaSoft.customer.CustomerEntity;
import com.MaaSoft.machineType.MachineTypeEntity;

@Entity
@Table(name="voucher")
public class VoucherEntity extends BaseInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer voucherId;
	private double weightReceive;
	private double weightReturn;
	private double estInch;
	private double actInch;
	private double estCutPoint;
	private double actCutPoint;
	@ManyToOne
	@JoinColumn(name="chainId")
	private ChainTypeEntity chainTypeEntity;
	@ManyToOne
	@JoinColumn(name="machineId")
	private MachineTypeEntity machineTypeEntity;
	@ManyToOne
	@JoinColumn(name="customerId")
	private CustomerEntity customerEntity;
	public VoucherEntity() {
	}
	public VoucherEntity(double weightReceive, double weightReturn, double estInch, double actInch, double estCutPoint,
			double actCutPoint, ChainTypeEntity chainTypeEntity, MachineTypeEntity machineTypeEntity,
			CustomerEntity customerEntity) {
		this.weightReceive = weightReceive;
		this.weightReturn = weightReturn;
		this.estInch = estInch;
		this.actInch = actInch;
		this.estCutPoint = estCutPoint;
		this.actCutPoint = actCutPoint;
		this.chainTypeEntity = chainTypeEntity;
		this.machineTypeEntity = machineTypeEntity;
		this.customerEntity = customerEntity;
	}
	public Integer getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Integer voucherId) {
		this.voucherId = voucherId;
	}
	public double getWeightReceive() {
		return weightReceive;
	}
	public void setWeightReceive(double weightReceive) {
		this.weightReceive = weightReceive;
	}
	public double getWeightReturn() {
		return weightReturn;
	}
	public void setWeightReturn(double weightReturn) {
		this.weightReturn = weightReturn;
	}
	public double getEstInch() {
		return estInch;
	}
	public void setEstInch(double estInch) {
		this.estInch = estInch;
	}
	public double getActInch() {
		return actInch;
	}
	public void setActInch(double actInch) {
		this.actInch = actInch;
	}
	public double getEstCutPoint() {
		return estCutPoint;
	}
	public void setEstCutPoint(double estCutPoint) {
		this.estCutPoint = estCutPoint;
	}
	public double getActCutPoint() {
		return actCutPoint;
	}
	public void setActCutPoint(double actCutPoint) {
		this.actCutPoint = actCutPoint;
	}
	public ChainTypeEntity getChainTypeEntity() {
		return chainTypeEntity;
	}
	public void setChainTypeEntity(ChainTypeEntity chainTypeEntity) {
		this.chainTypeEntity = chainTypeEntity;
	}
	public MachineTypeEntity getMachineTypeEntity() {
		return machineTypeEntity;
	}
	public void setMachineTypeEntity(MachineTypeEntity machineTypeEntity) {
		this.machineTypeEntity = machineTypeEntity;
	}
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
	

}
