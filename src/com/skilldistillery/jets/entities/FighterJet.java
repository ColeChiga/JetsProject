package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		
	}

	@Override
	public void fly() {
		double time = this.getRange()/this.getSpeed();
		
		System.out.println(this.toString() + " Time in the air=" + time + " hours.");
	}

	@Override
	public String toString() {
		return "Fighter Jet: Model=" + getModel() + ", Speed=" + getSpeed() + " mph, Range=" + getRange()
				+ " miles, Price= $" + getPrice() + "]";
	}

}
