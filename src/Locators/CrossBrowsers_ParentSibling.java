package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CrossBrowsers_ParentSibling {

	public static void main(String[] args) throws InterruptedException {
//--Chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//--Firefox
//		System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\sharabc\\Desktop\\Selenium\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

// ---MicrosoftEdge
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\sharabc\\Desktop\\Selenium\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

//		driver.get("https://sso.teachable.com/secure/9521/identity/login");
//		driver.getCurrentUrl();
//		driver.getClass();
//		driver.findElement(By.className("form-input")).sendKeys("sharathbcgowda2@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("Rahul@1995");
//		driver.findElement(By.cssSelector("input[class*='btn-primary']")).click();

		/*------upto above is paracticed and from today new concepts -----*/

		/* we use it when the web page is having unique tag */
		// driver.findElement(By.tagName("i"));

		// One more operation Login.
		driver.get("https://sso.teachable.com/secure/9521/identity/login");
		driver.findElement(By.className("form-input")).sendKeys("sharathbcgowda2@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Rahul@1995");
		driver.findElement(By.cssSelector("input[class*='btn-primary']")).click();
		Thread.sleep(3000);
		// System.out.println(driver.findElement(By.className("navbar-current-user").g
		// driver.findElement(By.className("navbar-current-user")).click();
		// driver.findElement(By.cssSelector("span[class='navbar-current-user']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("span[class='navbar-current-user']")).getText(),
				"Sharath B C");

		/*
		 * We can write the xpath locators for the link buttons where there is no <a tag
		 * using the text
		 */
		// driver.findElement(By.xpath("button[text()='Log Out']")).click();

		/*
		 * using star but we can not use this if the two tags having the same of
		 * attribute
		 */
		// driver.findElement(By.xpath("*[text()='Log Out']")).click();

		/* using sibling to sibling traverse */
//		System.out.println(driver.findElement(By.xpath("//div/ul/li[1]/following-sibling::li[1]")).getText());
//		driver.findElement(By.xpath("//div/ul/li[1]/following-sibling::li[1]")).click();

		/* using sibling to parent traverse */
//		System.out.println(driver.findElement(By.xpath("//div/ul/li[1]/parent::ul")).getText());
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div/ul/li[1]/parent::ul")).click();

		/* practice */
//		driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
//		driver.findElement(By.linkText("All")).click();
//		driver.findElement(By.linkText("AdminUser")).click();
		
		

	}

}
