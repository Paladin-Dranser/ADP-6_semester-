package by.bsac.practice1.run;

public class PrintArguments {
    public static void main(String[] args) {
        for (String str : args) {
            System.out.printf("Arguments -> %s%n", str);
        }
    }
}
