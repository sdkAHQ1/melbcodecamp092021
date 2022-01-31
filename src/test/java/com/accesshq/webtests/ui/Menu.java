package com.accesshq.webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu {

    private WebDriver driver;

    public Menu(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickForms()
    {
        driver.findElement(By.cssSelector("[aria-label='forms']")).click();
    }

    public void clickPlanets()
    {
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
    }

    public void clickHome()
    {
        driver.findElement(By.cssSelector("[aria-label='home']")).click();
    }

}
