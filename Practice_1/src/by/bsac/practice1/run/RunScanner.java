package by.bsac.practice1.run;

import java.util.Scanner;

public class RunScanner {
    public static void main(String[] args) {
        System.out.println("Enter your name and press <Enter>:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        scan.close();
        System.out.println("Hello, " + name);
    }
}
