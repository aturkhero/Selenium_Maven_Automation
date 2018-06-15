package com.dice;

import java.sql.DriverPropertyInfo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dicejobsearch {
	
	
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String url="https://dice.com";
		
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice homepage succesfully loaded");
		}else {
			System.out.println("Step FAIL. Dice homepage did not load successfully");
			throw new RuntimeException("Step FAIL. Dice homepage did not load successfully");
		}
		
		
		String keyword="selenium";
		
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location="94304";
		
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();

		String count= driver.findElement(By.id("posiCountId")).getText();
		
		System.out.println(count);
		
		int countResult= Integer.parseInt(count.replace(",", ""));
		
		if(countResult>0) {
			
			System.out.println("Step PASS: keyword: "+ keyword + " search return: "+ countResult + " results in "+location);
		}else {
			
			System.out.println("Step FAIL: keyword: "+ keyword + " search return: "+ countResult + " results in "+location);
		}
		
		driver.close();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
