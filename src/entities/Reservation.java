package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("check out date must be after check-in Date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumver() {
		return roomNumber;
	}

	public void setRoomNumver(Integer roomNumver) {
		this.roomNumber = roomNumver;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		//TIME UNIT UTILIZADO PARA CONVERTER DATAS. 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateDates(Date checkIn, Date checkOut)  {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException(" Reservation dates for update must be future dates");

		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("check out date must be after check-in Date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Room :" + roomNumber + ", checkIn: " + sdf.format(checkIn) + " checkOut: " + sdf.format(checkOut)
				+ " , " + duration() + " nights";
	}

}
