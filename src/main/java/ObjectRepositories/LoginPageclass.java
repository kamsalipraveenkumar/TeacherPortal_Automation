package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageclass {
	
	//rule1: Create a pom class for every web page
	// rule2: Identify the webelements with @FindBy, @Findall and @FindBys
	
	@FindBy(id="userid")
	private WebElement usernameEdt;
	
	@FindAll({@FindBy(id="password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement Loginbutton;
	
	//Rule: Create constructor to intialize these web elements
	
	

	public LoginPageclass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	//Rule4: Provide getters to access this elements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	

	public WebElement getLoginbutton() {
		return Loginbutton;
	}

	//Rule5: Bussiness Libraries - Generic methods specific to current Project
	
	/*
	 * This method will login to application with Username and password
	 */
	
	public void LoginToApp(String userID, String password) {
		usernameEdt.sendKeys(userID);
		passwordEdt.sendKeys(password);
		Loginbutton.click();
	}
	

	

}
