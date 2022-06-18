package Remainingassignmentweek4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement userName = driver .findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		
		 
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> winList = new ArrayList<String>(windowHandles);
		
		String parentWindow = winList.get(0);
			
		String fromWindow = winList.get(1);
		
		
		driver.switchTo().window(fromWindow);
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();

		
		driver.switchTo().window(parentWindow);
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();

	
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> winList2 = new ArrayList<String>(windowHandles2);
	
		String fromWindow2 = winList2.get(1);
		
		
		driver.switchTo().window(fromWindow2);
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();

		
		driver.switchTo().window(parentWindow);
		

		Thread.sleep(3000);		
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
	
		
		Alert alert = driver.switchTo().alert();
	
		alert.accept();
		Thread.sleep(3000);
		
		
		driver.switchTo().window(parentWindow);
		
		
		
		if(driver.getTitle().contains("View Contact | opentaps CRM")){
			System.out.println("The title of the page is verified ");
			
			System.out.println("Title : " + driver.getTitle());
		}
		else 
		{
			System.out.println("The title is null");
		} 
		
	}
}
		
		
		