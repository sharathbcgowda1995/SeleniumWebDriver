package com.java.selenium.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StaffProfileManangement {

	public static void main(String[] args) throws InterruptedException {

		String fullName = "Sharath";
		String mobNum = "9591354391";
		String email = "sharathgowda2@gmail.com";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://staging3-akes.nexquare.io/nexquare/");
		driver.manage().window().maximize();

		// Loginn to the page
		driver.findElement(By.xpath("//input[@id='txtuser']")).sendKeys("S15364");
		driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Abc!@1");
		driver.findElement(By.xpath("//button[@id='log-btn']")).click();

		// ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='hr current']")));

		//Staff profile management
		driver.findElement(By.xpath("//a[@id='hr current']")).click();

		//Wait for the option staff add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[href='addStaff']")));
		driver.findElement(By.cssSelector("a[href='addStaff']")).click();

		// Entering all mandatory field
		// Fullname
		driver.findElement(By.xpath("//input[@id='staffFullName']")).sendKeys(fullName);

		// select the dob
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='10']")).click();

		// Nationality
		driver.findElement(By.xpath("//input[@placeholder='Nationality']"));
		driver.findElement(By.xpath("//span[normalize-space()='India']")).click();

		// Joining date
		driver.findElement(By.xpath("//input[@id='joinDate']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='1']")).click();

		// professionalemail
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);

		// phone number
		driver.findElement(By.xpath("//div[@class='iti__flag iti__in']")).click();
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(mobNum);

		// Salary date
		driver.findElement(By.xpath("//a[normalize-space()='31']")).click();

		// save
		driver.findElement(By.id("submitButton")).click();

		// click on staff edit
		driver.findElement(By.xpath("//li[@id='link_editStaff']//a[@href='editStaff'][normalize-space()='Staff Edit']"))
				.click();

		// search by name
		driver.findElement(By.xpath("//input[@id='staffName']")).sendKeys("Sharath");
		driver.findElement(By.xpath("//input[@id='staffName']")).click();

		// Validation
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='staffRegisterNoOrName']")).getText(), fullName);

		driver.close();

	}

}
