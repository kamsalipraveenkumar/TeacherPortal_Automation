package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilites.WebDriverUtility;

public class HomePageClass extends WebDriverUtility{
	
public HomePageClass(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
     // Select the Grade
	@FindBy(xpath="//select[@id='grade']")
	private WebElement selectGrade;
	
	// Click on View Skill Programs
    @FindBy(xpath="//button[text()='View Skill Programs']")
    private WebElement viewSkillbtn;
    
    // Click on Foundational Term 1
    @FindBy(xpath="//div[normalize-space()='Foundational Term 1']")
    private WebElement skill1;
    
    // Click on Term -1
    @FindBy(xpath="//div[text()='Term -1']")
    private WebElement Test1; 

    // Click on ConduntSession
	@FindBy(xpath="//button[@class='primary neo' and text()='Conduct Session']")
	private WebElement conduntSession;

	// To Validate to the ConsuctsessionText or Asseration
	@FindBy(xpath="//div[text()='Conduct Session']")
	private WebElement conductsessionTxt;
	
//	@FindBy(xpath="//div[text()='Manoj Teacher']")
//	private WebElement teacheButton;
//	
//	@FindBy(xpath="//span[text()='Log Out']")
//	private WebElement logoutbutton;
	
	
	
	public WebElement getSelectGrade() {
		return selectGrade;
	}
	
	public WebElement getViewSkillbtn() {
		return viewSkillbtn;
	}
	
	public WebElement getSkill1() {
		return skill1;
	}
	
	public WebElement getTest1() {
		return Test1;
	}
	
	public WebElement getConductsessionTxt() {
		return conductsessionTxt;
	}

//	public WebElement getTeacheButton() {
//		return teacheButton;
//	}
//	
	public WebElement getConduntSession() {
		return conduntSession;
	}

//	public WebElement getLogoutbutton() {
//		return logoutbutton;
//	}
	
	public void ClickConductButton() {
		
		conduntSession.click();
	}
	public String sessionText() {
		return conductsessionTxt.getText();
	}
	
//		teacheButton.click();
//		logoutbutton.click();

	public void selectGrade() {
		selectGrade.click();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.handleDropDown(selectGrade, 2);
		
	}

	public void viewSkillbtn() {
		viewSkillbtn.click();
		
	}
	
	public void skill1() {
		skill1.click();
	}
	
	public void Test1() {
		Test1.click();
		
	}
	
	
	
	}
	
		
	


	
	
	


