package by.bsac.practice_7;

import by.bsac.practice_7.Candy.Candy;
import by.bsac.practice_7.Present.NewYearPresent;

public class Individual {
    public static void main(String[] args) {
        NewYearPresent present = new NewYearPresent();

        System.out.println(present.toString());
        System.out.println("Weight of this present: " + present.getWeightOfPresent());

        present.sortByName();

        System.out.println(present.toString());

        Candy findedCandy = present.findFirstCandyByRangeSugar(5,13);
        System.out.println("Finded candy: " + findedCandy.toString());
    }
}
