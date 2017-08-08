package com.MaaSoft.voucher;

public class VoucherDto {
	private Integer customerId;
	private Integer chainId;
	private double cutPoint;
	private Integer machineId;
	private double chainInch;
	private double vori;
	private double ana;
	private double roti;
	private double point;
	private double weightReceive;
	private double weightReturn;
	private double estInch;
	private double actInch;
	private double estCutPoint;
	private double actCutPoint;
	
	
	public VoucherDto() {
	}


	public VoucherDto(Integer customerId, Integer chainId, double cutPoint, Integer machineId, double chainInch,
			double vori, double ana, double roti, double point, double weightReceive, double weightReturn,
			double estInch, double actInch, double estCutPoint, double actCutPoint) {
		this.customerId = customerId;
		this.chainId = chainId;
		this.cutPoint = cutPoint;
		this.machineId = machineId;
		this.chainInch = chainInch;
		this.vori = vori;
		this.ana = ana;
		this.roti = roti;
		this.point = point;
		this.weightReceive = weightReceive;
		this.weightReturn = weightReturn;
		this.estInch = estInch;
		this.actInch = actInch;
		this.estCutPoint = estCutPoint;
		this.actCutPoint = actCutPoint;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Integer getChainId() {
		return chainId;
	}


	public void setChainId(Integer chainId) {
		this.chainId = chainId;
	}


	public double getCutPoint() {
		return cutPoint;
	}


	public void setCutPoint(double cutPoint) {
		this.cutPoint = cutPoint;
	}


	public Integer getMachineId() {
		return machineId;
	}


	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}


	public double getChainInch() {
		return chainInch;
	}


	public void setChainInch(double chainInch) {
		this.chainInch = chainInch;
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
	
	
	

}
