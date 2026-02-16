package org.prog.homework10;

// TODO: Create MyPhoneException (parent - RuntimeException)
// TODO: In each phone (Apple and Android) in hash code and equals:
// TODO: - if model or color are null -> throw MyPhoneException
// TODO: - Intercept that exception and print "oops!"

public class Main {
    public static void main(String[] args) {
        System.out.println("In each phone (Apple and Android) in hash code and equals:");
        System.out.println("\n=== Apple Check ===");
        Apple myApple = new Apple();
        myApple.model = "17 Pro";
        myApple.color = "Titanium";

        try {
            System.out.println("Checking Apple hashCode...");
            int hash = myApple.hashCode();
            System.out.println("Apple hash code: " + hash);
        } catch (MyPhoneException e) {
            System.out.println("oops!");
        }

        System.out.println("\n=== Android Check ===");
        Android myAndroid = new Android();
        myAndroid.model = "Samsung A57";
        myAndroid.color = null;

        try {
            System.out.println("Checking Android equals...");
            myAndroid.equals(new Android());
        } catch (MyPhoneException e) {
            System.out.println("oops!");
        }
    }
}