package org.prog;

import java.util.*;
import java.util.stream.Collectors;

public class Lab7 {

    public static void main(String[] args) {
        // 1. Масив чисел
        int[] numbers = {4, 8, 7, 6, 10, 1, 5, 3, 9, 12, 15, 20};
        System.out.println("Original array: " + Arrays.toString(numbers));

        // 2. Фільтрація: парні числа
        int[] evenNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
        System.out.println("Filtered even numbers: " + Arrays.toString(evenNumbers));

        // 3. Сортування: бульбашкове
        bubbleSort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // 4. Групування: парні та непарні
        Map<String, List<Integer>> grouped = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println("Grouped even/odd: " + grouped);

        // 5. Фільтрація >10, сортування спаданням, групування за кількістю цифр
        Map<Integer, List<Integer>> filteredSortedGrouped = Arrays.stream(numbers)
                .filter(n -> n > 10)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy(n -> String.valueOf(n).length()));
        System.out.println("Filtered >10, sorted desc, grouped by digits: " + filteredSortedGrouped);

        // 6. Робота зі списком рядків
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry", "Apricot", "Cherry");
        List<String> filteredWords = words.stream()
                .filter(s -> s.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Filtered words starting with 'A', sorted: " + filteredWords);

        Map<Integer, List<String>> groupedWords = filteredWords.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped words by length: " + groupedWords);
    }

    // Метод бульбашкового сортування
    public static void bubbleSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}