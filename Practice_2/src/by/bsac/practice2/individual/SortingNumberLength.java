/**
 * Упарадкаваць і вывесці лікі ў парадку павелічэння (памяншэння) значэнняў іх даўжынь.
 */
package by.bsac.practice2.individual;

import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.LocalTime;

public class SortingNumberLength {
    public static void main(String[] args) {
        System.out.print("Enter the number of elements: ");
        Scanner scan = new Scanner(System.in);
        try {
            int theNumberOfNumbers = scan.nextInt();
            System.out.println(theNumberOfNumbers);
            String[] arrayOfNumbers = new String[theNumberOfNumbers];

            for (int i = 0; i < arrayOfNumbers.length; i++) {
                System.out.println("Enter a number: ");
                arrayOfNumbers[i] = scan.next();
            }
            scan.close();

            System.out.println("You inputed next numbers:");
            System.out.println(Arrays.toString(arrayOfNumbers));

            Arrays.sort(arrayOfNumbers, Comparator.comparingInt(String::length));

            System.out.println("After sorting by the number length:");
            System.out.println(Arrays.toString(arrayOfNumbers));

            Arrays.sort(arrayOfNumbers, Collections.reverseOrder());

            System.out.println("After reverse sorting by the number length:");
            System.out.println(Arrays.toString(arrayOfNumbers));
        } catch (java.util.InputMismatchException error) {
            System.err.println("Input error: " + error);
        }
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("\n\nDeveloper: Antoś Bućko;");
        System.out.println("Get the task: 31.01.2019;");
        System.out.println("Show an answer: " + currentDate + ' ' + currentTime + ";");
    }
}
