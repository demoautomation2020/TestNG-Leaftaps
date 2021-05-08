package Testleaf.TestAutomation;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import wrappers.GenericWrappers;

public class TestCase2 extends GenericWrappers {
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.silentOutput","true");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); 
		
		
		GenericWrappers objGw=new GenericWrappers();
		objGw.invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");
		objGw.enterById("username","DemoSalesManager");
		objGw.enterById("password", "crmsfa");
		objGw.clickByClassName("decorativeSubmit");
		objGw.clickByLink("CRM/SFA");
		objGw.clickByLink("Leads");
		objGw.clickByLink("Find Leads");
		objGw.enterByXpath("(//input[@name='firstName'])[3]","samson");
		objGw.clickByXpath("//button[contains(text(),'Find Leads')]");
		objGw.clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		objGw.verifyTitle("View Lead | opentaps CRM");
		objGw.clickByLink("Edit");
		objGw.enterById("updateLeadForm_companyName", "Test Company Name");
		objGw.clickByXpath("//input[starts-with(@value,'Update')]");
		objGw.verifyTextContainsById("viewLead_companyName_sp","Test Company Name");
		objGw.closeBrowser();
		
	 
	}

}
