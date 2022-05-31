package com.accesshq.webtests;

import com.accesshq.webtests.ui.FormsPage;
import com.accesshq.webtests.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTestSuite extends BaseTestSuite {

    @Test
    void TestFormsPageErrorMessages() throws InterruptedException {
        // arrange
        // find the web element that lets us click on the forms menu item and click on it
        var menu = new Menu(driver);
        menu.navigateToFormsPage();

        var formsPage = new FormsPage(driver);
        formsPage.clickSubmitButton();

        // assert - that we get the right error texts back
        Assertions.assertEquals("Your name is required", formsPage.getNameErrorMessage());
        Assertions.assertEquals("Your email is required", formsPage.getEmailErrorMessage());
        Assertions.assertEquals("You must agree to continue", formsPage.getAgreeErrorMessage());
    }

    @Test
    void SubmitFormAndVerifyThankYouMessage() throws InterruptedException {

        // arrange
        // find the web element that lets us click on the forms menu item and click on it
        var menu = new Menu(driver);
        menu.navigateToFormsPage();
        var formsPage = new FormsPage(driver);

        // act - enter values into the form and click submit
        String name = "simon";
        formsPage.setName(name);
        formsPage.setEmail("simon.kaufmann@accesshq.com");
        formsPage.clickAgree();
        formsPage.clickSubmitButton();

        // assert that the thank you message pop-up appears with the right message
        new WebDriverWait(driver, 10).until(d -> formsPage.isPopupVisible());
        String expectedMsg = "Thanks for your feedback " + name;
        Assertions.assertEquals(expectedMsg, formsPage.getPopupMessageText() );

    }

}
