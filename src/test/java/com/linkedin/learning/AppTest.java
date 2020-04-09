package com.linkedin.learning;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void keyAndMousePressTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/keypress");

        driver.findElement(By.id("name")).sendKeys("Thimira");
        driver.findElement(By.id("button")).click();

        driver.quit();
    }

    @Test
    public void autoCompleteTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebElement address = driver.findElement(By.id("autocomplete"));
        address.sendKeys("123");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='pac-container pac-logo']//div[@class='pac-item']"));
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
        }

        driver.quit();
    }

    @Test
    public void scrollTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/scroll");
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        waitFor(3);
        name.sendKeys("THIMIRA Navarathna");
        driver.findElement(By.id("date")).sendKeys("02/01/2020");
        waitFor(3);
        driver.quit();
    }

    @Test
    public void switchWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");
        driver.findElement(By.id("new-tab-button")).click();

        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        waitFor(2);
        driver.close();
        waitFor(2);
        driver.switchTo().window(originalHandle);
        driver.close();
        waitFor(2);
        driver.quit();
    }

    @Test
    public void switchAlert() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();
        String originalHandle = driver.getWindowHandle();
        waitFor(2);
        driver.switchTo().alert().accept();
        waitFor(2);
        alertButton.click();
        driver.quit();
    }

    @Test
    public void executeJavaScript() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/modal");

        driver.findElement(By.id("modal-button")).click();
        waitFor(2);
        WebElement closeButton = driver.findElement(By.id("close-button"));
//        closeButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);
        waitFor(2);

        driver.quit();
    }

    @Test
    public void dragAndDrop() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement image = driver.findElement(By.id("image"));
        WebElement drop = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image,drop).build().perform();
        waitFor(5);
        driver.quit();
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
