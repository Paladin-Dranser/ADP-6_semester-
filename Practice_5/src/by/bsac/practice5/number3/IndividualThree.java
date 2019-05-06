package by.bsac.practice5.number3;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class IndividualThree {
    public static void main(String[] args) throws Exception {
        File ostream = new File("/home/dranser/file.txt");
        ArrayList<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(ostream);

        while (sc.hasNextLine()) {
            list.add(new StringBuilder(sc.nextLine()).reverse().toString());
        }

        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("/home/dranser/newfile.txt", false);
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
