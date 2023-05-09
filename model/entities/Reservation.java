package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date chechin;
	private Date chechout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date chechin, Date chechout) {

		this.roomNumber = roomNumber;
		this.chechin = chechin;
		this.chechout = chechout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChechin() {
		return chechin;
	}

	public Date getChechout() {
		return chechout;
	}
	 public long duration() {
		 long diff = chechout.getTime() - chechin.getTime();
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	 }
	 
	 public void updateDate(Date chechin, Date checout) {
		 this.chechin = chechin;
		 this.chechout = checout;
	 }

	@Override
	public String toString() {
		return "Reservation: " 
				+ "Room " + roomNumber 
				+ ", chech-in: " + sdf.format(chechin)
				+ ", chech-out: " +sdf.format(chechout)
				+ ", " + duration() + " nigths";
				 
	}
	 
	 

}
