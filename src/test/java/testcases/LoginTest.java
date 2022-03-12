package testcases;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;
	
public class LoginTest extends BaseClass{
	 
	@Test
	public void FailedLogin() {
		test = report.startTest("FailedLogin");
		LoginPage Login1 = new LoginPage();
		Login1.LoginFunction("bac@ggg.com","Abcd@123");
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		Assert.assertEquals(ActualMsg, ExpMsg);
		//not required anymore
		//if(ActualMsg.equals(ExpMsg)) {
		//	System.out.println("TC Passed");
		//}else {
		//	System.out.println("TC Failed");
		//}
		report.endTest(test);
	    }
	@Test
	public void PassedLogin() {
			LoginPage Login1 = new LoginPage();
			Login1.LoginFunction("rahuldeodhar33@gmail.com","Madhuban@08");
	}
		
	@Test
	@Parameters({"Param1","Param2"})
	public void paramTest(String UserNameVal, String PasswordVal) {
			LoginPage Login1 = new LoginPage();
			Login1.LoginFunction(UserNameVal,PasswordVal);
	}
	@Test
	public void extData() {
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		LoginPage Login1 = new LoginPage();
		Login1.LoginFunction(UserNameVal,PasswordVal);

	}
}
