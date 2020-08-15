package JerryBen.Action2Phone;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Socials {
	
	public WebDriver driver;
	public JavascriptExecutor jse;
	public Actions actions;
	public WebDriverWait wait;
	
	//declare and initialize new ChromeDrive, JavascriptExecutor, Actions, and WebDriver wait
	@BeforeSuite
	public void initializeDrivers() {
		System.setProperty("webdriver.chrome.driver", "C:\\My Stuff\\Learning Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait (driver, 10);
	}	
	
	/*@Test
	public void socialMedia() {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		driver.findElement(By.xpath("//span[contains(text(),'Twitter')]")).click();
		
		ArrayList<String> tabular = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabular.get(1));
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("twitter"));
		driver.close();
		
		driver.switchTo().window(tabular.get(0));
		System.out.println(driver.getCurrentUrl());
		url = driver.getCurrentUrl();
		Assert.assertFalse(url.contains("twitter"));
		
		driver.quit();
	}*/
	
	@Test
	public void openSocials() {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		driver.findElement(By.xpath("//span[contains(text(),'Twitter')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Facebook')]")).click();
		
		String URL;
		ArrayList<String> tabular = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(tabular.get(1));
		URL = driver.getCurrentUrl();
		System.out.println(URL);							//returns facebook
		//Assert.assertTrue(URL.contains("twitter"));
		
		driver.switchTo().window(tabular.get(2));
		URL = driver.getCurrentUrl();
		System.out.println(URL);							//returns twitter
		//Assert.assertTrue(URL.contains("facebook"));
		
		driver.switchTo().window(tabular.get(0));
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		//Assert.assertFalse(URL.contains("facebook"));
		
		
	}
}
