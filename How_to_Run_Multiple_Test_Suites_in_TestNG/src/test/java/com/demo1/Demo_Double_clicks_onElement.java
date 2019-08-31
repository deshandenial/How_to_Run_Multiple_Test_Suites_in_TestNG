package com.demo1;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Demo_Double_clicks_onElement 
{
	WebDriver driver;
	
  @Test
  public void Double_clicks_onElement()
  {
	
	  driver.get("https://artoftesting.com/sampleSiteForSelenium.html");
		WebElement element=driver.findElement(By.xpath("//button[@id='dblClkBtn']"));
		Actions action=new Actions(driver);
		//action.doubleClick(element).build().perform();
		// (or)
		action.moveToElement(element).doubleClick().build().perform();
		Alert alert=driver.switchTo().alert();
		alert.accept();
  }
  
  @Test
  public void Dynamically_Identify_Tables_Data()
  {
	
	  driver.get("https://www.grocerycrud.com/documentation/tutorial_basic_methods/");
		driver.switchTo().frame(0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.xpath("//div[@class='switch-versions-container']//select[@id='switch-version-select']"));
		Select selectobj=new Select(element);
		selectobj.selectByValue("/demo/employees_example/datatables");
		
		
		String xpath1="//div[@class='dataTables_wrapper']/table//tr[";
		String xpath2="]/td[1]";
		
		
      
      	List<WebElement> rows=driver.findElements(By.xpath("//div[@class='dataTables_wrapper']/table/tbody/tr/td"));
      	System.out.println("No.Of Rows in a table:"+rows.size());
      	
		
     
			List<WebElement> col=driver.findElements(By.xpath("//div[@class='dataTables_wrapper']/table/thead/tr/th"));
		    System.out.println("No.Of Column in a table:"+col.size());
		   
		    
		    
		
		    for(int i=1;i<=rows.size();i++)
			{
				String name = driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
				System.out.println(name);
				if(name.contains("Fixter"))
				{
					for(int j=1;j<=col.size();j++)
					{
					
					String action=driver.findElement(By.xpath("//div[@class='dataTables_wrapper']/table//tr["+i+"]/td["+j+"]")).getText();
					System.out.println(action);
						if(action.contains("View"))
						{
							driver.findElement(By.xpath("//div[@class='dataTables_wrapper']/table//tr["+i+"]/td["+j+"]/a")).click();
						
						}
					}
					break;
				}  
				
				
			}

  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  	System.out.println("hai this is @BeforeTest Annotation");
	  	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("---disable-notification---");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
