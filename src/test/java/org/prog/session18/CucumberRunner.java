package org.prog.session18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session18.steps.DBSteps;
import org.prog.session18.steps.GoogleSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: on allo.ua:
//TODO: search for iphone
//TODO: find 3 first phone prices
//TODO: check if this model is in DB if yes - assert price is same
//TODO: if not in DB -> write to DB phone model and its price

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.prog.session18.steps"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private Connection connection;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );
        DBSteps.connection = connection;

        driver = new ChromeDriver();
        GoogleSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        try {
            connection.close();
        } catch (Exception e) {
        }
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
