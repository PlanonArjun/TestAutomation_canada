package com.GenericLibray;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public PropertyFileLibrary pLib = new PropertyFileLibrary();
	public ExcelFileLibrary eLib = new ExcelFileLibrary();
	public WebDriverLibrary wLib = new WebDriverLibrary();
	public JavaLibrary jLib = new JavaLibrary();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void bsConfig() {
		
		System.out.println("--- database connected successfully ---");
	}

	@BeforeClass
	public void bcConfig() throws Exception {
		
		String BROWSER  = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("Url");
		
		//browser 
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser started sucessfull.....");
		}
		else if (BROWSER.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("FireFox browser started sucessfull.....");
		}
		else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("MSEdge browser started sucessfull.....");
		}
		else {
			
			System.out.println("---Your Browser Configuration IsWrong----");
		}
		
		
		sdriver=driver;
		driver.get(URL);
		
		
	}

	@BeforeMethod
	public void bmConfig() {
		System.out.println("----------Login Successful---------");
	}

	@AfterMethod
	public void amConfig() {
		System.out.println("----------Logout Successful---------");

	}

	@AfterClass
	public void acConfig() {
		System.out.println("----------run Successful---------");

	}
	
	@AfterTest
	public void atConfig() {
		driver.close();
		System.out.println("----------driver close Successful---------");

	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("----------db Successful---------");

	}


}
