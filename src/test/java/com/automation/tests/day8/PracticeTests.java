package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Create a class called PracticeTests
 * - setup before/after methods
 * 	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 * 	- in after method - just close webdriver.
 * - create a test called lofinTest
 * 	- go to “Form Authentication” page
 * 	- enter valid credentials
 * 	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”
 */

public class PracticeTests {

    private WebDriver driver;
    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest(){
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);

        BrowserUtils.wait(3);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    @Test
    public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.name("email")).sendKeys("tomsmith@gmail.com",Keys.ENTER);

        String actual =driver.findElement(By.tagName("h4")).getText();
        String expected = "Your e-mail's been sent!";
    }

    @Test
    public void checkboxTest(){
       driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
       BrowserUtils.wait(4);

       checkboxes.get(0).click();

       Assert.assertTrue(checkboxes.get(0).isSelected(),"Checkbox #1 is not selected!");
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //ChromeOptions - use to customize browser for tests
        //ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        //chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

