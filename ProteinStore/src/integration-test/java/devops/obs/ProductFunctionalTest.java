package devops.obs;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


@Category(IntegrationTest.class)
public class ProductFunctionalTest {
	
	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        
        driver = new FirefoxDriver(firefoxOptions);
    /*  
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		driver = new FirefoxDriver(); 
	*/	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}
	
	@Test
	public void productTest() {
        driver.get("http://localhost:6080/ProteinStore");
        
        // Login Test
        WebElement email = driver.findElement(By.name("uName"));
        WebElement pass = driver.findElement(By.name("password"));
        email.sendKeys("rash");
        pass.sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
       // assertTrue(driver.getPageSource().contains("Product")); 
   
        //Product Test
        List Checkbox = driver.findElements(By.name("items"));
        List<WebElement> options = driver.findElements(By.tagName("option"));
        String value ="";
        for(int i = 0; i< Checkbox.size(); i++) 
        	((WebElement) Checkbox.get(i)).click();
                
        for(WebElement select : options) {
        	if(select.getText().equals("1Kg")) {
        		select.click();
        	}
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();
       // assertTrue(driver.getPageSource().contains("Checkout"));

        //Checkout Test
		driver.findElement(By.id("fname")).sendKeys("Rashab");
		driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driver.findElement(By.id("adr")).sendKeys("Thoraipakkam");
		driver.findElement(By.id("state")).sendKeys("Tamil Nadu");
		driver.findElement(By.id("zip")).sendKeys("600069");
         
		driver.findElement(By.xpath("//button[@type='submit']")).click();
       // assertTrue(driver.getPageSource().contains("Purchase Success"));
	}

}
