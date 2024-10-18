package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilites.WebDriverUtility;

public class IlmsElement extends WebDriverUtility {
		
	public IlmsElement(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//Click on iLMs 
    @FindBy(xpath="//a[@class='large__body__regular p2 d-flex align-center justify-center active' and  text()='ILMs'] ")
    private WebElement iLMsClass;
    
    // Select 

    
    
    
    
    public WebElement getiLMsClass() {
		return iLMsClass;
	}
	
    

	public void ClickIlmsButton() {
		iLMsClass.click();
	}
}
