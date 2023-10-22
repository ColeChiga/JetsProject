package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(getModel() + " loaded up and ready to deliver!");
	}

	@Override
	public void fly() {
		double time = this.getRange()/this.getSpeed();

		System.out.printf("%s,\tTime in the air= %.2f hours.%n", this.toString(), time );
	}

	public String fileFormat() {
		return "Cargo, " + getModel() + ", " + getSpeed() + ", " + getRange()+ ", " + getPrice() + "\n";
	}
	@Override
	public String toString() {
		return String.format("%s%s%s%,.2f%s%,d%s%,d", "Cargo Plane:\tModel= ", getModel() , ",\tSpeed= " , getSpeed() , "mph,\tRange= " ,getRange()
				, " miles,\tPrice= $" , getPrice());
	}
	
	
}
