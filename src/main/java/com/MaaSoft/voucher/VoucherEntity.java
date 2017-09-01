package com.MaaSoft.voucher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.MaaSoft.configuration.BaseInfo;
import com.MaaSoft.customer.CustomerEntity;

@Entity
@Table(name="voucher")
public class VoucherEntity extends BaseInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer voucherId;
	private double point;
	private double totalWeight;
	@Transient
	private String sTotalWeight;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="customerId")
	private CustomerEntity customerEntity;
	public VoucherEntity() {
	}
	public VoucherEntity(Integer voucherId, double point, double totalWeight, CustomerEntity customerEntity) {
		this.voucherId = voucherId;
		this.point = point;
		this.totalWeight = totalWeight;
		this.customerEntity = customerEntity;
	}
	
	
	public String getsTotalWeight() {
		return sTotalWeight;
	}
	public void setsTotalWeight(String sTotalWeight) {
		this.sTotalWeight = sTotalWeight;
	}
	public VoucherEntity(Integer voucherId, double point, double totalWeight, String sTotalWeight,
			CustomerEntity customerEntity) {
		this.voucherId = voucherId;
		this.point = point;
		this.totalWeight = totalWeight;
		this.sTotalWeight = sTotalWeight;
		this.customerEntity = customerEntity;
	}
	public Integer getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Integer voucherId) {
		this.voucherId = voucherId;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	@Override
	public String toString() {
		return "VoucherEntity [voucherId=" + voucherId + ", point=" + point + ", totalWeight=" + totalWeight
				+ ", sTotalWeight=" + sTotalWeight + ", customerEntity=" + customerEntity + "]";
	}
	
	
	
	

}
