package expedia.com.BootcampExpedia;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class BookingFunctionality {
	public WebDriver driver;
	    @Test(priority = 1)
	    public void Expedia1() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")).sendKeys("iad");
		driver.findElement(By.xpath("//*[@id=\"flight-destination-hp-flight\"]")).sendKeys("jfk");
		driver.findElement(By.xpath("//*[@id=\"flight-departing-hp-flight\"]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[81]")).click();
		driver.findElement(By.xpath("//*[@id=\'flight-returning-hp-flight\']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[88]")).click();
		driver.findElement(By.id("travel-advisory-close-button")).click();
		driver.findElement(By.xpath("//*[@id=\'gcw-flights-form-hp-flight\']/div[7]/label/button")).click();
	}
		@Test(priority = 2)
		public void Expedia2() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type=\'button\'])[35]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type=\'button\'])[37]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@data-test-id=\'select-button\'])[1]")).click();
	
		driver.findElement(By.xpath("(//button[@data-test-id='select-button'])[2]")).click();
		}
		@Test(priority = 3)
		public void Expedia3() {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> page = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(page.get(1));
		driver.findElement(By.id("bookButton")).click();

		driver.findElement(By.id("firstname[0]")).sendKeys("Melanie");
		driver.findElement(By.xpath("//input[@data-tealeaf-name='middleName']")).sendKeys("Grace");
		driver.findElement(By.id("lastname[0]")).sendKeys("Designpurrs");
		driver.findElement(By.id("phone-number[0]")).sendKeys("2403282355");
		driver.findElement(By.id("gender_female[0]")).click();

		Select pick = new Select(driver.findElement(By.id("date_of_birth_month0")));
		pick.selectByIndex(12);
		Select day = new Select(driver.findElement(By.id("date_of_birth_day[0]")));
		day.selectByVisibleText("14");
		Select year = new Select(driver.findElement(By.id("date_of_birth_year[0]")));
		year.selectByVisibleText("2017");
		}
		
		@Test(priority = 4)
		public void Expedia4() {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.findElement(By.xpath("(//input[@name=\"creditCards[0].cardholder_name\"])[2]")).sendKeys("55667788991122");
		
		Select month = new Select(driver.findElement(By.xpath("//select[@data-tealeaf-name=\"expirationMonth_1\"]")));
		month.selectByVisibleText("09-Sep");
		
		Select year= new Select(driver.findElement(By.xpath("(//select[@data-custom-rules=\"ccExpiry\"])[2]")));
		year.selectByVisibleText("2022");
		driver.findElement(By.xpath("(//input[@type=\"tel\"])[5]")).sendKeys("123");
		
		driver.findElement(By.id("complete-booking")).click();
	}

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex & Maryna\\eclipse-workspace\\BootcampExpedia\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("https://expedia.com");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
