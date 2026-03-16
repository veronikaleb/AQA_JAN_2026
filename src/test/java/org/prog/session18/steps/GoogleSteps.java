package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSteps {

    public static WebDriver driver;

    @Given("I open google main page")
    public void openGooglePage() {
        driver.get("https://www.google.com/");
    }

    @Given("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        WebElement cookiesLink = driver.findElement(By.xpath("//a[contains(@href,'technologies/cookies')]"));
        if (cookiesLink.isDisplayed()) {
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            buttons.get(buttons.size() - 2).click();
        } else {
            System.out.println("No cookies link found - proceed");
        }
    }

    @Given("I set search field to that person's first and last name")
    public void setSearchFieldToThatPersonFirstAndLastName() throws InterruptedException {
        String firstLastName = DBSteps.randomNames.get(0);
        System.out.println("I will search for " + firstLastName);
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(firstLastName);
        Thread.sleep(1000);
    }
}
