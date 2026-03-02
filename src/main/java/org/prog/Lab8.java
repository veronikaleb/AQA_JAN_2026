package org.prog;

import java.util.*;

public class Lab8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. ASCII <-> бінарний код
        System.out.println("Enter text for ASCII <-> binary:");
        String text = sc.nextLine().toLowerCase();
        System.out.println("Binary:");
        String binary = textToBinary(text);
        System.out.println(binary);
        System.out.println("Back to text:");
        System.out.println(binaryToText(binary));

        // 2. RLE кодування
        System.out.println("\nRLE encoding:");
        String rle = rleEncode(text);
        System.out.println(rle);

        // 3. Шифр Цезаря
        int shift = 3;
        System.out.println("\nCaesar cipher (shift " + shift + "):");
        String encrypted = caesarEncrypt(text, shift);
        System.out.println(encrypted);
        System.out.println("Decrypted:");
        System.out.println(caesarDecrypt(encrypted, shift));

        // 4. Контрольна сума XOR
        System.out.println("\nXOR checksum:");
        byte[] bytes = text.getBytes();
        byte checksum = xorChecksum(bytes);
        System.out.println("Checksum: " + checksum);
        // приклад помилки
        bytes[0] ^= 1; // змінюємо перший байт
        byte newChecksum = xorChecksum(bytes);
        System.out.println("After error, checksum: " + newChecksum);

        // 5. Розбиття на октети по 8 символів
        System.out.println("\nOctets (8 chars, space = new octet, fill 0):");
        List<String> octets = splitIntoOctets(text);
        for (String octet : octets) {
            System.out.println(octet);
        }
    }

    // ====== Методи ======

    // ASCII -> бінарний
    public static String textToBinary(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0')).append(" ");
        }
        return sb.toString().trim();
    }

    // Бінарний -> ASCII
    public static String binaryToText(String binary) {
        String[] parts = binary.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String b : parts) {
            sb.append((char) Integer.parseInt(b, 2));
        }
        return sb.toString();
    }

    // RLE кодування
    public static String rleEncode(String text) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= text.length(); i++) {
            if (i < text.length() && text.charAt(i) == text.charAt(i - 1)) {
                count++;
            } else {
                sb.append(text.charAt(i - 1));
                if (count > 1) sb.append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    // Шифр Цезаря - шифрування
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) sb.append((char) ('a' + (c - 'a' + shift) % 26));
            else sb.append(c);
        }
        return sb.toString();
    }

    // Шифр Цезаря - дешифрування
    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }

    // Контрольна сума XOR
    public static byte xorChecksum(byte[] data) {
        byte cs = 0;
        for (byte b : data) cs ^= b;
        return cs;
    }

    // Розбиття на октети
    public static List<String> splitIntoOctets(String text) {
        List<String> octets = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    while (sb.length() < 8) sb.append('0');
                    octets.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
                if (sb.length() == 8) {
                    octets.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0) while (sb.length() < 8) sb.append('0');
        if (sb.length() > 0) octets.add(sb.toString());
        return octets;
    }
}
