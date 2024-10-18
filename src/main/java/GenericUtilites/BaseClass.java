package GenericUtilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepositories.HomePageClass;
import ObjectRepositories.LoginPageclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	public PropertyFileUtility pUtil =new PropertyFileUtility();
	// public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	public WebDriver driver;
	
	
	
	//if want to use any data base back code we will store in this method
	
	@BeforeSuite
	public void BfConfig()
	{
		System.out.println("-------Database Connection Successfull---------");
		
	}
	
	@BeforeTest
	public void btConfig() {
		
		System.out.println("launch the application");
	}
	
	// browser Details store inside this method
	
	@BeforeClass
	public void BeforeClassConfig(/*String browser*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		String Brow = pUtil.readDataFromPropertyFile("browser");
		
		if(Brow.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("------------" + Brow +" Lanunch Successfully ------");
		}
		else if(Brow.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("------------" + Brow +" Lanunch Successfully ------");
		}
		
		else if(Brow.equalsIgnoreCase("fireox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("------------" + Brow +" Lanunch Successfully ------");
			
		} else 
		{
			System.out.println("Invalid Browser name ");
		}
		
		wUtil.maximizewindow(driver);
		wUtil.wiatForPage(driver);
		driver.get(URL);
	
	}
	
	//   User Credential Details store in this method
	
	@BeforeMethod
	public void BeforeMethodCOfig() throws IOException
	{
		String UserID =pUtil.readDataFromPropertyFile("userID");
		String Password = pUtil.readDataFromPropertyFile("password");
		
		LoginPageclass lp = new LoginPageclass(driver);
		lp.LoginToApp(UserID,Password);
		
		System.out.println("-------Login Successful-------");
	}
	
	// the web site application LogOut 
	
	@AfterMethod
	public void AfterMethoConfig()
	{
//		HomePageClass hp = new HomePageClass(driver);
//		hp.LogoutToApp();
		System.out.println("---Logout Successful---");
		
	}
	
	//  Closing the Browser 
	@AfterClass
	public void AfterClassCofig()
	{
		driver.quit();
		System.out.println("-----Browser Closed Successfull----");
	}
	
	@AfterTest
	public void atConfig() {
		System.out.println("Close the application");
	}
	
	// Closeing the dataBase Connection
	
	@AfterSuite
	public void AfterSuiteCofig()
	{
		System.out.println("--Database Closed Successfully -----");
	}
	
}
