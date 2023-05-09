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

			// Declarar uma variavel Date()
			Date now = new Date();

			// Condição se data chechin ou data chechout anterior que data atual mostrar na
			// tela um Error.
			if (chechIn.before(now) || chechOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else 
				// se a data chechout não for posterior que data de chechin não pode ser aceito.

			if (!chechOut.after(chechIn)) {
				System.out.println("Error in reservation: chechout date must be after chechin date");
			} else {
				// Ai sim faço atualização!
				reservation.updateDate(chechIn, chechOut);
				System.out.println(reservation);
			}

		}

		sc.close();

	}

}
