package entities;

 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    private Integer roomNumber; 
    private Date checkIn; 
    private Date checkOut;


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
      
    }

    public Reservation(Integer roomNumber, java.util.Date checkIn2, java.util.Date checkOut2) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn2;
        this.checkOut = checkOut2;
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
//TIME UNIT É UM ENUM UTILIZADO PARA CONVERTER DATAS. 
return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

}

public void updateDates (Date checkIn, Date checkOut) {
this.checkIn = checkIn; 
this.checkOut = checkOut;

}

@Override
public String toString() {
    return "Room :"
    + roomNumber 
    + ", checkIn: " 
    + sdf.format(checkIn)   
    + " checkOut: " 
    + sdf.format(checkOut) 
    + " , "
    +duration()
    + " nights";
} 





}
