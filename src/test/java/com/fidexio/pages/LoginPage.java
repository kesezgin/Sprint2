package com.fidexio.pages;

import com.fidexio.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = ".btn.btn-primary")
    public WebElement loginBtn;

    @FindBy(css="p.alert.alert-danger")
    public WebElement errorMessage;

    //@FindBy(css="input#login")
    //public WebElement emptyEmail;

    //@FindBy(css="input#password")
    //public WebElement emptyPassword;

}
