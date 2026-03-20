package org.prog.session18.homework18.steps;

import org.testng.Assert;
import java.sql.*;

public class DBSteps {
    public static Connection connection;

    public void checkOrUpdatePhone(String model, int price) throws SQLException {
        String selectQuery = "SELECT price FROM phones WHERE model = ?";
        try (PreparedStatement st = connection.prepareStatement(selectQuery)) {
            st.setString(1, model);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int dbPrice = rs.getInt("price");
                // Перевіряємо, чи ціна така сама
                Assert.assertEquals(price, dbPrice, "Ціна для " + model + " відрізняється!");
                System.out.println("Ціна підтверджена для: " + model);
            } else {
                // Якщо моделі немає — записуємо
                String insertQuery = "INSERT INTO phones (model, price) VALUES (?, ?)";
                try (PreparedStatement insSt = connection.prepareStatement(insertQuery)) {
                    insSt.setString(1, model);
                    insSt.setInt(2, price);
                    insSt.executeUpdate();
                    System.out.println("Додано нову модель: " + model);
                }
            }
        }
    }
}