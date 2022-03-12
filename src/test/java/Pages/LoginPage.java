package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	//Web Element Declaration : Page Factory
	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	@FindBy (className="login")
	WebElement LoginLink;
	@FindBy (name="user_login")
	WebElement UserName;
	@FindBy (id="password")
	WebElement Password;
	@FindBy (name="btn_login")
	WebElement LoginBtn;
	@FindBy (className="rememberMe")
	WebElement RememberMe;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		//Used same as dirver.findElement in below example which is commented
	}
	
	public void LoginFunction(String UserNameVal, String PasswordVal) {
		//Functions
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login.","Login Click Successful.");
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter User Name.","User Name entered.");
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password.","Password entered.");
		RememberMe.click();
		test.log(LogStatus.PASS, "Check RememberMe Check box.","Checkbox checked.");
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login.","Login Clicked.");
		//WebElement LoginLink = driver.findElement(By.className("login")); -> replaced by @FindBy
		//WebElement UserName = driver.findElement(By.name("user_login"));-> replaced by @FindBy
		//WebElement Password = driver.findElement(By.id("password"));-> replaced by @FindBy
		//WebElement LoginBtn = driver.findElement(By.name("btn_login"));-> replaced by @FindBy
		//WebElement RememberMe = driver.findElement(By.className("rememberMe"));-> replaced by @FindBy
	}

}
