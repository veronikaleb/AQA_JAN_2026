package org.prog.collections.session12;

import java.util.*;

//TODO: Write Map that will allow multiple different people to own several unique phones each
//TODO: * - I should be able to find phones for new Owner("Name_Of_Owner");
//TODO: Map<...> phoneOwners = new HashMap<>();
//TODO: phoneOwners.put(owner1, ...);
//TODO: phoneOwners.put(owner2, ...);
//TODO: phoneOwners.put(owner3, ...);
//TODO: phoneOwners.get(new PhoneOwner("ownerName")) -> {}

public class Main {
    public static void main(String[] args) {
        List<String> androidPhones = new ArrayList<>(Arrays.asList(
                "Samsung Galaxy S26 Ultra Titanium",
                "Samsung Galaxy S26 Pink Edition",
                "Google Pixel 10 Pro XL",
                "Google Pixel 10a Berry",
                "Xiaomi 16 Ultra",
                "OnePlus 14 Pro",
                "Motorola Razr 60 Ultra",
                "Nothing Phone 4",
                "Asus Zenfone 13",
                "Oppo Find X9 Pro"
        ));

        List<String> applePhones = new ArrayList<>(Arrays.asList(
                "iPhone 17 Pro Max",
                "iPhone 17 Air",
                "iPhone 17 Plus Teal",
                "iPhone 17 Pro Gold",
                "iPhone Fold",
                "iPhone 16s Pro",
                "iPhone 16 Deep Purple",
                "iPhone 17 Pro Desert Titanium",
                "iPhone 17 E",
                "iPhone 17 Pro Silver"
        ));

        Map<PhoneOwner, List<String>> phoneOwners = new HashMap<>();

        PhoneOwner owner1 = new PhoneOwner("Ben");
        PhoneOwner owner2 = new PhoneOwner("Alice");
        PhoneOwner owner3 = new PhoneOwner("John");

        phoneOwners.put(owner1, new ArrayList<>(androidPhones.subList(0, 3)));
        phoneOwners.put(owner2, new ArrayList<>(applePhones.subList(0, 2)));
        phoneOwners.put(owner3, new ArrayList<>(androidPhones.subList(4, 7)));

        List<String> result = phoneOwners.get(new PhoneOwner("Ben"));
        List<String> result1 = phoneOwners.get(new PhoneOwner("Alice"));
        List<String> result2 = phoneOwners.get(new PhoneOwner("John"));

        System.out.println("Phones for Ben: " + result);
        System.out.println("Phones for Alice: " + result1);
        System.out.println("Phones for John: " + result2);
    }
}