package Utils;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*import java.util.Set;*/

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class snapshots {

	public  void Fullscreenshot () throws AWTException, IOException {
    
		// TODO Auto-generated constructor stub
		
		//Take screenshot using Robot class//
		Robot robot=new Robot();
		
		/*The Dimension class encapsulates the width and height of a component (in integer precision) in a single object.*/
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		
		/*Constructs a new Rectangle whose top left corner is (0, 0) and whose width and height
		 *  are specified by the Dimension argument*
		 */
		  
		  Rectangle rectangle=new Rectangle(screensize); 
		  
		 /* Creates an image containing pixels read from the screen. This image does not include the mouse cursor*/
		  BufferedImage source= robot.createScreenCapture(rectangle);
		  
		  int i=1;
		  File DestFile=new File("./snap/snap"+i+ ".jpg");
		  
		  /*Rendered Images*/
		  
		  ImageIO.write(source,"jpeg", DestFile);
	}
	
	public void screenshot(TakesScreenshot driver) throws IOException
	{
		//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                
              //Move image file to new destination
                
                int i=1;

                File DestFile=new File("./snap/snap"+i+".jpg");
                
                //Copy file at destination
                
                try
                {
                	FileUtils.copyFile(SrcFile, DestFile);
                }

                catch (IOException e)
        		{
        			e.printStackTrace();
        		} i++;
	}

	

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub
		 
		snapshots screens=new snapshots();
		screens.screenshot();
		screens.Fullscreenshot();
		
	}

	
	protected void screenshot() {
		// TODO Auto-generated method stub
		
	}

}
