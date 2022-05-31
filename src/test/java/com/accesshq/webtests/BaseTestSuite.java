package com.accesshq.webtests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTestSuite {

    protected static WebDriver driver;

    @BeforeAll
    public static void Setup()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Chromedriver102\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void Startup() {
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void Cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
}
