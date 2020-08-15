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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TesTseT {
	
	
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
		
		@Test
		public void landingPageTest() throws InterruptedException {
			driver.get("https://action.benjerry.com/lh92ba9");
			
			WebElement titles = driver.findElement(By.id("input-title"));
			WebElement name = driver.findElement(By.name("fullName"));
			WebElement address1 = driver.findElement(By.id("input-address1"));
			WebElement zip = driver.findElement(By.id("input-zip5"));
			WebElement phone = driver.findElement(By.id("input-phone"));
			WebElement email = driver.findElement(By.id("input-email"));
			WebElement formSubmit = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
			
			//Titles dropdown
			Select s = new Select(titles);
			int titlesNumber = titles.findElements(By.tagName("option")).size();
			s.selectByValue("Senator");
			System.out.println(titlesNumber);
			
			//Full Name
			name.sendKeys("George Testerly");
			
			//Address Line 1
			address1.sendKeys("123");
			Thread.sleep(5000);
			address1.sendKeys(Keys.DOWN);
			address1.sendKeys(Keys.RETURN);
			
			//Zip Code
			String zipCode = zip.getText();
			System.out.println(zipCode);
			
			//Form Submit
			formSubmit.click();
			
			//Phone button
			driver.findElement(By.xpath("//li[@class='call-nav-list-item']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@class='email-nav-list-item']")).click();
			
			
			//driver.findElement(By.xpath("//span[contains(text(),'Twitter')]")).click();
			//driver.findElement(By.xpath("//span[contains(text(),'Facebook')]")).click();
			
			Thread.sleep(2000);
			
			
			//Check boxes
			WebElement emailCheck = driver.findElement(By.id("subscribeEmail"));
			emailCheck.click();
			System.out.println(emailCheck.isSelected());
			
			WebElement textCheck = driver.findElement(By.id("subscribeEmail"));
			textCheck.click();
			System.out.println(textCheck.isSelected());
		}
}

/*
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='cbp-tm-menu']/li/a")));
WebElement flavors = driver.findElement(By.xpath("//ul[@id='cbp-tm-menu']/li/a"));
flavors.click();

jse.executeScript("window.scrollBy(0,1000)");
Thread.sleep(2500);
driver.findElement(By.xpath("//*[@class='privacy-policy-1']/a")).click();

*/