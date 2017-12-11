package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	 /*
	 In eclipse->java project->rigth click->new-> File-> name=settings.properties->finish
	 ------------------------------------------------
	 type as shown as below inside the file and save
	 ------------------------------------------------
	 AUT=http://localhost:8080/login.do
     ITO=10
     ETO=12
     ------------------------------------------------------------------
     update openApplication() present in BaseTest as shown as below
     ------------------------------------------------------------------
	 */
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String browser){
		if(browser.equals("chrome")){
		driver=new ChromeDriver();
		}
		else{
			driver=new FirefoxDriver();
		}
		String AUT=AUL.getProperty(SETTING_PATH, "AUT");
		driver.get(AUT);
		String strITO=AUL.getProperty(SETTING_PATH, "ITO");
		long ITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult res){
		String testName=res.getName();
		if (res.getStatus()==2) {
			AUL.takePhoto(PHOTO_PATH, testName, driver);
		}
		driver.quit();
	}
	

}
