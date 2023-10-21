package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier{

	
	


	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		
	}

	@Override
	public void fly() {
		double time = this.getRange()/this.getSpeed();
		
		System.out.println(this.toString() + " Time in the air=" + time + " hours.");
	}

	@Override
	public String toString() {
		return "Cargo Plane: Model=" + getModel() + ", Speed=" + getSpeed() + " mph, Range=" + getRange()
				+ " miles, Price= $" + getPrice();
	}
	
	
}
