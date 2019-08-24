package Patient.MMPProjectCopy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass
{
	WebDriver driver;
	@BeforeTest
	public void diverInstance() throws Throwable
	{
	WebDriverManager.firefoxdriver().setup();	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
	}

}
