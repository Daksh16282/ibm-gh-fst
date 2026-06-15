package fst;

class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;

	Car() {
		tyres = 4;
		doors = 4;
	}

	void displayCharacteristics() {
		System.out.println("Color = " + this.color);
		System.out.println("Transmission = " + this.transmission);
		System.out.println("Make = " + this.make);
		System.out.println("Tyres = " + this.tyres);
		System.out.println("Doors = " + this.doors);

	}

	void accelerate() {
		System.out.println("Car is moving forward");
	}

	void brake() {
		System.out.println("Car has stopped");
	}
}

public class Activity1 {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.make = 14;
		myCar.color = "Black";
		myCar.transmission = "Manual";

		myCar.displayCharacteristics();
		myCar.accelerate();
		myCar.brake();

	}

}
