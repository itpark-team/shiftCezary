package com.company;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя,!?0123456789 _()";

        System.out.print("введите строку для шифрования: ");
        String originalString = scanner.nextLine();

        System.out.print("введите ключ для шифрования: ");
        int key = scanner.nextInt();

        String encryptedString = "";
        for (int i = 0; i < originalString.length(); i++) {
            char currentSymbol = originalString.charAt(i);
            int foundIndex = alphabet.indexOf(currentSymbol);

            if (foundIndex != -1) {
                int newIndex = (foundIndex + key) % alphabet.length();
                encryptedString += alphabet.charAt(newIndex);
            } else {
                encryptedString += currentSymbol;
            }
        }

        System.out.println("зашифрованный текст = " + encryptedString);

        String decryptedString = "";
        for (int i = 0; i < encryptedString.length(); i++) {
            char currentSymbol = encryptedString.charAt(i);
            int foundIndex = alphabet.indexOf(currentSymbol);

            if (foundIndex != -1) {

                int newIndex = (foundIndex - key % alphabet.length() + alphabet.length()) % alphabet.length();

                /*int newIndex = foundIndex - key % alphabet.length();
                if (newIndex < 0) {
                    newIndex = alphabet.length() - newIndex;
                }*/
                decryptedString += alphabet.charAt(newIndex);
            } else {
                decryptedString += currentSymbol;
            }
        }

        System.out.println("расшифрованный текст = " + decryptedString);
    }
}
