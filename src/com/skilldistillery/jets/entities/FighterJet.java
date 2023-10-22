package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {

	}

	@Override
	public void fly() {
		double time = this.getRange() / this.getSpeed();

		System.out.printf("%s, Time in the air= %.2f hours.%n", this.toString(), time);
	}

	public String fileFormat() {
		return "Fighter, " + getModel() + ", " + getSpeed() + ", " + getRange()+ ", " + getPrice()+ "\n";
	}
	
	@Override
	public String toString() {
		return "Fighter Jet: Model= " + getModel() + ", Speed= " + getSpeed() + " mph, Range= " + getRange()
				+ " miles, Price= $" + getPrice();
	}

}
