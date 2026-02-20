package org.prog.collections.session11;

import java.util.ArrayList;
import java.util.List;

//TODO: Create list of Android phones and list of Apple Phones (10 each)
//TODO: One Android must be pink, NO PINK APPLES
//TODO: One Apple must be gold, NO GOLD ANDROIDS
//TODO: 1. confirm pink android is in the list of androids
//TODO: 2. confirm gold android is NOT in the list of androids
//TODO: 3. Same of pink/gold Apple

public class ListDemo {

    public static void main(String[] args) {
        List<String> androidPhones = new ArrayList<>();
        androidPhones.add("Samsung Galaxy S26 Ultra Titanium");
        androidPhones.add("Samsung Galaxy S26 Pink Edition");
        androidPhones.add("Google Pixel 10 Pro XL");
        androidPhones.add("Google Pixel 10a Berry");
        androidPhones.add("Xiaomi 16 Ultra");
        androidPhones.add("OnePlus 14 Pro");
        androidPhones.add("Motorola Razr 60 Ultra");
        androidPhones.add("Nothing Phone 4");
        androidPhones.add("Asus Zenfone 13");
        androidPhones.add("Oppo Find X9 Pro");

        List<String> applePhones = new ArrayList<>();
        applePhones.add("iPhone 17 Pro Max");
        applePhones.add("iPhone 17 Air");
        applePhones.add("iPhone 17 Plus Teal");
        applePhones.add("iPhone 17 Pro Gold");
        applePhones.add("iPhone Fold");
        applePhones.add("iPhone 16s Pro");
        applePhones.add("iPhone 16 Deep Purple");
        applePhones.add("iPhone 17 Pro Desert Titanium");
        applePhones.add("iPhone 17 E");
        applePhones.add("iPhone 17 Pro Silver");

        System.out.println("Pink Android in list: " + hasColor(androidPhones, "Pink"));
        System.out.println("Gold Android in list: " + hasColor(androidPhones, "Gold"));

        System.out.println("Pink Apple in list: " + hasColor(applePhones, "Pink"));
        System.out.println("Gold Apple in list: " + hasColor(applePhones, "Gold"));
    }

    private static boolean hasColor(List<String> list, String color) {
        for (String phone : list) {
            if (phone.toLowerCase().contains(color.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}