package com.fidexio.step_definitions;

import com.fidexio.pages.HomePage;
import com.fidexio.pages.LogOutPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utils.ConfigurationReader;
import com.fidexio.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class LogOutStepDefinitions {

    LogOutPage logOutPage = new LogOutPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @When("User log in to the Homepage")
    public void userLogInToTheHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
        loginPage.email.sendKeys("salesmanager19@info.com");
        loginPage.password.sendKeys("salesmanager");
        loginPage.loginBtn.click();
        Assert.assertTrue(homePage.inbox.isDisplayed());
    }

    @And("User clicks log out button")
    public void user_clicks_log_out_button() {
        logOutPage.menu.click();
        logOutPage.logOutBtn.click();
    }

    @Then("User logs lands on login page")
    public void user_logs_lands_on_login_page() {
        String expectedHeader = "Best solution for startups";
        String actualHeader = logOutPage.loginHead.getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }

    @When("User navigates back")
    public void userNavigatesBack() {
        Driver.getDriver().navigate().back();
    }

    @Then("User should see the Session Expired Message")
    public void userShouldSeeTheSessionExpiredMessage() {
        String expectedMessage = "Odoo Session Expired";
        String actualMessage = logOutPage.sessionExpiredMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
