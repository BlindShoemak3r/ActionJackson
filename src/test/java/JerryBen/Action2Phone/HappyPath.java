package JerryBen.Action2Phone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HappyPath {
	
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
	public void emailPath() throws InterruptedException {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement name = driver.findElement(By.name("fullName"));
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		
		Select s = new Select(titles);
		s.selectByValue("Senator");
		
		name.sendKeys("google goob");
		
		address1.sendKeys("123");
		Thread.sleep(2000);
		address1.sendKeys(Keys.DOWN);
		address1.sendKeys(Keys.RETURN);
		
		phone.sendKeys("2366547890");
		
		email.sendKeys("test@gmail.com");
		
		sendEmail.click();
		
		WebElement unavailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p2a-restricted-error")));
		
		System.out.println(unavailable.isDisplayed());
		Assert.assertTrue(unavailable.isDisplayed());
		
		driver.close();
	}*/
	
	@Test
	public void phonePath() throws InterruptedException {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		driver.findElement(By.xpath("//li[@class='call-nav-list-item']")).click();
		Thread.sleep(2000);
		
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		address1.sendKeys("321");
		Thread.sleep(1000);
		address1.sendKeys(Keys.DOWN);
		address1.sendKeys(Keys.RETURN);
		
		phone.sendKeys("1234567890");
		
		findLeg.click();
		
		
		
	}
}
