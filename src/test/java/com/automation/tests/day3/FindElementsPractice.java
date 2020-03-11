package com.automation.tests.day3;


import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");


        WebElement signUp = driver.findElement(By.name("wooden spoon"));
        signUp.submit();

        String expected = "Thank you for signing up.Click the button below to return to the home page";

        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText();



        driver.quit();

    }
}
