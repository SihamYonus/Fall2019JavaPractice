package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class SeleniumOH2 {

    public static void main(String[] args) {

        /*
        1.Go to http://aotomationpractice.com
        2.Search for 'tshirt' in a searchbob + click enter OR click search button
        3.Validate you got 'no result' message on UI
        4.Search for 't-shirt'
        5.Validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        search_box.sendKeys("tshirt" + Keys.ENTER);
        /*
        <p class="alert alert-warning">
					No results were found for your search&nbsp;"tshirt"
			</p>
         */

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        //.getText() ->  It does nt take input but returns String (text) from the element
        System.out.println("Error message: " + errorText);
        //NoSuchElementException -> it means we could not locate the element

        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        //.clear() - (void) - it will delete any values from input box
        search_box.sendKeys("t-shirt",Keys.ENTER);
        //StaleElementReferenceException - elelment is old/stale - we want to find
        //this element again OR refresh page

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: " + count.getText());

        driver.quit();



    }
}
