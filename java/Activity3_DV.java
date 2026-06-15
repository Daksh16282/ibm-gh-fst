package fst;

import java.util.Scanner;

public class Activity3 {

	public static double getEarthYears(long seconds) {

		double earthDays = (seconds / 86400.0);
		double earthYears = earthDays / 365;
		return earthYears;
	}

	public static double getMercuryYears(long seconds) {
		return getEarthYears(seconds) / 0.2402467;
	}

	public static double getVenusYears(long seconds) {
		return getEarthYears(seconds) / 0.61519726;
	}

	public static double getMarsYears(long seconds) {
		return getEarthYears(seconds) / 1.8808158;
	}

	public static double getJupiterYears(long seconds) {
		return getEarthYears(seconds) / 11.862615;
	}

	public static double getSaturnYears(long seconds) {
		return getEarthYears(seconds) / 29.447498;
	}

	public static double getUranusYears(long seconds) {
		return getEarthYears(seconds) / 84.016846;
	}

	public static double getNeptuneYears(long seconds) {
		return getEarthYears(seconds) / 164.79132;
	}

	public static void main(String[] args) {
		System.out.println("Enter age in seconds : ");
		Scanner sc = new Scanner(System.in);
		long seconds = sc.nextLong();
		double earthYears = getEarthYears(seconds);
		System.out.printf("Person is %.2f earth-years old\n", earthYears);
		System.out.printf("Person is %.2f mercury-years old\n", getMercuryYears(seconds));
		System.out.printf("Person is %.2f venus-years old\n", getVenusYears(seconds));
		System.out.printf("Person is %.2f mars-years old\n", getMarsYears(seconds));
		System.out.printf("Person is %.2f jupiter-years old\n", getJupiterYears(seconds));
		System.out.printf("Person is %.2f saturn-years old\n", getSaturnYears(seconds));
		System.out.printf("Person is %.2f uranus-years old\n", getUranusYears(seconds));
		System.out.printf("Person is %.2f neptune-years old\n", getNeptuneYears(seconds));
		sc.close();
	}

}
