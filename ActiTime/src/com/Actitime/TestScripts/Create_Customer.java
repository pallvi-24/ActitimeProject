package com.Actitime.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Actitime.GenericLibrary.Base_Class;
import com.Actitime.GenericLibrary.File_Library;
import com.Actitime.POM.Home_Page;
import com.Actitime.POM.Task_Page;

public class Create_Customer extends Base_Class{
	@Test
	public void createCustomer() throws IOException, InterruptedException {
		Home_Page hp=new Home_Page(driver);
		hp.getTasktab().click();
		Thread.sleep(2000);
		Task_Page tp=new Task_Page(driver);
		tp.getAddnewbtn().click();
		Thread.sleep(2000);
		tp.getNewcust().click();
		File_Library fl=new File_Library();
		String customer = fl.readDataFromExcel("Sheet1", 1, 1);
		tp.getCustname().sendKeys(customer);
		Thread.sleep(2000);
		String description = fl.readDataFromExcel("Sheet1", 1, 2);
		tp.getCustdesp().sendKeys(description);
		Thread.sleep(2000);
		tp.getCreatebtn().click();
		
		String expectedresult = customer;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		s.assertAll();
		
	}
}
