package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		double time = this.getRange()/this.getSpeed();
		
		System.out.println(this.toString() + " Time in the air=" + time + " hours.");
	}

	@Override
	public String toString() {
		return "Passenger Jet: Model=" + getModel() + ", Speed=" + getSpeed() + " mph, Range=" + getRange()
				+ " miles, Price= $" + getPrice() + "]";
	}

}
