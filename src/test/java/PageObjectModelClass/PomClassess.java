package PageObjectModelClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilites.BaseClass;
import GenericUtilites.WebDriverUtility;
import ObjectRepositories.HomePageClass;
import ObjectRepositories.IlmsElement;
import ObjectRepositories.LoginPageclass;
import io.github.bonigarcia.wdm.WebDriverManager;


public class PomClassess extends BaseClass{

	@Test
	public  void launchapplication() {
		
		
		
//		driver.findElement(By.xpath("//button[@class='primary neo' and text()='Conduct Session']")).click();
		
		HomePageClass hp = new HomePageClass(driver);
		
		   hp.ClickConductButton();
		   
		   String exp = hp.sessionText();
		   
		   String act = "Conduct Session";
		   Assert.assertEquals(act,exp);
		   
		hp.selectGrade();
		hp.viewSkillbtn();
		hp.skill1();
		hp.Test1();
		
	
		
//		   if(hp.sessionText().contains("Conduct Session")) {
//			   
//			   System.out.println("Conduct text verified");
//		   }
//		   else {
//			   System.out.println("Conduct text not-verified");
//		   }
//		
		
		

//		LoginPageclass  lp = new LoginPageclass(driver);
//		     lp.LoginToApp(null, null);
		
		//		WebDriverManager.chromedriver().setup();
//		
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//
//		
//		driver.get("https://ulipsuteacher.netlify.app/auth/login");
//		LoginPageclass lp = new LoginPageclass(driver);
//		lp.LoginToApp("manojteach@ulipsu.com", "Ulipsu@101");
	

	}

}
