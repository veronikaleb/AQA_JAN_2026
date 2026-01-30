package org.prog.session5;

public class Car {

    public String owner;
    public String plateNumber;

    public void goTo(String destination, int speed) {
        System.out.println("Car owned by " + owner + " with car number " + plateNumber + " is going to " + destination + " at " + speed + " km/h");
    }
}