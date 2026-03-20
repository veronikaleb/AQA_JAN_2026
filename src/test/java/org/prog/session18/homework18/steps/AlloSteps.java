package org.prog.session18.homework18.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.sql.SQLException;
import java.util.List;

public class AlloSteps {
    public static WebDriver driver;
    // Використовуємо екземпляр класу, але переконайся, що всередині DBSteps метод працює зі статичним connection
    private final DBSteps dbSteps = new DBSteps();

    @When("I search for {string} on allo.ua")
    public void searchOnAllo(String product) {
        driver.get("https://allo.ua/");
        // Додаємо явне очікування пошукового рядка
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-form__input")));

        search.sendKeys(product);
        search.sendKeys(Keys.ENTER);
    }

    @Then("I sync first {int} prices with database")
    public void syncPrices(int count) throws SQLException {
        // Чекаємо, поки з'явиться хоча б одна картка товару
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-card")));
        } catch (Exception e) {
            System.out.println("DEBUG: Картки товарів не з'явилися протягом 10 секунд");
        }

        List<WebElement> cards = driver.findElements(By.className("product-card"));
        System.out.println("DEBUG: Found " + cards.size() + " cards on page");

        for (int i = 0; i < count && i < cards.size(); i++) {
            WebElement card = cards.get(i);
            String name = card.findElement(By.className("product-card__title")).getText();
            String priceRaw = card.findElement(By.className("v-pb__cur")).getText();

            System.out.println("DEBUG: Syncing product: " + name + " with price: " + priceRaw);

            // Видаляємо все, крім цифр
            int price = Integer.parseInt(priceRaw.replaceAll("[^0-9]", ""));

            dbSteps.checkOrUpdatePhone(name, price);
        }
    }
}