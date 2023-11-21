import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class Infleet_Successfully_Login {

	
	public static void main(String[] args) throws Exception {

		//Invoke Browser
		//Chrome - ChromeDriver
		//Firefox - FirefoxDriver
		//Safari - SafariDriver
		//Edge 
		//chromedriver
		//step to invoke chromedriver
		
		//System.setProperty("webdriver.chrome.driver", "C:/Users/baste/OneDrive/Documents/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://172.30.1.169:3000/");
		
		takeSnapShot(driver,"C:\\Users\\baste\\OneDrive\\Pictures\\AutomationImages\\test1.png");
		
		
		
		driver.findElement(By.id("txt_login_username")).sendKeys("bastarr@innov8-365.com");
		driver.findElement(By.id("txt_login_password")).sendKeys("@Baster123");
		takeSnapShot(driver,"C:\\Users\\baste\\OneDrive\\Pictures\\AutomationImages\\test2.png");
		
		
		//Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.id("btn_user_login"));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        takeSnapShot(driver,"C:\\Users\\baste\\OneDrive\\Pictures\\AutomationImages\\test3.png");
		
		driver.findElement(By.id("btn_user_login")).click();
		Thread.sleep(7000);
		takeSnapShot(driver,"C:\\Users\\baste\\OneDrive\\Pictures\\AutomationImages\\test4.png");
		Thread.sleep(5000);
		
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.className("title_workflow_card")).getText(),"Workflow Tasks");
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.className("title_workflow_card")).getText());
		driver.close();
	}
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileHandler.copy(SrcFile, DestFile);
		
		
		}
	public static void Shatdown() {
	WebDriver driver = new ChromeDriver();
	
	driver.close();
		
		}

}
