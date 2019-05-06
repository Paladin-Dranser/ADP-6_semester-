package by.bsac.practice4.individual;

import java.util.Scanner;

public class Individual {
    public static void main(String[] args) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Enter a string:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        // print 2 spaces between words
        String stringWithTwoSpaces = String.join("  ", string.split("\\s+")).trim();
        System.out.println(stringWithTwoSpaces);

        for (int i = 0; i < stringWithTwoSpaces.length(); i++) {
            if (stringWithTwoSpaces.charAt(i) != ' ') {
                System.out.print(alphabet.indexOf(stringWithTwoSpaces.toLowerCase().charAt(i)) + 1);
            } else {
                System.out.print(stringWithTwoSpaces.charAt(i));
            }
        }
    }
}
