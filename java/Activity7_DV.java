package fst;

interface BicycleParts {
	public int tyres = 2;
	public int maxSpeed = 25;
}

interface BicycleOperations {
	public void applyBrake(int decrement);

	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {

	int gears;
	int currentSpeed;

	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void applyBrake(int decrement) {
		this.currentSpeed -= decrement;
	}

	@Override
	public void speedUp(int increment) {
		this.currentSpeed += increment;
	}

	public String bicycleDesc() {
		return ("No of gears are " + this.gears + "\nSpeed of bicycle is " + this.currentSpeed);

	}

}

class MountainBike extends Bicycle {

	int seatHeight;

	public MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
	}

	public void setSeatHeight(int height) {
		this.seatHeight = height;
	}

	@Override
	public String bicycleDesc() {
		return ("No of gears are " + this.gears + "\nSpeed of bicycle is " + this.currentSpeed + " and seat height is "
				+ this.seatHeight);
	}

}

public class Activity7 {

	public static void main(String[] args) {
		MountainBike mountainBike = new MountainBike(3, 0, 25);
		mountainBike.speedUp(25);
		System.out.println(mountainBike.bicycleDesc());
		mountainBike.applyBrake(5);
		System.out.println(mountainBike.bicycleDesc());
	}

}
