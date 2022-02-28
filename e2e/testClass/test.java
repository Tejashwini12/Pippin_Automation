package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsClass.pipinObjects;

public class test {

	String driverPath = "C:\\chromedriver.exe";
	WebDriver driver;

	pipinObjects obj;
	String orderId = "200237";

	@BeforeTest
	public void setup() {
		System.setProperty("Webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.get("https://demo.pippintitle.com/");
		driver.manage().window().maximize();
	}
	
	 // Test to login into the application and verify the OrderID
	
	@Test(priority = 0)

	
	public void testLoginHomePage() throws InterruptedException {
		obj = new pipinObjects(driver);

		// login to application

		obj.loginToPipin("pippintitle_demotest@mailinator.com", "DemoTest#567#");
		obj.clickInProgress();
		obj.clickOnSearch(orderId);
		System.out.println("The order number passed in the test is "+orderId);
		System.out.println("The order number found in the UI in the record is "+obj.verifyRecords());
		Assert.assertEquals(obj.verifyRecords(), orderId);
		System.out.println("Test Passed");

	}
	 // Test to logout from Apllication
	
	@Test(priority = 1)
	public void logoutApp() throws InterruptedException {
		Thread.sleep(3000);
		obj.logoutApplication();
	}
	
	// Test to close the browser
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
