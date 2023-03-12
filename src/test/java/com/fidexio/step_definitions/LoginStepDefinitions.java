package com.fidexio.step_definitions;

import com.fidexio.pages.HomePage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utils.ConfigurationReader;
import com.fidexio.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefinitions {

    String emailCheck, passwordCheck;
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }

    @When("User enters email {string}")
    public void userEntersEmail(String enteredEmail) {
        loginPage.email.sendKeys(enteredEmail);
        emailCheck = enteredEmail;
    }

    @And("User enters password {string}")
    public void userEntersPassword(String enteredPassword) {
        loginPage.password.sendKeys(enteredPassword);
        passwordCheck = enteredPassword;
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("User should be on the homepage")
    public void userShouldBeOnTheHomepage() {//throws InterruptedException {
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        //String expectedTitle = "#Inbox - Odoo";
        //String actualTitle = Driver.getDriver().getTitle();
        //Assert.assertEquals(expectedTitle, actualTitle);
        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.inbox.isDisplayed());
    }


    @Then("User should see the error message")
    public void user_should_see_the_error_message() {
        String expectedError = "Wrong login/password";
        String actualError = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedError, actualError);
    }


    @Then("User should see the {string} error message")
    public void userShouldSeeTheErrorMessage(String arg0) {
        if (emailCheck.isEmpty()) {
            Assert.assertEquals(loginPage.email.getAttribute("validationMessage"), arg0);
            Assert.assertNotNull(loginPage.email.getAttribute("required"));
        } else if (passwordCheck.isEmpty()) {
            Assert.assertEquals(loginPage.password.getAttribute("validationMessage"), arg0);
            Assert.assertNotNull(loginPage.password.getAttribute("required"));
        }
    }

    @Then("user should see it in bullet signs by default")
    public void userShouldSeeItInBulletSignsByDefault() {
        Assert.assertEquals("password", loginPage.password.getAttribute("type"));
        //System.out.println(loginPage.password.getAttribute("type"));
    }


    @And("User hits the Enter key")
    public void userHitsTheEnterKey() {
        loginPage.password.sendKeys(Keys.ENTER);
    }
}
