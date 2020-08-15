package JerryBen.Action2Phone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Errors {
	
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
	public void navigationBars() throws InterruptedException {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement formSubmit = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		WebElement nameError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[4]/span"));
		
		Select s = new Select(titles);
		int titlesNumber = titles.findElements(By.tagName("option")).size();
		s.selectByValue("Senator");
		System.out.println(titlesNumber);
		
		formSubmit.click();
		
		System.out.println(nameError.isDisplayed());
		Assert.assertTrue(nameError.isDisplayed());
		
		//*[@id="email-panel"]/div[1]/fieldset[4]/span -- name error message
		
		//*[@id="email-panel"]/div[1]/fieldset[7]/span -- address error message
		
		
	}
}
