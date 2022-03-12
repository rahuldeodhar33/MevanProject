package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public static WebDriver driver;
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeTest
	public void dataSetup() throws IOException  {
		FileInputStream file1 = new FileInputStream("excelData.xlsx");
		wbook = new XSSFWorkbook(file1);
		sheet = wbook.getSheet("sheet1");
		
		report = new ExtentReports("ExtentReport.html");
	}
	@AfterTest
	public void dataTearDown() throws IOException {
		wbook.close();
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	
	}
	@AfterMethod
	public void tearDown () {
		driver.quit();
	}
	
}
