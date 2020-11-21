package UserDefinedlibraries;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * This method is defined to save test screen shots
 * @author 875192
 * @since 
 */
public class ScreenShot {
	public static void screenShotTC(WebDriver ldriver,String browser)throws IOException{
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		try
		{
			// to copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File("C:\\Users\\sam\\eclipse-workspace\\TripAutomation\\TCScreenshot\\"+browser+System.currentTimeMillis()+".png"));
		}catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

}
