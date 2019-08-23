package Patient.MMPProjectCopy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLogin
{
	WebDriver driver;
	String msgexpected;
	String msgactual;

	public HomePageLogin(WebDriver driver)
	{
		this.driver= driver;
	}
	public void loginHomepg(String uname,String pwd)
	{	
		 driver.findElement(By.linkText("Patient Login")).click();
		 driver.findElement(By.linkText("Login")).click();
		 driver.findElement(By.id("username")).sendKeys(uname);
		 driver.findElement(By.id("password")).sendKeys(pwd);
		 driver.findElement(By.name("submit")).click();
	}
	
	public String messageTab()
	{
		msgactual = driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).getText();
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		//String actualurl= driver.getCurrentUrl();
		//String expectedurl="http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/index.php";
		return msgactual;
	}
	
	public String profileTab()
	{
		System.out.println("Inside testprofileTab()");
		String url= driver.getCurrentUrl();
		System.out.println("urrent url"+ url);
		driver.findElement(By.xpath("//li[3]//a[1]")).click();
		String url1= driver.getCurrentUrl();
		System.out.println("urrent url"+ url1);
		return url1;
		
		//Thread.sleep(2000);
//	    Assert.assertTrue(url1.contains("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/profile.php"));
//		String enable = driver.findElement(By.id("fname")).getAttribute("readonly");
//		String rdonly= "true";
//		Assert.assertEquals(enable, rdonly);
	}
}
