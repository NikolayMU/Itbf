package org.example;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

    }
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver){

        this.driver = driver;
        webDriverWait =  new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }

}
