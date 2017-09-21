package com.MaaSoft.voucher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.MaaSoft.configuration.BaseInfo;
import com.MaaSoft.customer.CustomerEntity;

@Entity
@Table(name="voucher")
public class VoucherEntity extends BaseInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer voucherId;
	private double point;
	private double v_vori;
	private double v_ana;
	private double v_roti;
	private double v_point;
	private double totalActCutPoint;
	private int totalWeight;
	private String sTotalWeight;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="customerId")
	private CustomerEntity customerEntity;
	public VoucherEntity() {
	}
	public VoucherEntity(Integer voucherId, double point, double v_vori, double v_ana, double v_roti, double v_point,
			double totalActCutPoint, int totalWeight, String sTotalWeight, CustomerEntity customerEntity) {
		this.voucherId = voucherId;
		this.point = point;
		this.v_vori = v_vori;
		this.v_ana = v_ana;
		this.v_roti = v_roti;
		this.v_point = v_point;
		this.totalActCutPoint = totalActCutPoint;
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
	public double getV_vori() {
		return v_vori;
	}
	public void setV_vori(double v_vori) {
		this.v_vori = v_vori;
	}
	public double getV_ana() {
		return v_ana;
	}
	public void setV_ana(double v_ana) {
		this.v_ana = v_ana;
	}
	public double getV_roti() {
		return v_roti;
	}
	public void setV_roti(double v_roti) {
		this.v_roti = v_roti;
	}
	public double getV_point() {
		return v_point;
	}
	public void setV_point(double v_point) {
		this.v_point = v_point;
	}
	public double getTotalActCutPoint() {
		return totalActCutPoint;
	}
	public void setTotalActCutPoint(double totalActCutPoint) {
		this.totalActCutPoint = totalActCutPoint;
	}
	public int getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}
	public String getsTotalWeight() {
		return sTotalWeight;
	}
	public void setsTotalWeight(String sTotalWeight) {
		this.sTotalWeight = sTotalWeight;
	}
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	@Override
	public String toString() {
		return "VoucherEntity [voucherId=" + voucherId + ", point=" + point + ", v_vori=" + v_vori + ", v_ana=" + v_ana
				+ ", v_roti=" + v_roti + ", v_point=" + v_point + ", totalActCutPoint=" + totalActCutPoint
				+ ", totalWeight=" + totalWeight + ", sTotalWeight=" + sTotalWeight + ", customerEntity="
				+ customerEntity + "]";
	}
	
	

	
	

}
