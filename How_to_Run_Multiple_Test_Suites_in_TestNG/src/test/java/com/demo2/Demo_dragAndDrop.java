package com.demo2;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Demo_dragAndDrop 
{
	WebDriver driver;
  @Test
  public void Drag_and_Drop() 
  {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
  }
  
  @Test
  public void Select_multiple_values_from_the_list() 
  {
	  	driver.get("http://automate-apps.com/select-multiple-options-from-a-drop-down-list/");
		WebElement element=driver.findElement(By.xpath("//div[@id='primary']//select[@name='cars']"));
		Select select=new Select(element);
		select.selectByVisibleText("Maruti");
		select.selectByVisibleText("BMW");
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
