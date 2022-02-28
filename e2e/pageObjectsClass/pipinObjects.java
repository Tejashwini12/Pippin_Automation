package pageObjectsClass;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class pipinObjects {

	WebDriver driver;

	@FindBy(xpath = "//input[@type='email']")

	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")

	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")

	WebElement login;

	public pipinObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {

		userName.sendKeys(strUserName);
	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	public void loginToPipin(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}
	
	       // Click on InProgress

	public void clickInProgress() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='active']")).click();
	}
         
	     // method select a particular OrderID
	
	public void clickOnSearch(String record) throws InterruptedException {
		WebElement m = driver.findElement(By.xpath("//div[@class='mat-form-field-infix']//input"));
		m.sendKeys(record);
		m.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr//span[@class='wrapInSingleLine']")).click();
	}
	
	// method to pass the value of OrderId in  Test class
	
	public String verifyRecords() throws InterruptedException {
		Thread.sleep(3000);
		WebElement rl = driver.findElement(By.xpath("//div[@class='mat-form-field-infix']/span/input"));
		String sst = rl.getAttribute("ng-reflect-value");
		return sst.trim();
	}
	
	// to logout from application
	public void logoutApplication() {
		driver.findElement(By.xpath("//div[@class='ng-star-inserted']//span[@class='mat-button-wrapper']")).click();
		driver.findElement(By.xpath("(//div[@class='mat-menu-content']//button)[4]")).click();
	}
	
}
