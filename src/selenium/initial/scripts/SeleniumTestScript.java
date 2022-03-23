package selenium.initial.scripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestScript {
	
	public static void main(String[] args) {

		// Download and pass the proper path of .exe drivers from the respective
		// browsers.
		// Before downloading make sure that you are checking the browser version.
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver.exe");
		 */

		// 1st step to write a chrome,firefox,ie or etc
		// now we can restrict the subclass(chrome,ie etc) methods to use
		/* WebDriver driver = new ChromeDriver(); */

		// -------------------Chrome
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver.exe");
		 */
		/* WebDriver driver = new ChromeDriver(); */

		// -------------------Firefox
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Users\\sharabc\\Desktop\\Selenium\\geckodriver.exe"); WebDriver driver =
		 * new FirefoxDriver();
		 */

		// ------------------MicrosoftEdge
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sharabc\\Desktop\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		// driver.quit();
		
	}

}
