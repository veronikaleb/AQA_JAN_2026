package org.prog.session2;

import java.util.Random;

// TODO: write cycle where:
// - On each cycle generate random i and random j up to 1000
// - If (i - j) % 7 == 0 -> stop the cycle (use break)

public class homework2 {

    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            int i = random.nextInt(1000);
            int j = random.nextInt(1000);
            System.out.println(" i=" + i + ", j=" + j + " (Result: " + (i - j) + ")");
            if ((i - j) % 7 == 0) {
                System.out.println("BREAK ON (i - j) % 7 == 0");
                break;
            }
        }
    }
}
