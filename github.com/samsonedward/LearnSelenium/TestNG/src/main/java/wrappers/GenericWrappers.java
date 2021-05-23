package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers{
	protected RemoteWebDriver driver;
	String parent="";
	int i=1;
	

	/**
	 * This method will launch the given browser and maximize the browser and set the
	 * wait for 30 seconds and load the url
	 * @param browser - Browser to be opened
	 * @param url - The url to be loaded
	 */
	public void invokeApp(String browser, String url) {

		//try block has all the possible conditions
		System.setProperty("webdriver.chrome.silentOutput","true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		try {
			if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
				driver = new ChromeDriver() ;
			}
			else if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
				driver = new FirefoxDriver() ;
			}
			driver.get(url);
			parent=driver.getWindowHandle();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The browser launched successfully.");
		} 
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally 
		{
			takeSnap();
		}
	}
	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * @param idValue - id 
	 * @param data - The data to be sent
	 */
	public void enterById(String idValue, String data) {
		//try block has all the possible conditions
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The text field is entered with value "+data);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element Not found :" +idValue);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * @param nameValue - name
	 * @param data - The data to be sent
	 */
	public void enterByName(String nameValue, String data) 
	{
		//try block has all the possible conditions
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The text field is entered with value "+ data);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Element not found : " + data);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * @param xpathValue - xpath
	 * @param data - The data to be sent
	 */
	public void enterByXpath(String xpathValue, String data) 
	{	
		//try block has all the possible conditions
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The value entered is :" + data);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.out.println("Element not found : " + data);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}

	}

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @return - true or false
	 */
	public void verifyTitle(String title) 
	{	
		//try block has all the possible conditions
		try {
			String pageTitle = driver.getTitle();
			System.out.println("Page Title "+pageTitle);
			if(pageTitle.contains(title))
			{
				System.out.println("verified successfully " + title);
			}
			else
			{
				System.out.println("verification failed " + title);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + title);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will verify the given text
	 * @param id - id
	 * @param text  - The text to be verified
	 */
	public void verifyTextById(String id, String text) 
	{
		//try block has all the possible conditions
		try {
			String verifyText = driver.findElementById(id).getText();
			System.out.println("GetText -->"+verifyText);
			if(verifyText.equals(text))
			{
				System.out.println("The verified text is : " +text);
			}
			else
			{
				System.out.println("The text doesn't match " +text);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + text);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will verify the given text
	 * @param xpath - xpath
	 * @param text  - The text to be verified
	 */
	public void verifyTextByXpath(String xpath, String text) 
	{
		//try block has all the possible conditions
		try {
			String verifyByXpath = driver.findElementByXPath(xpath).getText();
			if(verifyByXpath.equals(text))
			{
				System.out.println("The verified text using XPath is : " +text);
			}
			else
			{
				System.out.println("The text not matched using xpath : " +text);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + text);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will verify the given text
	 * @param xpath - xpath
	 * @param text  - The text to be verified
	 */
	public void verifyTextContainsByXpath(String xpath, String text) 
	{	
		//try block has all the possible conditions
		try {
			String textContainsXpath = driver.findElementByXPath(xpath).getText();
			if(textContainsXpath.contains(text))
			{
				System.out.println("The text contains : "+text);
			}
			else
			{
				System.out.println("The text not contains : "+text);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{

			System.out.println("Element not found : " + text);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will verify the given text
	 * @param id - id
	 * @param text  - The text to be verified
	 */
	public void verifyTextContainsById(String id, String text) 
	{
		//try block has all the possible conditions
		try {
			String textContainsId = driver.findElementById(id).getText();
			if(textContainsId.contains(text))
			{
				System.out.println("The text contains : "+text);
			}
			else
			{
				System.out.println("The text not contains : "+text);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + text);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) {
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();	
		}
	}

	/**
	 * This method will click the element using id as locator
	 * @param id - The id of the element to be clicked
	 */
	public void clickById(String id) 
	{
		//try block has all the possible conditions
		try {
			driver.findElementById(id).click();
			System.out.println("The element selected is " +id);
		}
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("the element you clicked"+id);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) {
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();	
		}


	}

	/**
	 * This method will click the element using className as locator
	 * @param classVal-  The className of the element to be clicked
	 */
	public void clickByClassName(String classVal) 
	{
		//try block has all the possible conditions
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The classname selected is :"+classVal);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + classVal);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will click the element using name as locator
	 * @param name-  The name of the element to be clicked
	 */
	public void clickByName(String name) 
	{
		//try block has all the possible conditions
		try {
			driver.findElementByClassName(name).click();
			System.out.println("the element is "+name);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + name);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}

	}

	/**
	 * This method will click the element using link as locator
	 * @param name-  The name of the element to be clicked
	 */
	public void clickByLink(String name) 
	{
		//try block has all the possible conditions
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("Link "+name+" is clicked sucessfully");
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + name);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}

	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal-  The xpath of the element to be clicked
	 */
	public void clickByXpath(String xpathVal) 
	{		
		//try block has all the possible conditions
		try {
			 driver.findElementByXPath(xpathVal).click();
			 System.out.println("The link in grid clicked is : "+xpathVal);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Link not found in grid : " + xpathVal);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}


	}

	/**
	 * This method will get the text of the element using id as locator
	 * @param idVal-  id
	 * @return-string
	 */
	public String getTextById(String idVal) 
	{
		String textById = null;
		//try block has all the possible conditions
		try {
			textById = driver.findElementById(idVal).getText();
			System.out.println("Text is :"+textById);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + idVal);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
		return textById;

	}

	/**
	 * This method will get the text of the element using xpath as locator
	 * @param xpathVal- xpath
	 * @return-string
	 */
	public String getTextByXpath(String xpathVal) 
	{
		String textByXpath="";
		//try block has all the possible conditions
		try {
			textByXpath = driver.findElementByXPath(xpathVal).getText();			
			System.out.println("Text is :"+textByXpath);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + xpathVal);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}		
		return textByXpath;
	}

	/**
	 * This method will select the drop down visible text using id as locator
	 * @param id - id
	 * @param value - value to be selected
	 */
	public void selectVisibileTextById(String id, String value) 
	{
		//try block has all the possible conditions
		try {
			WebElement dropdown1=driver.findElementById(id);
			Select db1=new Select(dropdown1);
			db1.selectByVisibleText(value);
			System.out.println("The dropdown is selected with value "+value);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + value);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}


	/**
	 * This method will select the drop down by index using id as locator
	 * @param id - id
	 * @param index - value to be selected 
	 */
	public void selectIndexById(String id, int index) 
	{
		//try block has all the possible conditions
		try {
			WebElement dropdown1=driver.findElementById(id);
			Select db1=new Select(dropdown1);
			db1.selectByIndex(index);
			System.out.println("The dropdown is selected with value "+index);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + index);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}

	}


	/**
	 * This method will switch to the parent Window
	 */
	public void switchToParentWindow() 
	{
		//try block has all the possible conditions
		try {
			
			driver.switchTo().window(parent);
		/*	Set<String> allWindows = driver.getWindowHandles();
			
			for (String splitWindow : allWindows)
			{
				System.out.println(splitWindow);
				driver.switchTo().window(splitWindow);
				break;
			}*/
		} 
		//in case of window not found this catch block will be executed
		catch (NoSuchWindowException e) 
		{
			System.out.println("No such window found");
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will switch to the last Window
	 */
	public void switchToLastWindow() 
	{
		//try block has all the possible conditions
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String splitWindow : allWindows) 
			{
				System.out.println(splitWindow);
				driver.switchTo().window(splitWindow);
			}
		} 
		//in case of window not found this catch block will be executed
		catch (NoSuchWindowException e) 
		{
			System.out.println("No such window found");
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	/**
	 * This method will accept the alert 
	 */
	public void acceptAlert()
	{
		//try block has all the possible conditions
		try {
			driver.switchTo().alert().accept();
			System.out.println("alert accepted");
		} 
		//in case of alert not found this catch block will be executed
		catch (NoAlertPresentException e) 
		{
			System.out.println("No such alert found");
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e)
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			//takeSnap();	
		}
	}
	/**
	 * This method will close all the browsers associated to the driver
	 */
	public void closeBrowser() 
	{
		//try block has all the possible conditions
		try {
			driver.quit();
		} 
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) {
			System.out.println("Browser closed");
		}
	}

	/**
	 * This method will take Snapshots
	 */
	public void takeSnap() 
	{

		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap"+i+".jpg");
		
		//try block has all the possible conditions
		try
		{
			FileUtils.copyFile(src, dest);
		}
		//in case of any input out exception thrown this will caught and trace it.
		catch (IOException e)
		{
			e.printStackTrace();
		}
		i++;

	}
	
	/**
	 * This method will verify the given text
	 * @param className - className
	 * @param text  - The text to be verified
	 */
	public void verifyTextByClassName(String className, String text) 
	{
		//try block has all the possible conditions
		try {
			String verifyText = driver.findElementByClassName(className).getText();
			if(verifyText.equals(text))
			{
				System.out.println("The verified text is : " +text);
			}
			else
			{
				System.out.println("The text doesn't match " +text);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + text);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}
	
	
	/**
	 * This method will read the text retrieved
	 * @param id - id
	 */
	public void readTextById(String id)

	{			
		System.out.println("The text is : "+ driver.findElementById(id).getText());
	
	}
	
	/**
	 * This method will click the element using className as locator
	 * @param classVal-  The className of the element to be clicked
	 * No snapshot can be taken
	 */
	
	public void verifycurrenturl(String title) 
	{	
		//try block has all the possible conditions getCurrentUrl
		try {
			String pageTitle = driver.getCurrentUrl();
			System.out.println("Page Title "+pageTitle);
			if(pageTitle.contains(title))
			{
				System.out.println("verified successfully " + title);
			}
			else
			{
				System.out.println("verification failed " + title);
			}
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + title);
		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			takeSnap();
		}
	}

	
	public void clickByClassNameNoSnap(String classVal) 
	{
		//try block has all the possible conditions
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The classname selected is :"+classVal);
		} 
		//in case of element not found this catch block will be executed
		catch (NoSuchElementException e) 
		{
			System.out.println("Element not found : " + classVal);

		}
		//in case of web browser closed or crashed the below catch will be executed
		catch (WebDriverException e) 
		{
			System.out.println("Browser closed");
		}
		//Executes even when the above steps gets success or failed
		finally {
			//takeSnap();
		}
	}

}








