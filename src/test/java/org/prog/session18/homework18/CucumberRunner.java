package org.prog.session18.homework18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session18.homework18.steps.AlloSteps;
import org.prog.session18.homework18.steps.DBSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        features = "src/test/resources/features/allo.feature",
        glue = "org.prog.session18.homework18.steps",
        plugin = {"pretty"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private Connection connection;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        // Використовуємо порт 3307, який запрацював у тебе в DBeaver
        String url = "jdbc:mysql://localhost:3307/db?allowPublicKeyRetrieval=true&useSSL=false";
        connection = DriverManager.getConnection(url, "root", "password");

        // Передаємо підключення та драйвер у степи
        DBSteps.connection = connection;
        driver = new ChromeDriver();
        AlloSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() {
        try {
            if (connection != null) connection.close();
            if (driver != null) driver.quit();
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
}
