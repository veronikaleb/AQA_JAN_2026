package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//TODO: load allo.ua (done)
//TODO: search for iphone (done)
//TODO: find prices for first 3 items
//TODO: assert price not null

//TODO: * - confirm goods it not null for first 3 items
//TODO: * - if doing this, use maximize (see below)

public class Homework15 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void alloIphoneTest() {
        driver.get("https://allo.ua/");

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-form__input")));
        searchInput.sendKeys("iphone");
        searchInput.submit();

        // Чекаємо завантаження списку товарів
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".products-layout__item")));

        // Отримуємо список усіх знайдених товарів
        List<WebElement> productItems = driver.findElements(By.cssSelector(".products-layout__item"));

        // Перевіряємо перші 3 товари
        int itemsToCheck = Math.min(3, productItems.size());

        // Переконуємось, що ми знайшли хоча б один товар перед циклом
        Assert.assertTrue(itemsToCheck > 0, "Товари не знайдені на сторінці!");

        for (int i = 0; i < itemsToCheck; i++) {
            WebElement currentItem = productItems.get(i);

            // Перевіряємо, що сам об'єкт товару (заголовок/посилання) існує
            WebElement itemTitle = currentItem.findElement(By.cssSelector(".product-card__title"));
            Assert.assertNotNull(itemTitle, "Об'єкт товару (заголовок) null для позиції " + (i + 1));
            Assert.assertFalse(itemTitle.getText().isEmpty(), "Назва товару порожня для позиції " + (i + 1));

            WebElement itemPrice = currentItem.findElement(By.cssSelector(".v-pb__cur"));
            Assert.assertNotNull(itemPrice, "Елемент ціни null для позиції " + (i + 1));

            String priceValue = itemPrice.getText();
            Assert.assertFalse(priceValue.isEmpty(), "Текст ціни порожній для позиції " + (i + 1));

            // Вивід для самоперевірки в консоль
            System.out.println("Товар #" + (i + 1) + ": " + itemTitle.getText() + " | Ціна: " + priceValue);
        }
    }
}