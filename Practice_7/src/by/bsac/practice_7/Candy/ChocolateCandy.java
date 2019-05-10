package by.bsac.practice_7.Candy;

public class ChocolateCandy extends Candy {
    private int weightOfChocolate;

    public ChocolateCandy(String name, int weightOfCandy,
                          int weightOfSugar, int weightOfChocolate) {
        super(name, weightOfCandy, weightOfSugar);
        this.weightOfChocolate = weightOfChocolate;
    }

    public int getWeightOfChocolate() {
        return weightOfChocolate;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Weight of Candy: " + weightOfCandy
                + " Weight of Sugar: " + weightOfSugar
                + " Weight of Chocolate: " + weightOfChocolate;
    }
}
