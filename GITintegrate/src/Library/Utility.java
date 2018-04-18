package Library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void capturescreenshot(WebDriver WD,String screenshot){
		
		try {
			TakesScreenshot ts=(TakesScreenshot)WD;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source,new File("./screenshots/"+screenshot+".png"));
			System.out.println("screenshot taken");
		
			
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
		
		
		
		
	}

	
	

}

