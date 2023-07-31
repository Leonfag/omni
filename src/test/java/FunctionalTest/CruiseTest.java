package FunctionalTest;

import static org.testng.Assert.assertNotEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import io.qameta.allure.Allure;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CruiseTest {
	
	private WebDriver driver;
	By searchBar = By.xpath("//*[@id=\"rc_select_0\"]");
	By searchButton = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[1]/div[2]/div/div/div/span[1]/span/span/span[1]/span/svg/path");
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		
		
//		driver.manage().window().maximize();
//		driver.get("https://domicilios.tiendasd1.com");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(description = "Búsqueda de producto", priority = 0)
	public void searchProduct() {

		driver.manage().window().maximize();
		driver.get("https://domicilios.tiendasd1.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("start");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(searchBar).click();
		
		driver.findElement(searchBar).sendKeys("agua");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(searchBar).sendKeys(Keys.RETURN);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		String ActualTitle = driver.getTitle();
		
		By searchResultCount = By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/span");
		
		String count = driver.findElement(searchResultCount).getText();

		System.out.println(ActualTitle);
		System.out.println(count);
		Assert.assertNotEquals(count, "(0)");
	//	driver.quit();

		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
