package GenericUtilites;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  This class Consist of generic methods related to Webdriver actions
 */

public class WebDriverUtility {
	
	/**
	 * This Method will maximize window 
	 * 
	 */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize window 
	 */
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
    /**
     *  This method will wait for the page Load 
     */
	public void wiatForPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait untill the element becomes visible
	 */
	
    public void waitForElementToBeVisible(WebDriver driver, WebElement element )
    	{
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	   wait.until(ExpectedConditions.visibilityOf(element));
    	}
    /**
     * This method will wait untill the element becomes Clickble 
     *
     */
    public void waitForElementToBeClickable(WebDriver driver , WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	   wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * This method will handle the drop dwon based on index
     *
     */
    public void handleDropDown(WebElement elemet , int Index)
    {
    	Select s= new Select(elemet);
    	s.selectByIndex(Index);
    }
    /**
     *  This method will handle dropdwon based on value
     */
    
    
    public void handleDropDown(WebElement element , String value)
    {
    	Select s= new Select(element);
    	s.selectByValue(value);
    }
    
    
    /**
     *  This method will handle dropdwon based on visible text
     */
    public void handleDropDown(String Text , WebElement element)
    {
    	Select s= new Select(element);
    	s.selectByVisibleText(Text);
    }
    /**
     * THis method will perpoferme mouseo Hover Actions
     */
    
    public void mouseHoverAction(WebDriver driver , WebElement element)
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    	
    }
    /**
     * This method will perfome Right click method any where in web page
     */
    public void rightClickActions(WebDriver driver )
    {
    	Actions act = new Actions(driver);
    	act.contextClick().perform();
    }
    /**
     * This method will performe Right on web element 
     */
    public void rightClickAction(WebDriver driver , WebElement element )
    {
    	Actions act = new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * This method will perfome on dobule click on any where on web page 
     */
	public void doubleClickAction(WebDriver driver )
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will performe doubleclick on a webElement
	 */
	public void doubleClickAction(WebDriver driver ,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will performe drag and drop actions
	 */
	
	public void dragAndDropAction(WebDriver driver , WebElement srcElement , WebElement dstelement)
	{
		Actions  act = new Actions(driver);
		act.dragAndDrop(srcElement, dstelement).perform();
	}
	/**
	 * This method will performe accpet the alert
	 * 
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will capture the text from Alert popup
	 * @return 
	 */
	public String  getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on index
	 */
	
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/*
	 * This method will handle frame based on name or ID
	 */
	public void handleFrame(WebDriver driver , String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/*
	 * This method will handle frame based on webelement
	 */
	
	public void handleFrame(WebDriver driver, WebElement element ) {
		driver.switchTo().frame(element);
	}
	
	/*
	 * This method will switch to Immediate Parent
	 */
	public void swithToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/*
	 * This method will switch to Default Frame
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/*
	 * This method will switch the window based on partially window title
	 */
	public void swithToWindow(WebDriver driver, String partialWinTitle) {
		//step1: Capture all the window IDs
		Set<String> winID = driver.getWindowHandles();
		
		//Step2: Navigate to each window
		for(String win: winID) {
		//	step3: Switch window and Capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
		//Step4: Compare the title with require partial title
			if(winTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
	/*
	 * This method will take sceenshot and save utilfolder
	 */
	
	public String takesScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShots\\"+screenshotName+".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();   //Used for extent Report
	}
	
	/*
	 * This method will perform random scroll downwards vertically
	 */
	public void scrollAcion(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
	}
	
	/*
	 * This method will scroll untill the element is identified in DOM
	 */
	
	public void scrollAction(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	

}
