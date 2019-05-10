package by.bsac.practice_7.Candy;

import by.bsac.practice_7.connectionPool.ConnectionPool;

import java.sql.*;

public class MariadbCandyDAO {
    private static final String CREATE_PRESENT = "INSERT INTO Candy (name, weightOfSugar, weightOfChocolate, weightOfCandy) VALUES (?,?,?,?)";

    public int create(Candy candy) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_PRESENT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, candy.getName());
            preparedStatement.setInt(2, candy.getWeightOfSugar());

            if (candy instanceof ChocolateCandy) {
                preparedStatement.setInt(3, ((ChocolateCandy) candy).getWeightOfChocolate());
            } else {
                preparedStatement.setInt(3, 0);
            }

            preparedStatement.setInt(4, candy.getWeightOfCandy());

            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();

            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception ex) {
                System.out.println("Error! Closing result: " + ex.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println("Error! Closing prepared statement: " + sse.getMessage());
            }
            try {
                connection.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }

        return -1;
    }
}
