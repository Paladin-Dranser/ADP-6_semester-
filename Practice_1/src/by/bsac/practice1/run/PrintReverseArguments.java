/* Індывідуальнае заданне (варыянт 2)
   Вывесці ў акно кансолі аргументы каманднага радка ў адваротным парадку */

package by.bsac.practice1.run;

public class PrintReverseArguments {
    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--)
            System.out.println(String.valueOf(i+1) + ' ' + args[i]);
    }
}
