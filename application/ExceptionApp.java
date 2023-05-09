package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ExceptionApp {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date chechIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date chechOut = sdf.parse(sc.next());

		// se não for depois chechin da error
		if (!chechOut.after(chechIn)) {
			System.out.println("Error in reservation: chechout date must be after chechin date");
		} else {
			Reservation reservation = new Reservation(number, chechIn, chechOut);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			chechIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			chechOut = sdf.parse(sc.next());

			

			// Ai sim faço atualização!
			String error = reservation.updateDate(chechIn, chechOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				
				System.out.println(reservation);
			}
		}

		sc.close();

	}

}
