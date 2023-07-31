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

public class Delivery {
	
	
	private WebDriver driver;
	By searchBar = By.xpath("//*[@id=\"rc_select_0\"]");
	By searchButton = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[1]/div[2]/div/div/div/span[1]/span/span/span[1]/span/svg/path");
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();

		
	}
	
	
	@Test(description = "Registro de usuario", priority = 0, enabled = true)
	public void delivery() {

		driver.manage().window().maximize();
		driver.get("https://domicilios.tiendasd1.com/newCustomer");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		By userName = By.xpath("//*[@id=\"signup_email\"]");
		driver.findElement(userName).sendKeys("maildeleon@gmail.com");
		
		By password = By.xpath("//*[@id=\"signup_password\"]");
		driver.findElement(password).sendKeys("aplaplac");
		
		By loginBtn = By.xpath("//*[@id=\"signup\"]/div[3]/div/div/div/div/button/span");
		driver.findElement(loginBtn).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		By closeModalBtn = By.cssSelector("body > div:nth-child(10) > div > div.ant-modal-wrap > div > div.ant-modal-content > button > span > svg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.findElement(closeModalBtn).click();
		//driver.findElement(password).sendKeys(Keys.ESCAPE );
		
		
		By deliveryBtn = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[2]/button[1]/span/span");
		driver.findElement(deliveryBtn).click();
		
		By deliveryBtn2 = By.xpath("//*[@id=\"card-operation-model-DELIVERY\"]/div");
		driver.findElement(deliveryBtn2).click();
		
		By state = By.xpath("//*[@id=\"Address_state\"]");
		driver.findElement(state).sendKeys("Bogota");
		
		By city = By.xpath("//*[@id=\"Address_city\"]");
		driver.findElement(city).sendKeys("Bogotá D.C.");
		
		By street = By.xpath("//*[@id=\"Address_addressStucturedGroup_mainRoad\"]");
		driver.findElement(city).sendKeys("25d");
		
		By road = By.xpath("//*[@id=\"Address_addressStucturedGroup_secundaryRoad\"]");
		driver.findElement(road).sendKeys("37");
		
		By distance = By.xpath("//*[@id=\"Address_addressStucturedGroup_complementaryRoad\"]");
		driver.findElement(distance).sendKeys("12");
		
		By reference = By.xpath("//*[@id=\"Address_addressTwo\"]");
		driver.findElement(reference).sendKeys("casa");

		By ref = By.xpath("//*[@id=\"Address_description\"]");
		driver.findElement(ref).sendKeys("casa");
		
		By addBtn = By.xpath("//*[@id=\"Address\"]/div[8]/div/div/div/div/button/span");
		driver.findElement(addBtn).click();
		
		By confirm = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/button/span");
		driver.findElement(confirm).click();
		
		By address = By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[2]/button[1]/span/span[2]");
		String addressString = driver.findElement(address).getText();

		System.out.println(addressString);
		Assert.assertNotNull(addressString);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String ActualTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		System.out.println(ActualTitle);

		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

}
