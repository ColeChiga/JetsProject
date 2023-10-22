package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(getModel() + " is off and heading to battle!");
	}

	@Override
	public void fly() {
		double time = this.getRange() / this.getSpeed();

		System.out.printf("%s,\tTime in the air= %.2f hours.%n", this.toString(), time);
	}

	public String fileFormat() {
		return "Fighter, " + getModel() + ", " + getSpeed() + ", " + getRange()+ ", " + getPrice()+ "\n";
	}
	
	@Override
	public String toString() {
		return String.format("%s%s%s%,.2f%s%,d%s%,d", "Fighter Jet:\tModel= ", getModel() , ",\tSpeed= " , getSpeed() , " mph,\tRange= " ,getRange()
				, " miles,\tPrice= $" , getPrice());
	}

}
