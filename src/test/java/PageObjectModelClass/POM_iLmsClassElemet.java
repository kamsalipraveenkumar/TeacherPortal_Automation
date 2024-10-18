package PageObjectModelClass;

import org.testng.annotations.Test;

import GenericUtilites.BaseClass;
import ObjectRepositories.IlmsElement;

@Test
public class POM_iLmsClassElemet extends BaseClass {
	
	public void OpentheIlms() {
	
	IlmsElement il = new IlmsElement(driver);
	il.ClickIlmsButton();
	
	

}
}

