package com.fidexio.pages;

import com.fidexio.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

    public LogOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    //@FindBy(xpath = "//a[text()='Log out']")

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement menu;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logOutBtn;

    @FindBy(xpath = "//a[.='Best solution for startups']")
    public WebElement loginHead;

    @FindBy(xpath = "//h4[.='Odoo Session Expired']")
    public WebElement sessionExpiredMessage;
}
