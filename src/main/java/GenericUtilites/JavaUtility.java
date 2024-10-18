package GenericUtilites;

import java.sql.Date;
import java.util.Random;

/*
 * This class all the generic method related to Java
 */
public class JavaUtility {
	
	/*
	 * This method will provide the system date
	 */
	
	public String getSystemDate() {
		Date d= new Date(0);
	return	d.toString();
	}
	
	/*
	 * This method will provide the systemdate in specific format
	 */
	
	public String getSystemDateInFormat() {
		Date d = new Date(0);
		String date[] = d.toString().split(" ");
		String month= date[1];
		String date1 = date[2];
		String time= date[3].replace(":", "-");
		String year = date[4];
		
		String finalDate = date1+" "+month+" "+year+" "+time;
		return finalDate;
	}

	/*
	 * This method will return a random number for every run
	 */
	
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	
}
