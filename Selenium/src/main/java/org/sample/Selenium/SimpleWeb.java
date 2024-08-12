package org.sample.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleWeb {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement web =  driver.findElement(By.xpath("//h1[@class = 'display-6']"));
		String name = web.getText();
		System.out.println(name);
		if(name.equals("Web form")) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case fail");
		}
			
	
		driver.findElement(By.id("my-text-id")).sendKeys("Md Arif Hussain");
		driver.findElement(By.xpath("//input[@name = 'my-password']")).sendKeys("Huss@1narif");
	
		driver.findElement(By.name("my-textarea")).sendKeys("Hell Arif! How Are you?");
		
		//driver.findElement(By.name("my-disabled"));
		driver.findElement(By.linkText("Return to index")).click();
		
		driver.findElement(By.linkText("alerts.html")).click();
		driver.navigate().back();
		
		driver.navigate().back();
		
		WebElement web1 = driver.findElement(By.name("my-select"));
		Select sel = new Select(web1);
		//sel.selectByVisibleText("Three");
		sel.selectByValue("3");
		
		
	//	WebElement option = driver.findElement(By.xpath("//option[@value = 'Los Angeles']"));
	//	option.click();
		
		 driver.findElement(By.name("my-file")).sendKeys("C:\\Users\\HP\\Desktop\\ARIF HUSSAIN.jpg");
		
		Thread.sleep(1000);
		driver.findElement(By.id("my-check-2")).click();
		Thread.sleep(1000);
		
		WebElement radioButton = driver.findElement(By.id("my-check-1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].checked = false;", radioButton);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		Thread.sleep(1000);
		
		
		driver.quit();
		
		
	}

}
