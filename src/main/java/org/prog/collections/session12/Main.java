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
        Map<PhoneOwner, Set<Phone>> phoneOwners = new HashMap<>();

        PhoneOwner ben = new PhoneOwner("Ben");
        PhoneOwner alice = new PhoneOwner("Alice");

        Set<Phone> bensPhones = new HashSet<>();
        bensPhones.add(new Phone("iPhone 17 Pro"));
        bensPhones.add(new Phone("Samsung Galaxy S26"));
        bensPhones.add(new Phone("iPhone 17 Pro"));

        phoneOwners.put(ben, bensPhones);

        Set<Phone> alicesPhones = new HashSet<>();
        alicesPhones.add(new Phone("Google Pixel 10"));
        phoneOwners.put(alice, alicesPhones);

        Set<Phone> alicesSet = phoneOwners.get(new PhoneOwner("Alice"));
        if (alicesSet != null) {
            alicesSet.add(new Phone("iPhone 17 Air"));
            alicesSet.add(new Phone("Xiaomi 16 Ultra"));
        }

        System.out.println("Phones for Ben: " + phoneOwners.get(new PhoneOwner("Ben")));
        System.out.println("Phones for Alice: " + phoneOwners.get(new PhoneOwner("Alice")));
    }
}