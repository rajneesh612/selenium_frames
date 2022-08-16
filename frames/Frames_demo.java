package frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;


public class Frames_demo {
	public static WebDriver driver;
	public  void frames() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\java\\selenium-web-driver\\chrome-driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);

		String URL =" https://www.selenium.dev/";

		driver.get(URL);

		//a[@href='/downloads']

		WebElement downloads = driver.findElement(By.xpath("//a[@href='/downloads']"));
		downloads.click();

		//a[@href='https://seleniumhq.github.io/selenium/docs/api/java/index.html']


		WebElement api_link = driver.findElement(By.xpath("//a[@href='https://seleniumhq.github.io/selenium/docs/api/java/index.html']"));
		api_link.click();

		driver.findElement(By.xpath("(//a[text()='Frames'])[1]")).click();
		WebElement frame1 = driver.findElement(By.name("packageListFrame"));
		System.out.println(frame1.getText());

		driver.switchTo().frame(frame1); 
		WebElement frame1_element = driver.findElement(By.xpath(("/html/body/main/ul/li[1]/a")));
		frame1_element.click();
		String name_frame_1 = frame1_element.getText();
		System.out.println(name_frame_1);
		driver.switchTo().parentFrame();

		WebElement frame2Element = driver.findElement(By.xpath("//iframe[@title='All classes and interfaces (except non-static nested types)']"));
		frame2Element.click();

		//Finding all iframe tags on a web page
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);

		WebElement element_frame2 = driver.findElement(By.xpath("//iframe[@src='allclasses-frame.html']"));
		driver.switchTo().frame(element_frame2); 

		List<WebElement> list_of_classFrame =driver.findElements(By.xpath("//a[@target='classFrame']"));
		int numberOf_class_frame= list_of_classFrame.size();
		System.out.println(" No of class frames in web page = " +numberOf_class_frame);
		String name_frame_2= list_of_classFrame.get(0).getText();
		System.out.println(" frame 2 text = " +name_frame_2);
		
		SoftAssert softAssertion= new SoftAssert();
		System.out.println("softAssert Method Was Started");
		softAssertion.assertTrue(name_frame_1==name_frame_2);



	}

}
