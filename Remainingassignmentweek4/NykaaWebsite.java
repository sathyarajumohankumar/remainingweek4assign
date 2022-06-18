package Remainingassignmentweek4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaWebsite {

	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
String brandNa="L'Oreal Paris";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		Actions builder=new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		
		
		Thread.sleep(3000);
		
		
		WebElement sear = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
	
		
		WebElement brandName = driver.findElement(By.xpath("//a[contains(text(),'Paris')]"));
		

		builder.moveToElement(brands)
			.pause(5)
		.moveToElement(sear)
		.click()
		.sendKeys("L'oreal Paris" +Keys.ENTER)
		
		.moveToElement(brandName)
		.click()
		.perform();
		if(driver.getTitle().contains(brandNa))
		{
			System.out.println("its success" +brandNa+driver.getTitle());
		}
		else
		{
			System.out.println(brandNa);
			System.out.println(driver.getTitle());
		}

driver.findElement(By.xpath("//span[@class='sort-name']")).click();
driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

WebElement eleCategory = driver.findElement(By.xpath("//span[text()='Category']"));

eleCategory.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Hair']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Concern']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
List<WebElement> filters=driver.findElements(By.xpath("//span[text()='Filters Applied']"));
for(WebElement e:filters)
{
if(e.getText().contains("Shampoo")||e.getText().contains("color Protection"))
	{
	System.out.println("Applied filters successfully" +e.getText());
	}
}
Thread.sleep(3000);

builder.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]"))).click().perform();


Set<String> windowHandles=driver.getWindowHandles();
List<String> winList=new ArrayList<String> (windowHandles);
driver.switchTo().window(winList.get(1));
WebElement size = driver.findElement(By.xpath("//select[@title='SIZE']"));
Select ssize = new Select(size);
ssize.selectByVisibleText("175ml");
Thread.sleep(3000);
String mrp=driver.findElement(By.xpath("//div[@class='css-f5j3vf']//span[@class='css-1jczs19']")).getText();
System.out.println(mrp);
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();
Thread.sleep(3000);
driver.switchTo().frame(0);

String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']/div[@class='value']")).getText();
System.out.println("grandTotal:" +grandTotal);

Thread.sleep(3000);

driver.findElement(By.xpath("//span[text()='Proceed']")).click();


driver.switchTo().defaultContent();
		
Thread.sleep(3000);

driver.findElement(By.xpath("//button[text() = 'CONTINUE AS GUEST']")).click();


Thread.sleep(3000);

String finalgTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div[@class='value']")).getText();
System.out.println("Final Grand Total:" + finalgTotal);
if(finalgTotal.contains(grandTotal)) {
	System.out.println("Both the Grand Total same");
}else
	System.out.println("No difference");

	
driver.quit();



}
}
