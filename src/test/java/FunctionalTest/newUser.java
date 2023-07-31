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

public class newUser {
	
	private WebDriver driver;
	By searchBar = By.xpath("//*[@id=\"rc_select_0\"]");
	By searchButton = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[1]/div[2]/div/div/div/span[1]/span/span/span[1]/span/svg/path");
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();

		
	}
	@Test(description = "Búsqueda de producto", priority = 0, enabled = false)
	public void searchProduct() {

		driver.manage().window().maximize();
		driver.get("https://domicilios.tiendasd1.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("start");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
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
	
	@Test(description = "Registro de usuario", priority = 0, enabled = true)
	public void newUser() {

		driver.manage().window().maximize();
		driver.get("https://domicilios.tiendasd1.com/auth/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		By nameField = By.xpath("//*[@id=\"register_name\"]");
		driver.findElement(nameField).sendKeys("Juanin");
		driver.findElement(nameField).sendKeys(Keys.TAB);
		
		By emailField = By.xpath("//*[@id=\"register_email\"]");
		driver.findElement(emailField).sendKeys("maildele0nfrag@gmail.com");
		driver.findElement(emailField).sendKeys(Keys.TAB);
		
		By idType = By.xpath("//*[@id=\"register_identificationType\"]");
		driver.findElement(idType).sendKeys(Keys.DOWN);
		driver.findElement(idType).sendKeys(Keys.RETURN);
		driver.findElement(idType).sendKeys(Keys.RETURN);
		driver.findElement(idType).sendKeys(Keys.TAB);

	
		By idField = By.xpath("//*[@id=\"register_identificationNumber\"]");
		driver.findElement(idField).sendKeys("123234345");
		driver.findElement(idField).sendKeys(Keys.TAB);
		
		By confirmationField = By.xpath("//*[@id=\"register_confirmNumber\"]");
		driver.findElement(confirmationField).sendKeys("123234345");
		driver.findElement(confirmationField).sendKeys(Keys.TAB);
		
		By dateField = By.xpath("//*[@id=\"register_birthday\"]");
		driver.findElement(dateField).sendKeys("12/12/2000");
		driver.findElement(dateField).sendKeys(Keys.TAB);
		
		By passField = By.xpath("//*[@id=\"register_password\"]"); 
		driver.findElement(passField).sendKeys("password1234");

		By passField2 = By.xpath("//*[@id=\"register_confirm\"]"); 
		driver.findElement(passField2).sendKeys("password1234");
		driver.findElement(passField2).sendKeys(Keys.TAB);

		By submitBtn = By.xpath("//*[@id=\"register\"]/div[9]/div/div/div/div/button/span"); 
		driver.findElement(submitBtn).click();
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String ActualTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		System.out.println(ActualTitle);

		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
