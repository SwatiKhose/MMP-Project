package Patient.MMPProjectCopy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_001TestSendMessage extends TestBaseClass {
	
	WebDriver driver;
	HomePageLogin l1;
	
	@Test(priority=1)
	@Parameters({"username","password"})
	public void testloginMMP(String username, String password)
	{
		l1 = new HomePageLogin(driver);
		l1.loginHomepg(username, password);
	}
	
	@Test(priority=2)
	public void testMessageTab()
	{
		String msgactual= l1.messageTab();
		 String msgexpected= "Messages";
	    Assert.assertEquals(msgactual,msgexpected);
	    SoftAssert sa = new SoftAssert();
	  		sa.assertEquals(msgactual, msgexpected);
	    		sa.assertAll();
	    		}
	@Test(priority=3)
	@Parameters({"subject","message"})
	public void testsendMessaageTab(String subject,String message) throws InterruptedException
	{   
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		driver.findElement(By.id("subject")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[4]//td[1]//input[1]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
