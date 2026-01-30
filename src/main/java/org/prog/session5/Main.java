package org.prog.session5;

//TODO: add owner as String
//TODO: make goTo print "car owned by {owner} is going to {destination} at {speed}
//TODO: do not forget to set owner name :)

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();
        car1.owner = CarOwner.Michael;
        car1.plateNumber = "AA2359AA";

        Car car2 = new Car();
        car2.owner = CarOwner.Jacob;
        car2.plateNumber = "BB8590BB";

        Car car3 = new Car();
        car3.owner = CarOwner.Luna;
        car3.plateNumber = "CC3345CC";

        car1.goTo("Boston", 90);
        car2.goTo("New York", 80);
        car3.goTo("Dallas", 100);
    }
}