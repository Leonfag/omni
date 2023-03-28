package FunctionalTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import io.qameta.allure.Allure;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CruiseTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.carnival.com");
		
	}
	@Test
	public void userStory1() {
		WebElement searchElement = driver.findElement(By.xpath("//a[@class='cdc-filters-search-cta']"));
		WebElement skipElement = driver.findElement(By.xpath("//div[@class='vifp-no-thankyou']"));
		WebElement sailToElement = driver.findElement(By.xpath("//a[@id='cdc-destinations']"));
		//WebElement bahamasElement = driver.findElement(By.xpath("//button[@aria-label='The Bahamas ']"));
		WebElement durationsElement = driver.findElement(By.xpath("//a[@id='cdc-durations']"));
		//WebElement sixnineElement = driver.findElement(By.xpath("//button[@aria-label='6 - 9 Days ']"));
		skipElement.click();
		System.out.println("skip");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		sailToElement.click();
		System.out.println("sail to");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement bahamasElement = driver.findElement(By.xpath("//button[@aria-label='The Bahamas ']"));
		bahamasElement.click();
		System.out.println("bahamas");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		durationsElement.click();
		System.out.println("duration");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement sixnineElement = driver.findElement(By.xpath("//button[@aria-label='6 - 9 Days ']"));
		sixnineElement.click();
		System.out.println("six2nine");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		searchElement.click();
		System.out.println("search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String expectedTitle = "Cruise Search | Find Cruises for 2023-2025 | Carnival Cruise Line";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(expectedTitle, ActualTitle);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
