

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.Utility;

		
	public class TEST1{
		WebDriver WD;
		
		@BeforeClass 
		public void invoke(){
			System.setProperty("webdriver.gecko.WD","C:\\Users\\Anshu\\Desktop\\SELENIUM new\\drivers\\geckodriver\\geckodriver.exe");
			WD=new FirefoxDriver();
			WD.manage().window().maximize();
		}
		@AfterClass 
		public void close(){
			WD.close();
			WD.quit();
		}
		@BeforeMethod 
		public void login () throws InterruptedException, IOException{
			WD.get("https://www.yatra.com/");
			
			Utility.capturescreenshot(WD, "OpenURL");
			//Thread.sleep(3000);
			/* Input File declaration*/
			Properties P=new Properties();
			FileInputStream fis=new FileInputStream("V://eclipse_MARSworkspace//FIRST//LOgin");
			P.load(fis);
			WD.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			try {
				WD.findElement(By.id(P.getProperty("HOV"))).click();
				WD.findElement(By.id(P.getProperty("UN"))).click();
			} catch (Exception e){
			System.out.println("signin button clicked");
			Utility.capturescreenshot(WD, "signin");
			}
			
			WD.findElement(By.id(P.getProperty("MOB"))).sendKeys("9438807301");
			Utility.capturescreenshot(WD, "mobile no");
			WD.findElement(By.id(P.getProperty("CON"))).click();
			Thread.sleep(3000);
			WD.findElement(By.id(P.getProperty("PWD"))).sendKeys("anshu143");
			WD.findElement(By.id(P.getProperty("SUB"))).click();
			WD.findElement(By.xpath("(//*[@id='skip-mobile-verification'])[2]")).click();
			Utility.capturescreenshot(WD, "skip verification");
		}
		@AfterMethod 
		public void FlightStatus() throws IOException{
			Properties P=new Properties();
			FileInputStream fis=new FileInputStream("V://eclipse_MARSworkspace//FIRST//LOgin");
			P.load(fis);
			WD.findElement(By.xpath(".//*[@id='userLoginBlock']/a")).click();;
			WD.findElement(By.id(P.getProperty("OUT"))).click();
			Utility.capturescreenshot(WD, "LogOut");
		}
		@Test(priority=1)
		public void BookFlight() throws IOException, InterruptedException{
			Properties P=new Properties();
			FileInputStream fis=new FileInputStream("V://eclipse_MARSworkspace//FIRST//LOgin");
			P.load(fis);
			WD.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WD.findElement(By.name(P.getProperty("CITY"))).click();
			WD.findElement(By.name(P.getProperty("CITY"))).sendKeys("MAA");
			Utility.capturescreenshot(WD, "source city");
			Thread.sleep(1000);
			WD.findElement(By.name(P.getProperty("ARRIVAL"))).sendKeys("DEL");
			Utility.capturescreenshot(WD, "Destination city");
			Thread.sleep(1000);
			WD.findElement(By.name(P.getProperty("ARVDATE"))).click();
			WD.findElement(By.id(P.getProperty("ARVDATENO"))).click();
			WD.findElement(By.name(P.getProperty("DEPDATE"))).click();
			WD.findElement(By.id(P.getProperty("DEPDATENO"))).click();
			Utility.capturescreenshot(WD, "date details");
			WD.findElement(By.id(P.getProperty("SEARCH"))).click();
			Utility.capturescreenshot(WD, "search");
		}
		
		@Test(priority=2)
		public void Support(){
			WD.findElement(By.xpath(".//*[@class='dropdown-toggle'and contains(text(),'Support')]")).click();
			Utility.capturescreenshot(WD, "support");
			WD.findElement(By.xpath(".//*[@id='customer_support_ddn']//*[@title='Contact Us']")).click();
			Utility.capturescreenshot(WD, "contact");
		}
		@Test(priority=3)
		public void SpecialDeals(){
			
			WD.findElement(By.xpath(".//*[@class='dropdown-toggle'and contains(text(),'Special Deals')]")).click();
			Utility.capturescreenshot(WD, "Deals");
			WD.findElement(By.xpath(".//*[@id='discount_list']//*[@title='Offers']")).click();
			Utility.capturescreenshot(WD, "offers");
		}
	}



