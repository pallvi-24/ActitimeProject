package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.POM.Login_Page;

public class Base_Class {
	 File_Library fl=new File_Library();
	 public static WebDriver driver;
	
	  @BeforeSuite
	  public void dataBaseConnection() {
		Reporter.log("databse connected",true);
	}
	  @BeforeClass
	  public void launchTheBrowser() throws IOException {
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  String actitimeurl = fl.readDataFromPropertyFile("url");
		  driver.get(actitimeurl);
		  Reporter.log("browser launched",true);
	  }
	  @BeforeMethod
	  public void logIn() throws IOException {
		  Login_Page lp=new Login_Page(driver);
		   String un = fl.readDataFromPropertyFile("username");
		   String ps = fl.readDataFromPropertyFile("password");
		   lp.getUntbx().sendKeys(un);
		   lp.getPwtbx().sendKeys(ps);
		   lp.getLgbtn().click();
		  Reporter.log("logged in",true);
	  }
	  
	  @AfterMethod
	  public void logOut() {
		  driver.findElement(By.xpath("//a[.='Logout']")).click();
		  Reporter.log("logged out",true);
	  }
	  @AfterClass
	  public void closeBrowser() {
		  driver.close();
		  Reporter.log("browser closed",true);
	  }
	  @AfterSuite
	  public void dataBaseDisconnect() {
		  Reporter.log("database discoonected",true);
	  }
	}

