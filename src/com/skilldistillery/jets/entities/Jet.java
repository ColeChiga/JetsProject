package com.skilldistillery.jets.entities;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;
	
//constructor
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}


//model
	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}


//speed
	public double getSpeed() {
		return speed;
	}



	public void setSpeed(double speed) {
		this.speed = speed;
	}


//range
	public int getRange() {
		return range;
	}



	public void setRange(int range) {
		this.range = range;
	}


//price
	public long getPrice() {
		return price;
	}



	@Override
	public abstract String toString() ;


	public void setPrice(long price) {
		this.price = price;
	}



	public abstract void fly();
	
}
