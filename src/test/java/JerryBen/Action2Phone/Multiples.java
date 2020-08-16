package JerryBen.Action2Phone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Multiples {
	
	public WebDriver driver;
	public JavascriptExecutor jse;
	public Actions actions;
	public WebDriverWait wait;
	public String selectAll = Keys.chord(Keys.CONTROL, "a");
	
	//declare and initialize new ChromeDrive, JavascriptExecutor, Actions, and WebDriver wait
	@BeforeSuite
	public void initializeDrivers() {
		System.setProperty("webdriver.chrome.driver", "C:\\My Stuff\\Learning Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait (driver, 10);
	}
	
	@Test (priority=1)
	public void selectTitle() {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement titles = driver.findElement(By.id("input-title"));
		
		Select s = new Select(titles);
		int titlesNumber = titles.findElements(By.tagName("option")).size();
		s.selectByValue("Senator");
		System.out.println(titlesNumber);
	}
	
	@Test (priority=3)
	public void inputName() {
		WebElement name = driver.findElement(By.name("fullName"));
		
		name.sendKeys("George Testerly");
		name.sendKeys(selectAll);
		name.sendKeys(Keys.DELETE);
		
	}
	
	@Test (priority=2)
	public void inputEmail() {
		WebElement email = driver.findElement(By.id("input-email"));
		
		email.sendKeys("test@gmail.com");
	}
	
}
