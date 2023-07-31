package FunctionalTest;


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


public class LoginFailed {

	private WebDriver driver;
	By searchBar = By.xpath("//*[@id=\"rc_select_0\"]");
	By searchButton = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[1]/div[2]/div/div/div/span[1]/span/span/span[1]/span/svg/path");
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();

		
	}
	
	
	@Test(description = "Registro de usuario", priority = 0, enabled = true)
	public void login() {

		driver.manage().window().maximize();
		driver.get("https://domicilios.tiendasd1.com/newCustomer");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		By userName = By.xpath("//*[@id=\"signup_email\"]");
		driver.findElement(userName).sendKeys("maildeleon@gmail.com");
		
		By password = By.xpath("//*[@id=\"signup_password\"]");
		driver.findElement(password).sendKeys("aplaplac");
		
		By loginBtn = By.xpath("//*[@id=\"signup\"]/div[3]/div/div/div/div/button/span");
		driver.findElement(loginBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		
		By searchResultCount = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[1]/button[2]/div[2]/span[1]");	
		String nameString = driver.findElement(searchResultCount).getText();
		System.out.println(nameString);
		Assert.assertEquals(nameString, "¡Hola! Inicia sesión");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	
}
