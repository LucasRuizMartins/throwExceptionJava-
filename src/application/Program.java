package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Hello, World!");

        System.out.println("ROOM NUMBER: ");
        Integer number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation check out date must be after check-in Date");

        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            System.out.println();
            System.out.println("Enter data to update reservation");

            System.out.println("Check-in date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("error in reservation: date is wrong ");

            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation check out date must be after check-in Date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation : " + reservation);
            }
        }

    }
}