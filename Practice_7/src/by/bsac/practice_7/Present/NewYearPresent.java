package by.bsac.practice_7.Present;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import by.bsac.practice_7.Candy.Candy;
import by.bsac.practice_7.Candy.ChocolateCandy;
import by.bsac.practice_7.Candy.SugarCandy;
import by.bsac.practice_7.connectionPool.ConnectionPool;

public class NewYearPresent {
    private List<Candy> present;

    public NewYearPresent() {
        present = new ArrayList<>();

        final String READ_PRESENT = "SELECT candy FROM Present";
        final String PRE_READ_CANDY = "SELECT weightOfSugar, weightOfChocolate, weightOfCandy FROM Candy WHERE name = ";

        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(READ_PRESENT);

            while (result.next()) {
                String nameOfCandy = result.getString("candy");
                int weightOfSugar = 0;
                int weightOfChocolate = 0;
                int weightOfCandy = 0;

                Statement statementCandy = connection.createStatement();
                String READ_CANDY = PRE_READ_CANDY + "'" + nameOfCandy + "'";
                ResultSet resultCandy = statementCandy.executeQuery(READ_CANDY);

                while (resultCandy.next()) {
                    weightOfSugar = resultCandy.getInt("weightOfSugar");
                    weightOfChocolate = resultCandy.getInt("weightOfChocolate");
                    weightOfCandy = resultCandy.getInt("weightOfCandy");
                }

                if (weightOfChocolate == 0) {
                    present.add(new SugarCandy(nameOfCandy, weightOfCandy, weightOfSugar));
                } else {
                    present.add(new ChocolateCandy(nameOfCandy, weightOfCandy, weightOfSugar, weightOfChocolate));
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Candy> getPresent() {
        return present;
    }

    public void addCandy(Candy candy) {
        present.add(candy);
    }

    public void sortByName() {
        present.sort(Comparator.comparing(Candy::getName));
    }

    public Candy findFirstCandyByRangeSugar(int low, int high) {
        for (Candy candy : present) {
            if (candy.getWeightOfSugar() >= low && candy.getWeightOfSugar() <= high) {
                return candy;
            }
        }
        return null;
    }

    public int getWeightOfPresent() {
        int weightOfPresent = 0;
        for (Candy candy : present) {
            weightOfPresent += candy.getWeightOfCandy();
        }

        return weightOfPresent;
    }

    @Override
    public String toString() {
        String str = "Present consists of:\n";
        for (Candy candy : present) {
            str += candy.toString() + "\n";
        }
        return str;
    }
}
