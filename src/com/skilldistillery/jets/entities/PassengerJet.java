package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		double time = this.getRange() / this.getSpeed();

		System.out.printf("%s,\tTime in the air= %.2f hours.%n", this.toString(), time);
	}

	public String fileFormat() {
		return "Passenger, " + getModel() + ", " + getSpeed() + ", " + getRange() + ", " + getPrice() + "\n";
	}

	@Override
	public String toString() {
		return String.format("%s%s%s%,.2f%s%,d%s%,d", "Passenger Jet:\tModel= ", getModel(), ",\tSpeed= ",
				getSpeed(), " mph,\tRange= ", getRange(), " miles,\tPrice= $", getPrice());
	}

}
