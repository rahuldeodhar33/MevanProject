package NSEINFO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NSE_Home {
	public static WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.nseindia.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	@AfterMethod
	public void closeWindow() {
		//driver.quit();
	}
}
