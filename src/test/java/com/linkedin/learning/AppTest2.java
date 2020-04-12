package com.linkedin.learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppTest2 {

    @Test
    public void formTestWithFixedWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Thimira");
        driver.findElement(By.id("last-name")).sendKeys("Navarathna");
        driver.findElement(By.id("job-title")).sendKeys("Software Test Automation Engineer");
        driver.findElement(By.id("radio-button-3")).click();
        driver.findElement(By.id("checkbox-1")).click();
        Select experience = new Select(driver.findElement(By.id("select-menu")));
        experience.selectByVisibleText("5-9");
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("02/03/2020");
        datePicker.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div//a[@role='button'][text()='Submit']")).click();

        Wait.waitFor(2);
        WebElement successMessage = driver.findElement(By.xpath("//div//div[@role='alert']"));
        Assert.assertEquals("The form was successfully submitted!", successMessage.getText(), "Message NOT matched!");

        driver.quit();
    }

    @Test
    public void formTestWithImplicitWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Thimira");
        driver.findElement(By.id("last-name")).sendKeys("Navarathna");
        driver.findElement(By.id("job-title")).sendKeys("Software Test Automation Engineer");
        driver.findElement(By.id("radio-button-3")).click();
        driver.findElement(By.id("checkbox-1")).click();
        Select experience = new Select(driver.findElement(By.id("select-menu")));
        experience.selectByVisibleText("5-9");
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("02/03/2020");
        datePicker.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div//a[@role='button'][text()='Submit']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//div//div[@role='alert']"));
        Assert.assertEquals("The form was successfully submitted!", successMessage.getText(), "Message NOT matched!");

        driver.quit();
    }

    @Test
    public void formTestWithExplicitWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Thimira");
        driver.findElement(By.id("last-name")).sendKeys("Navarathna");
        driver.findElement(By.id("job-title")).sendKeys("Software Test Automation Engineer");
        driver.findElement(By.id("radio-button-3")).click();
        driver.findElement(By.id("checkbox-1")).click();
        Select experience = new Select(driver.findElement(By.id("select-menu")));
        experience.selectByVisibleText("5-9");
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("02/03/2020");
        datePicker.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div//a[@role='button'][text()='Submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@role='alert']")));
        Assert.assertEquals("The form was successfully submitted!", successMessage.getText(), "Message NOT matched!");

        driver.quit();
    }
}
