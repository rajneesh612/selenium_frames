package frames_with_image_assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import org.testng.annotations.BeforeTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



public class Frames_with_image_assert_test {
	
	String URL = "https://www.selenium.dev" ;
	public static WebDriver driver;
  @Test
  public void f() throws IOException {
	  
	  driver=Browser_utility.browser_setting("Chrome");
	  driver=Browser_utility.go_to(URL);
	  
	  WebElement downloads = driver.findElement(By.xpath("//a[@href='/downloads']"));
	  downloads.click();
	  
	  WebElement element_java = driver.findElement(By.xpath("//img[@alt='Java']"));
	  
	  File logo_file=element_java.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(logo_file, new File( "./screenshot/javalogo_actual.png"));
	  //byte[] java_logo_Srcshot = element_java.getScreenshotAs(OutputType.BYTES);
	  
     //Screenshot java_logo_Srcshot = new AShot().takeScreenshot(driver, element_java);
 
     System.out.println("Screenshot for specified element captured successfully!");
     
  // Reading the image for comparision
     
     //File file1= new File(System.getProperty("D:\\java\\files\\images") +"\\javaAshot.png");
    // File file1= new File(System.getProperty("user.dir") +"screenshot\\javalogo_expected.png");
     
	    //BufferedImage expectedImage = ImageIO.read(file1);
	    BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\Rajneesh Sharma\\eclipse-workspace\\testselenium\\screenshot\\javalogo_expected.png"));
	    
	    File file2= new File(System.getProperty("user.dir") +"screenshot\\javalogo_actual.png");
	    
	    //C:\Users\Rajneesh Sharma\eclipse-workspace\testselenium\screenshot
	    //BufferedImage actualImage = ImageIO.read(file2);
	    BufferedImage actualImage = ImageIO.read(new File("C:\\Users\\Rajneesh Sharma\\eclipse-workspace\\testselenium\\screenshot\\javalogo_actual.png"));
	    
	    
     
	    ImageDiffer imgDiff1 = new ImageDiffer();
	    ImageDiff differnce = imgDiff1.makeDiff(expectedImage, actualImage);
	   // if(dif1.hasDiff()){
	  
    
     if (differnce.hasDiff() == false)        //Checking the difference using in-built functions)
     {
    
      System.out.println("Both logo images matched"); //in case when no difference found
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

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='allclasses-frame.html']"));
		driver.switchTo().frame(frame2); 

		List<WebElement> list_of_classFrame2 =driver.findElements(By.xpath("//a[@target='classFrame']"));
		int numberOf_class_frame= list_of_classFrame2.size();
		System.out.println(" No of class frames in web page = " +numberOf_class_frame);
		String name_frame_2= list_of_classFrame2.get(0).getText();
		System.out.println(" frame 2 text = " +name_frame_2);
		
		SoftAssert softAssertion= new SoftAssert();
		System.out.println("softAssert Method Was Started");
		softAssertion.assertTrue(name_frame_1==name_frame_2);
      
      
      
      
      
     }
      
     else
     {
      System.out.println("The logo images are different"); //in case when difference found
     // Assert.assertFalse(differnece.hasDiff(),"Result of Image comparsion");
      
     }
      
      }
  
  @BeforeTest
  public void beforeTest() {
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
