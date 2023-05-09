package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date chechIn;
	private Date chechout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date chechin, Date chechout) {

		this.roomNumber = roomNumber;
		this.chechIn = chechin;
		this.chechout = chechout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChechin() {
		return chechIn;
	}

	public Date getChechout() {
		return chechout;
	}

	public long duration() {
		long diff = chechout.getTime() - chechIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDate(Date chechIn, Date checkOut) {

		// Declarar uma variavel Date()
		Date now = new Date();

		// Condição se data chechin ou data chechout anterior que data atual mostrar na
		// tela um Error.
		if (chechIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
			// se a data chechout não for posterior que data de chechin não pode ser aceito.

		if (!checkOut.after(chechIn)) {
			return "Chechout date must be after chechin date";
		}
		
		this.chechIn = chechIn;
		this.chechout = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Reservation: " + "Room " + roomNumber + ", chech-in: " + sdf.format(chechIn) + ", chech-out: "
				+ sdf.format(chechout) + ", " + duration() + " nigths";

	}

}
