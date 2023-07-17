package crmScript;



import org.testng.annotations.Test;


import crmPages.Login;
import genericLib.BaseClass;

public class TC_Login_001 extends BaseClass{
	@Test
	public void testcase1() throws InterruptedException {
		Login l = new Login(driver);
		l.usernametf();
		l.nextbutton();
		l.passwordtf();
		l.signinbutton();
		l.nobutton();
		
		driverutilities.switchtoframe(driver);
		l.saleshubApp();
		
		Thread.sleep(5000);
		
		/*Cases c = new Cases(driver);
		c.casebutton();
		Thread.sleep(5000);
		/*hread.sleep(5000);
		c.arrowbutton();*/
		//c.newcase();
	}
	
}
