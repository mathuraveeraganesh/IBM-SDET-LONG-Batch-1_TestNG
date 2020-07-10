package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity9 {
	
	WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser() {
		Reporter.log("Before Test Browser Launch ");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Before Test Ended");
	}
	
	@BeforeMethod
	public void DefaultContent() {
		Reporter.log("Before Method Switch To Default Content");
		driver.switchTo().defaultContent();
		Reporter.log("Before Method Ended");
	}
	@Test(priority = 0)
	public void simpleAlertTestCase() {
		Reporter.log("Simple Alert Started");
		driver.findElement(By.id("simple")).click();
	
		Alert sAlert=driver.switchTo().alert();
		String text = sAlert.getText();
		Assert.assertEquals("This is a JavaScript Alert!", text);
		System.out.println("Simple Alert-"+text);
		Reporter.log("Simple Alert-"+text);
		sAlert.accept();
		Reporter.log("Simple Alert Ended");
	}
	
	@Test(priority = 1)
	public void confirmAlertTestCase() {
		Reporter.log("Confirm Alert Started");
		driver.findElement(By.id("confirm")).click();
		Alert sAlert=driver.switchTo().alert();
		String text = sAlert.getText();
		Assert.assertEquals("This is a JavaScript Confirmation!", text);
		System.out.println("Confirm Alert-"+text);
		Reporter.log("Confirm Alert-"+text);
		sAlert.dismiss();
		Reporter.log("Confirm Alert Ended");
	}
	
	@Test(priority = 2)
	public void promptAlertTestCase() {
		Reporter.log("Prompt Alert Started");
		driver.findElement(By.id("prompt")).click();
		Alert sAlert=driver.switchTo().alert();
		sAlert.sendKeys("Ganesh");
		String text = sAlert.getText();
		Assert.assertEquals("This is a JavaScript Prompt!", text);
		System.out.println("Prompt Alert-"+text);
		Reporter.log("Prompt Alert-"+text);
		sAlert.accept();
		Reporter.log("Prompt Alert Ended");
	}
	
	
	@AfterTest
	public void CloseBrowser() {
		Reporter.log("After Test Started");
		driver.close();
		Reporter.log("After Test Ended");
	}
	
	

}
