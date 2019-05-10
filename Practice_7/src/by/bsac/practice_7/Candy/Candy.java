package by.bsac.practice_7.Candy;

public class Candy {
    protected String name;
    protected int weightOfCandy;
    protected int weightOfSugar;

    public Candy(String name, int weightOfCandy, int weightOfSugar) {
        this.name = name;
        this.weightOfCandy = weightOfCandy;
        this.weightOfSugar = weightOfSugar;
    }

    public String getName() {
        return name;
    }

    public int getWeightOfCandy() {
        return weightOfCandy;
    }

    public int getWeightOfSugar() {
        return weightOfSugar;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Weight of Candy: " + weightOfCandy
                + " Weight of Sugar: " + weightOfSugar;
    }

    public int compareTo(Candy candy) {
        return name.compareTo(candy.getName());
    }
}
