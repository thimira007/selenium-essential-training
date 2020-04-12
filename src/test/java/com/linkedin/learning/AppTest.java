package com.linkedin.learning;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
        actions.dragAndDrop(image, drop).build().perform();
        waitFor(5);
        driver.quit();
    }

    @Test
    public void radioButtons() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/radiobutton");

        WebElement radio1 = driver.findElement(By.id("radio-button-1"));
        WebElement radio2 = driver.findElement(By.xpath("//div[@class='form-check']//input[@value='option2']"));
        WebElement radio3 = driver.findElement(By.xpath("//div[@class='form-check']//input[@value='option3']"));
        radio1.click();
        waitFor(2);
        radio2.click();
        waitFor(2);
        radio3.click();
        waitFor(2);
        driver.quit();
    }

    @Test
    public void selectCheckbox() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/checkbox");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='checkbox-2']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='checkbox-3']"));

        selectCheckbox(checkbox1, true);
        waitFor(2);

        selectCheckbox(checkbox3, true);
        waitFor(2);

        selectCheckbox(checkbox2, false);
        waitFor(2);

        selectCheckbox(checkbox1, false);
        waitFor(2);

        selectCheckbox(checkbox3, true);
        waitFor(2);

        driver.quit();
    }

    @Test
    public void datePicker() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/datepicker");
        WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateField.sendKeys("03/02/2020");
        dateField.sendKeys(Keys.ENTER);
        waitFor(2);
        driver.quit();
    }

    @Test
    public void dropDown() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dropdown");
        selectFromDropDown(driver, "Checkbox");
        selectFromDropDown(driver, "Modal");
        driver.quit();
    }

    private void selectFromDropDown(WebDriver driver, String selectOption) {
        WebElement dropdown = driver.findElement(By.id("dropdownMenuButton"));
        dropdown.click();
        waitFor(1);
        String xpath = "//div[@class='dropdown-menu show']/a[text()='" + selectOption + "']";
        WebElement option = driver.findElement(By.xpath(xpath));
        waitFor(1);
        option.click();
        waitFor(2);
        driver.navigate().back();
    }

    private void selectCheckbox(WebElement checkbox, boolean isChecked) {
        if (checkbox.isSelected() == isChecked) {
            System.out.println("Checkbox is already in the given state(isChecked: )" + isChecked + ". " + checkbox);
        } else {
            checkbox.click();
        }
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
