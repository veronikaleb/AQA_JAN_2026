package org.prog.homework8;

//TODO: Create IPhone interface
//TODO: Each phone must be able to: void call(String someone);
//TODO: Each phone must be able to: void unlockScreen();
//TODO: Add at least 2 classes that implement phones: Android and Apple
//TODO: Both Apple and Android (or others) must implement IPhone
//TODO: Both Apple and Android must have model and color
//TODO: Add equals and hashcode for both

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Apple IPhone15 = new Apple("15 Pro", "Black");
        Apple IPhone17 = new Apple("17 Pro", "Blue");
        Android Samsung = new Android("Samsung Galaxy Z Trifold", "Gray");
        Android Poco = new Android("Poco F8 Ultra", "Silver");

        System.out.println("\n=== Apple ===");

        IPhone15.unlockScreen();
        IPhone15.call("Manon");

        IPhone17.unlockScreen();
        IPhone17.call("Daniela");

        System.out.println("\n=== Android ===");

        Samsung.unlockScreen();
        Samsung.call("Yoonchae");

        Poco.unlockScreen();
        Poco.call("Lara");

        System.out.println("\n=== Hash Code Apple IPhone 15 Pro===");
        IPhone15.hashCode();

        System.out.println("\n=== Hash Code Apple IPhone 17 Pro===");
        IPhone17.hashCode();

        System.out.println("\n=== Hash Code Android Samsung===");
        Samsung.hashCode();

        System.out.println("\n=== Hash Code Android Poco ===");
        Poco.hashCode();

        System.out.println("\n=== Equals check ===");
        System.out.println("IPhone15 equals IPhone17: " + IPhone15.equals(IPhone17));
        System.out.println("IPhone15 equals samsung: " + IPhone15.equals(Samsung));
        System.out.println("Samsung equals Poco: " + Samsung.equals(Poco));
        System.out.println("IPhone17 equals Poco: " + IPhone17.equals(Poco));
    }
}