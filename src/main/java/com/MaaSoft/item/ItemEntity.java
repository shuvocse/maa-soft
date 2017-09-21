package com.MaaSoft.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.MaaSoft.chainType.ChainTypeEntity;
import com.MaaSoft.configuration.BaseInfo;
import com.MaaSoft.machineType.MachineTypeEntity;
import com.MaaSoft.voucher.VoucherEntity;

@Entity
@Table(name="item")
public class ItemEntity extends BaseInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	private String estInch;
	private double vori;
	private double ana;
	private double roti;
	private double point;
	private String sWeight;
	private String weight;
	private double estCutPoint;
	private int totalWeight;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="voucherId")
	private VoucherEntity voucherEntity;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="machineId")
	private MachineTypeEntity machineTypeEntity;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="chainTypeId")
	private ChainTypeEntity chainTypeEntity;

	public ItemEntity() {
	}

	public ItemEntity(Integer itemId, String estInch, double vori, double ana, double roti, double point,String sWeight, String weight,
			double estCutPoint, int totalWeight, VoucherEntity voucherEntity, MachineTypeEntity machineTypeEntity,
			ChainTypeEntity chainTypeEntity) {
		this.itemId = itemId;
		this.estInch = estInch;
		this.vori = vori;
		this.ana = ana;
		this.roti = roti;
		this.point = point;
		this.sWeight = sWeight;
		this.weight = weight;
		this.estCutPoint = estCutPoint;
		this.totalWeight = totalWeight;
		this.voucherEntity = voucherEntity;
		this.machineTypeEntity = machineTypeEntity;
		this.chainTypeEntity = chainTypeEntity;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getEstInch() {
		return estInch;
	}

	public void setEstInch(String estInch) {
		this.estInch = estInch;
	}

	public double getVori() {
		return vori;
	}

	public void setVori(double vori) {
		this.vori = vori;
	}

	public double getAna() {
		return ana;
	}

	public void setAna(double ana) {
		this.ana = ana;
	}

	public double getRoti() {
		return roti;
	}

	public void setRoti(double roti) {
		this.roti = roti;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
	

	public String getsWeight() {
		return sWeight;
	}

	public void setsWeight(String sWeight) {
		this.sWeight = sWeight;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public double getEstCutPoint() {
		return estCutPoint;
	}

	public void setEstCutPoint(double estCutPoint) {
		this.estCutPoint = estCutPoint;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	public VoucherEntity getVoucherEntity() {
		return voucherEntity;
	}

	public void setVoucherEntity(VoucherEntity voucherEntity) {
		this.voucherEntity = voucherEntity;
	}

	public MachineTypeEntity getMachineTypeEntity() {
		return machineTypeEntity;
	}

	public void setMachineTypeEntity(MachineTypeEntity machineTypeEntity) {
		this.machineTypeEntity = machineTypeEntity;
	}

	public ChainTypeEntity getChainTypeEntity() {
		return chainTypeEntity;
	}

	public void setChainTypeEntity(ChainTypeEntity chainTypeEntity) {
		this.chainTypeEntity = chainTypeEntity;
	}

	@Override
	public String toString() {
		return "ItemEntity [itemId=" + itemId + ", estInch=" + estInch + ", vori=" + vori + ", ana=" + ana + ", roti="
				+ roti + ", point=" + point + ", weight=" + weight + ", estCutPoint=" + estCutPoint + ", totalWeight="
				+ totalWeight + ", voucherEntity=" + voucherEntity + ", machineTypeEntity=" + machineTypeEntity
				+ ", chainTypeEntity=" + chainTypeEntity + "]";
	}

	
	

}
