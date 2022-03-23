package com.java.selenium.dropdown_navigate_manageWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.*;

public class E2ETestingBySearch {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("End to end application testing started");
		
		///* Steps has to be followed before we trigger the scripts */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		
		//1.AUTO SUGGESTIVE DROPDOWN
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> list =driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement suggestion : list) {
			if(suggestion.getText().equalsIgnoreCase("India")) {
				suggestion.click();
				break;
			}
		}
		

		//2.source - USE NORMAL KNOWLEDGE OF LOCATORS
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		Thread.sleep(3000);//put some delay to pop up the next option

		//3.Destination - DYNAMIC DROPDOWN [PARENT CHILD XPATH WORKS]
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(1000);//Again need some delay as the calender pops up automatically
		
		//wherever the pop will arises without clicking on them then they need some delay to pop-up

		//4.Departure date - HANDLING CALENDER UI .../Class can be the Unique one.
		//driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight']")).click();

		
		//5.Enable-Disable the UI Component.
		//WE HAVE TWO METHODS WE CAN USE EITHER isEnabled() OR some work around as below
		//Now a days almost all the web pages enable the disabled component if we hover on them or click on them before it was not like this but the existing-
		//selenium isEnabled() is confused so most of the time it won't work.
		System.out.println("Before clicking rounded trip : " + driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());		
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//if the same xpath having same value then we go with this way of indexing
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		if(driver.findElement(By.cssSelector("span[id='spclearDate']")).getAttribute("style").contains("block")) {
			System.out.println("enabled");
		}
		else {
			System.out.println("disabled");
		}
		
		
		//6.selecting the type of trip - SELECTING RADIO TYPE BUTTONS
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		System.out.println("After clicking oneway trip : " + driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		//7.click the number of adults - USE THE BASIC KNOWLEDGE OF LOCATORS FO THIS COMPONENT
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 1; i <= 5; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			Thread.sleep(1000);
		}
		
		//8.Click on the done button		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//9.Enter the currency type.- STATIC DROP DOWNS ALWAYS WITH SELECT TAG ONLY , CAN BE ACCESSIBLE VIA SELECT CLASS
		//driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		WebElement selectionList = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select selectElements = new Select(selectionList);
		
		System.out.println(selectElements.getFirstSelectedOption().getText());
		selectElements.selectByIndex(2);
		Assert.assertEquals(selectElements.getFirstSelectedOption().getText(),"AED");
		System.out.println(selectElements.getFirstSelectedOption().getText());
		
		
		//10.Select the special offer like senior citizen
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		//11.To check the number of check boxes present in the existing web page - BASED ON THE type="CheckBox" find the unique property of it
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());	
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);
	
		//12.search the buses
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		//Wait for sometime
		Thread.sleep(5000);
		driver.close();
		
		System.out.println("End to end application test closed");
	
	
	}
	

}
