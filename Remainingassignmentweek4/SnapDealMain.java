package Remainingassignmentweek4;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealMain {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
	WebElement mensf = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));

WebElement sportshoe=driver.findElement(By.xpath("//span[text()='Sports Shoes']/parent::a"));
Actions builder=new Actions(driver);
builder.moveToElement(mensf)
.pause(1000)
.moveToElement(sportshoe)
.click()
.pause(3000)
.perform();



driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();


driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();

driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
Thread.sleep(3000);


List<WebElement> eleSorted = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
List<String> sortedList = new ArrayList<String>();

for (WebElement e : eleSorted) {
	sortedList.add(e.getAttribute("display-price"));
}

boolean sorted = Ordering.natural().isOrdered(sortedList);
System.out.println("Items displayed sorted correctly : " + sorted);

WebElement val=driver.findElement(By.name("fromVal"));
val.clear();
val.sendKeys("500");
WebElement val2=driver.findElement(By.name("toVal"));
val2.clear();
val2.sendKeys("1200");
driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();


String filterPrice = "Price: Rs. 500 - Rs. 1200";
String filterColor = "Color: Navy";
List<WebElement> eleFilters = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
for (WebElement e : eleFilters) {
	String filterText = e.getText();

	if (filterPrice.equals(filterText) || filterColor.equals(filterText))

	System.out.println("Filter applied successfully - " + filterText);}


WebElement fir=driver.findElement(By.xpath("//picture/img"));
	builder.moveToElement(fir)
	.pause(5000)
	.perform();
Thread.sleep(3000);
File source = driver.getScreenshotAs(OutputType.FILE);
File destination = new File("./mobile.png");
FileUtils.copyFile(source, destination);



	driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
	Thread.sleep(2000);
	System.out.println("Price : "+ driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::div[3]/span")).getText());
	System.out.println("Discount percentage : "+ driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::div[3]/span[2]")).getText());
	driver.close();
	driver.quit();
	
	}
}




	
