package com.linkedin.learning;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
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
    public void scrollTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/scroll");
        WebElement name  = driver.findElement(By.xpath("//input[@id='name']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        waitFor(3);
        name.sendKeys("THIMIRA Navarathna");
        driver.findElement(By.id("date")).sendKeys("02/01/2020");
        waitFor(3);
        driver.quit();
    }

    private void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
