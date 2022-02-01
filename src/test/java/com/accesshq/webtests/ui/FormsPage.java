package com.accesshq.webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {

    private WebDriver driver;

    public FormsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public String getName() {
        return driver.findElement(By.id("name")).getText();
    }

    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public String getEmail() {
        return driver.findElement(By.id("email")).getText();
    }

    public String getNameErrorMessage()
    {
        return driver.findElement(By.id("name-err")).getText();
    }

    public String getEmailErrorMessage()
    {
        return driver.findElement(By.id("email-err")).getText();
    }

    public String getAgreeErrorMessage(){
        return driver.findElement(By.id("agree-err")).getText();
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();
    }

    public void clickSubmitButton()
    {
        clickButton("submit");
    }

    public void clickButton(String btnText)
    {
        WebElement button = findButton(btnText);
        if (button != null) {
            button.click();
        }
    }

    private WebElement findButton(String buttonText)
    {
        WebElement foundBtn = null;
        var buttons = driver.findElements(By.tagName("button"));  // class = 'v-btn'
        for (WebElement btn: buttons)
        {
            if (btn.getText().equalsIgnoreCase(buttonText))
            {
                foundBtn = btn;
                break;
            }
        }
        if (foundBtn == null) { throw (new NotFoundException()); }
        return foundBtn;
    }

}
