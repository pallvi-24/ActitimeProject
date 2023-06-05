package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	//declaration
@FindBy(xpath = "//div[.='Tasks']")
private WebElement tasktab;

@FindBy(xpath = "/div[.='Reports']")
private WebElement reportstab;

@FindBy(xpath = "/div[.='Users']")
private WebElement usertab;

@FindBy(xpath = "//a[.='Logout']")
private WebElement lgoutlnk;

//initialization
public Home_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//utilization
public WebElement getTasktab() {
	return tasktab;
}

public WebElement getReportstab() {
	return reportstab;
}

public WebElement getUsertab() {
	return usertab;
}

public WebElement getLgoutlnk() {
	return lgoutlnk;
}


}
