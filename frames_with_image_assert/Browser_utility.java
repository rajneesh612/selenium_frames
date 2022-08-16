package frames_with_image_assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class Browser_utility {


	public static WebDriver webdriver;


	public static WebDriver browser_setting(String browser_name) {
		if(browser_name.equalsIgnoreCase("Mozilla")) {
			//if(browser_name.equals("Mozilla")) {	
			System.setProperty("webdriver.gecko.driver","D:\\java\\selenium-web-driver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			webdriver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("chrome")) {
			//else if(browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\java\\selenium-web-driver\\chrome-driver\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--start-maximized");
			webdriver = new ChromeDriver(options);
		}
		else if(browser_name.equalsIgnoreCase("edge")) {
			//else if(browser_name.equals("edge")) {
			System.setProperty("webdriver.edge.driver","D:\\java\\selenium-web-driver\\edge-driver\\edgedriver_win64\\msedgedriver.exe");
			webdriver=new EdgeDriver();
		}
		return webdriver;
	}





	public static WebDriver go_to(String url)
	{
		System.out.println("opening " +url);
		webdriver.get(url);
		return webdriver;
	}



	public static WebDriver getDriver() {
		return webdriver;
	}



	public static void close() { webdriver.close(); }

}


