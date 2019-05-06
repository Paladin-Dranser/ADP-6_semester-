package by.bsac.practice5.number1;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Individual {
    public static void main(String[] args) throws Exception {
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("/home/dranser/out.txt", false);
            out = new BufferedWriter(fstream);
            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                int number = rand.nextInt(100);
                number++;
                out.write(String.valueOf(number) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        File ostream = new File("/home/dranser/out.txt");
        Scanner sc = new Scanner(ostream);

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        try {
            FileWriter fstream = new FileWriter("/home/dranser/out.txt", false);
            out = new BufferedWriter(fstream);
            for (Integer number : list) {
                out.write(String.valueOf(number) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
