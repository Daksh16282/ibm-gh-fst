package fst;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {

	private List<String> passengers;
	private int maxPassengers;
	@SuppressWarnings("unused")
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<String>();
	}

	public void onBoard(String passenger) {
		if (passengers.size() < this.maxPassengers) {
			this.passengers.add(passenger);
		} else {
			System.out.println("Plane is full");
		}
	}

	public Date takeOff() {
		return new Date();
	}

	public void land() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}

	public Date getLastTimeLanded() {
		return this.lastTimeLanded;
	}

	public List<String> getPassengers() {
		return this.passengers;
	}
}

public class Activity6 {

	public static void main(String[] args) {

		Plane plane = new Plane(10);
		plane.onBoard("Person1");
		plane.onBoard("Person2");
		plane.onBoard("Person3");
		plane.onBoard("Person4");
		plane.onBoard("Person5");
		plane.onBoard("Person6");
		plane.onBoard("Person7");
		plane.onBoard("Person8");
		plane.onBoard("Person9");
		plane.onBoard("Person10");

		System.out.println("Plane Took off at " + plane.takeOff());
		System.out.println("Passengers flying are :-");
		for (String passString : plane.getPassengers()) {
			System.out.println(passString);
		}
		System.out.println("Flying....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		plane.land();
		System.out.println("Landed at " + plane.getLastTimeLanded());

	}

}
