package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//declaration
public class Login_Page {
@FindBy(id = "username")
private WebElement untbx;

@FindBy(name = "pwd")
private WebElement pwtbx;

@FindBy(xpath = "//div[.='Login ']")
private WebElement lgbtn;

//initialization
public Login_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//utilization
public WebElement getUntbx() {
	return untbx;
}

public WebElement getPwtbx() {
	return pwtbx;
}

public WebElement getLgbtn() {
	return lgbtn;
}
}