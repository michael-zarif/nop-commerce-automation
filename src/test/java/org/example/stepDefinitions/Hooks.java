package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public static void openBrowser(){
        // 1- Bridge
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium Drivers\\chromedriver.exe");

        // 2- Create new isntance of ChromeDriver
        driver = new ChromeDriver();

        // 3- Configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // 4- Navigate to URL
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
