package PDFTests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PDFProvider.PDFFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PDFTests {

	@Test
	public static void PDF_ReadWebPDF() throws InterruptedException, IOException
	{
		//setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        //Create driver object for Chrome
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Navigate to a URL
        driver.get("https://www.sogeti.com/globalassets/global/downloads/testing/test-automation-brochure_2014-11-05_v07.pdf");
        
        PDFFunctions.ReadPDFInURL("https://www.sogeti.com/globalassets/global/downloads/testing/test-automation-brochure_2014-11-05_v07.pdf");
        
        driver.quit();
	}
	
	@Test
	public static void PDF_ReadLocalPDF() throws InterruptedException, IOException
	{
        PDFFunctions.ReadPDFLocal("C:\\Users\\sande\\eclipse-workspace\\TestAutomation.AutoIT\\Files\\test-automation-brochure_2014-11-05_v07.pdf");        
        
	}
	
	@Test
	public static void PDF_ReadLocalPDFAtPage() throws InterruptedException, IOException
	{
        PDFFunctions.ReadPDFLocalAtPage("C:\\Users\\sande\\eclipse-workspace\\TestAutomation.AutoIT\\Files\\test-automation-brochure_2014-11-05_v07.pdf", 1);        
        
	}
	
	@Test
	public static void PDF_ReadLocalPDFBetweenPages() throws InterruptedException, IOException
	{
		PDFFunctions.ReadPDFLocalBetweenPages("C:\\Users\\sande\\eclipse-workspace\\TestAutomation.AutoIT\\Files\\test-automation-brochure_2014-11-05_v07.pdf", 1,2);
		//PDFFunctions.ReadPDFLocalBetweenPages("C:\\Users\\sande\\eclipse-workspace\\TestAutomation.AutoIT\\Files\\test-automation-brochure_2014-11-05_v07.pdf", 1,2);        
        
	}
	
	private String GetPath() {
		File dir = new File(System.getProperty("user.dir"));
        return dir.toString() + "\\OutlookFactory\\Files";
	}
}
