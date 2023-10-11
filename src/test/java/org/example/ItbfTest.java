package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItbfTest {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {

        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeEach
    void setupBrowser() {

        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);

    }
    @Test
    @DisplayName("Тест Itbf")
    @Description("Проверка работоспособности основного функционала на сайте DemoQA")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Тестирование по Чек-листу")
    @Story("Прохождение пользователем по основному функционалу сайта")


        void testDemoQa() throws InterruptedException {

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//div[@class='card-body']/h5[.='Elements']")).click(); // Клик по меню Elements
        driver.findElement(By.xpath("//span[.='Text Box']")).click();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Vasiliy Strlelnikov");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("VS2023@yandex.ru");
        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("Moscow");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Moscow");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        String s = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']")).getText();
        assertTrue (s.equals("Name:Vasiliy Strlelnikov\n" +
                "\n" +
                "Email:VS2023@yandex.ru\n" +
                "\n" +
                "Current Address :Moscow\n" +
                "\n" +
                "Permananet Address :Moscow"));

      /*  driver.findElement(By.xpath("//li[@id='item-4']")).click(); // Клик по меню Buttons
        driver.findElement(By.xpath("//*[@id=\"prWNT\"]")).click(); // Нажимаем кнопку Click me
        String m = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText();
        assertTrue (m.equals("You have done a dynamic click"));
        Thread.sleep(5000);

        actions.moveToElement(driver.findElement(By.xpath("//button[@id='rightClickBtn']")))
                .contextClick() // необходим клик правой кнопкой мыши
                .pause(Duration.ofSeconds(3))
                .perform();
        String o = driver.findElement(By.xpath("//*[@id='rightClickMessage']")).getText();
        assertTrue (o.equals("You have done a right click"));
        Thread.sleep(5000);

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='doubleClickBtn']")))
                .doubleClick() // необходим двойной клик кнопкой мыши
                .pause(Duration.ofSeconds(3))
                .perform();
        String p = driver.findElement(By.xpath("//*[@id='doubleClickMessage']")).getText();
        assertTrue (p.equals("You have done a double click"));

        actions.scrollToElement(driver.findElement(By.xpath("//*[@id='app']//*[.='Alerts, Frame & Windows']")))
                .perform();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(5000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(0)).close(); // закрытие новой вкладки


        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        driver.switchTo().window(tabs.get(0)).close(); // закрытие новой вкладки
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[.='Alerts']")).click();
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();


        Alert alertCancel = driver.switchTo().alert();  // закрытие уведомления
        alertCancel.dismiss(); */

    }




    @AfterAll
    static void tearDown() {

        driver.quit();

    }
}


