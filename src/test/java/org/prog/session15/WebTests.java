package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

//TODO: load allo.ua (done)
//TODO: search for iphone (done)
//TODO: find prices for first 3 items
//TODO: assert price not null

//TODO: * - confirm goods it not null for first 3 items
//TODO: * - if doing this, use maximize (see below)

public class WebTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void actionsTest() {
        driver.get("https://www.w3schools.com/cssref/tryit.php?filename=trycss_sel_hover");

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("alert('Hello Selenium!')");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiesFrame =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fast-cmp-iframe")));
        driver.switchTo().frame(cookiesFrame);
        //accept cookies
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Accept']")))
                .click();
        driver.switchTo().defaultContent();

        WebElement iFrame = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("iframeResult_0")));
        driver.switchTo().frame(iFrame);

        Actions linkActions = new Actions(driver);
        WebElement link1 = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("w3schools.com")));
        WebElement link2 = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("wikipedia.org")));
        linkActions.moveToElement(link1);
        linkActions.pause(Duration.ofSeconds(5));
        linkActions.moveToElement(link2);
        linkActions.pause(Duration.ofSeconds(5));
        linkActions.perform();
        System.out.println("done!");

    }

    @Test
    public void iFrameTest() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiesFrame =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fast-cmp-iframe")));
        driver.switchTo().frame(cookiesFrame);
        //accept cookies
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Accept']")))
                .click();

        driver.switchTo().defaultContent();
        //switch to iFrame
        WebElement iFrame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iFrame);

        WebElement element =
                webDriverWait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//button[text()='Click Me!']")));
        System.out.println(element.isDisplayed());
    }

    @Test
    public void myWebTest() {
        driver.get("https://www.cloudflare.com/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));

//        WebElement acceptCookies =webDriverWait.until(
//                ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
//        acceptCookies.click();

        webDriverWait
                .until(
                        ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")))
                .click();

        WebElement sideMenu = driver.findElement(By.xpath(
                "//button[@aria-label='Toggle menu']"));
        sideMenu.click();

        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        loginBtn.click();

//        WebElement emailInput = driver.findElement(By.id("email"));
//        emailInput.click();
//        emailInput.sendKeys("test@test.com");
//
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        passwordInput.click();
//        passwordInput.sendKeys("test123");

        System.out.println("done!");
    }
}
