package Remainingassignmentweek4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

//import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.tools.javac.code.Attribute.Array;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(("oneplus 10 pro")+Keys.ENTER);
		
		
		 String price = driver.findElement(By.className("a-price-whole")).getText();
		 System.out.println(price);
		 
			String cust=driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']/following::span[@class='a-size-base s-underline-text']")).getText();
System.out.println(cust);

	driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();

	

	Set<String> windowHandles=driver.getWindowHandles();
List<String> winList=new ArrayList<String>(windowHandles);
driver.switchTo().window(winList.get(1));
File source= driver.getScreenshotAs(OutputType.FILE);
	

File destination=new File("./oneplusmobilescreen1.png");
FileUtils.copyFile(source, destination);
Thread.sleep(3000);

		driver.findElement(By.id("add-to-cart-button")).click();

		
		Thread.sleep(5000);
		


String cartSubTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
if (cartSubTotal.contains(price))
	System.out.println("Price and cart total are same");


driver.quit();

}
}

