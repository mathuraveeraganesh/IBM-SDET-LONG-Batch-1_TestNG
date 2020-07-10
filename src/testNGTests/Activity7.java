package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	
	@BeforeClass
	public void LaunchBrowser() {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@Test(dataProvider="fetchdata")
	public void GetTitle(String UserName,String Password) {
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String text = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(text,"Welcome Back, admin");
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}
	
	@DataProvider(name="fetchdata")
	public String[][] GetData(){
		String[][] data={{"admin","password"}};
		return data;
				
	}

}
