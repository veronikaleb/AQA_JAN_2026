package org.prog.session3;

//TODO: Write bubble sort
//TODO: Fill array with random numbers *

import java.util.Arrays;

public class Homework3 {

    public static void main(String[] args) {
        int[] Array = {4, 8, 7, 6, 10, 1, 5, 3, 9, 2};

        System.out.println(Arrays.toString(Array));

        boolean condition = true;
        while (condition) {
            condition = false;
            for (int i = 0; i < Array.length - 1; i++) {
                if (Array[i] > Array[i + 1]) {
                    int temp = Array[i];
                    Array[i] = Array[i + 1];
                    Array[i + 1] = temp;
                    condition = true;
                }
            }
        }
        System.out.println(Arrays.toString(Array));
    }
}