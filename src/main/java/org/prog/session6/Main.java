package org.prog.session6;

public class Main {
    public static void main(String[] args) {
        Truck myTruck = new Truck();
        myTruck.setTruckInfo("Volvo", "Maksym", "AA1234DC");


        System.out.println(myTruck.getTruckDetails());
        myTruck.delivery("Kyiv", "Vinnytsia");
    }
}