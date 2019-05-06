package by.bsac.practice5.number2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Individual {
    public static void main(String[] args) throws Exception {
        File ostream = new File("/home/dranser/NewYearPresent.java");
        ArrayList<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(ostream);

        while (sc.hasNextLine()) {
            list.add(sc.nextLine().replace("public","private"));
        }

        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("/home/dranser/NewYearPresent.java", false);
            out = new BufferedWriter(fstream);
            for (String str: list) {
                out.write(str + "\n");
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
