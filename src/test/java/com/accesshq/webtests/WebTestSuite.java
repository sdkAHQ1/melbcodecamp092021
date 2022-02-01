package com.accesshq.webtests;

import com.accesshq.webtests.ui.FormsPage;
import com.accesshq.webtests.ui.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class WebTestSuite extends BaseTestSuite {

    @Test
    void TestFormsPageErrorMessages() throws InterruptedException {
        // arrange
        // find the web element that lets us click on the forms menu item and click on it
        var menu = new Menu(driver);
        menu.clickForms();

        var formsPage = new FormsPage(driver);
        formsPage.clickSubmitButton();

        // assert - that we get the right error texts back
        Assertions.assertEquals("Your name is required", formsPage.getNameErrorMessage());
        Assertions.assertEquals("Your email is required", formsPage.getEmailErrorMessage());
        Assertions.assertEquals("You must agree to continue", formsPage.getAgreeErrorMessage());
    }

    @Test
    void SubmitForm() throws InterruptedException {

        // find the web element that lets us click on the forms menu item and click on it
        var menu = new Menu(driver);
        menu.clickForms();

        var formsPage = new FormsPage(driver);
        formsPage.setName("Simon");
        formsPage.setEmail("simon.kaufmann@accesshq.com");
        formsPage.clickAgree();
        formsPage.clickSubmitButton();

    }

}
