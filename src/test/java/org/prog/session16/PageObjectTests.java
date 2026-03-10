package org.prog.session16;

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

//TODO: Re-work you allo.ua tests to use page object

public class PageObjectTests {

    private WebDriver driver;
    private AlloPage alloPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Ініціалізуємо наш Page Object
        alloPage = new AlloPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void alloIphoneTest() {
        alloPage.open();

        alloPage.searchFor("iphone");

        List<WebElement> productItems = alloPage.getProductItems();
        int itemsToCheck = Math.min(3, productItems.size());

        Assert.assertTrue(itemsToCheck > 0, "Товари не знайдені на сторінці!");

        for (int i = 0; i < itemsToCheck; i++) {
            WebElement currentItem = productItems.get(i);

            String title = alloPage.getItemTitle(currentItem);
            String price = alloPage.getItemPrice(currentItem);

            Assert.assertFalse(title.isEmpty(), "Назва товару порожня для позиції " + (i + 1));
            Assert.assertFalse(price.isEmpty(), "Ціна товару порожня для позиції " + (i + 1));

            System.out.println("Товар #" + (i + 1) + ": " + title + " | Ціна: " + price);
        }
    }
}

class AlloPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchInputLocator = By.id("search-form__input");
    private final By productCardsLocator = By.cssSelector(".products-layout__item");
    private final By titleLocator = By.cssSelector(".product-card__title");
    private final By priceLocator = By.cssSelector(".v-pb__cur");

    public AlloPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get("https://allo.ua/");
    }

    public void searchFor(String query) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchInputLocator));
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    public List<WebElement> getProductItems() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productCardsLocator));
        return driver.findElements(productCardsLocator);
    }

    public String getItemTitle(WebElement item) {
        return item.findElement(titleLocator).getText();
    }

    public String getItemPrice(WebElement item) {
        return item.findElement(priceLocator).getText();
    }
}