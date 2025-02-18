package com.ovsc.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;

	@Column(name = "vehicle_name")
	private String vehicleName;
	
	@Column(name = "vehicle_brand")
	private String vehicleBrand;
	
	@Column(name = "vehicle_model")
	private String vehicleModel;
	
	@Column(name = "service_type")
	private String serviceType;
	
	@Column(name = "problem_description")
	private String problemDescription;
	
	@Column(name = "manufacturing_date")
	private String manufacturingDate;
	
	public Request() {
		
	}
	
	public Request(String vehicleNumber, String vehicleName, String vehicleBrand, String vehicleModel,
			String serviceType, String problemDescription, String manufacturingDate) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.serviceType = serviceType;
		this.problemDescription = problemDescription;
		this.manufacturingDate = manufacturingDate;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
	public String getVehicleModel() {
		return vehicleModel;
	}
	
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getProblemDescription() {
		return problemDescription;
	}
	
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
}



