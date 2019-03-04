package com.certiorem.carRenting;

public class Cars {

	private String carBrand;
	private String carModel;
	private int doors;
	private int rentingPricePerDay;
	
	public Cars(String carBrand, String carModel, int doors, int rentingPricePerDay) {
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.doors = doors;
		this.rentingPricePerDay = rentingPricePerDay;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getRentingPricePerDay() {
		return rentingPricePerDay;
	}

	public void setRentingPricePerDay(int rentingPricePerDay) {
		this.rentingPricePerDay = rentingPricePerDay;
	}
	
	public void printCarInfo() {
		System.out.println("Car brand: " + carBrand + "\nCar model: " + carModel + "\nCar doors: " + doors + "\nPrice: " + rentingPricePerDay);
	}
	
	
	
}
