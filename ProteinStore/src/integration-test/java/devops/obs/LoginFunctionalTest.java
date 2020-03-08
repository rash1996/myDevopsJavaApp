package devops.obs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxOptions;

import devops.obs.IntegrationTest;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class LoginFunctionalTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);   
        driver = new FirefoxDriver(firefoxOptions);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void loginSuccess() {
        driver.get("http://localhost:6080/ProteinStore");
        WebElement email = driver.findElement(By.name("uName"));
        WebElement pass = driver.findElement(By.name("password"));
        email.sendKeys("rash");
        pass.sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        assertTrue(driver.getPageSource().contains("Product"));
	}
	
	//@Test
	public void loginFail() {
        driver.get("http://localhost:6080/ProteinStore");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/div/form/div/button"));         
        email.sendKeys("rash");
        pass.sendKeys("rash");
        button.click();
        assertTrue(driver.getPageSource().contains("Invalid username or password, Please try again with valid"));
	}
	
	//@Test
/*	public void registrationSuccess() {
        driver.get("http://localhost:6080/ProteinStore/register.jsp");
        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement confirmpass = driver.findElement(By.name("confirmpass"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement button = driver.findElement(By.xpath("/html/body/div/form/div/button"));      
        firstname.sendKeys("fname");
        lastname.sendKeys("lname");
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("aa@gmail.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Login"));
	}
	
	//@Test
	public void forgotPasswordSuccess() {
        driver.get("http://localhost:6080/ProteinStore/forgotpassword.jsp");      
        WebElement confirmpass = driver.findElement(By.name("confirmpassword"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("newpassword"));
        WebElement button = driver.findElement(By.xpath("/html/body/div/form/div/button"));      
        pass.sendKeys("rash");
        confirmpass.sendKeys("rash");
        email.sendKeys("rashabihari.panda@wipro.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Login"));
	}*/
}
