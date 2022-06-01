package DevOpsCerti.CertificationProject;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FilpkartExample {
		WebDriver driver=null;
		@Test(priority=0,groups= {"Sanity","Regression"})
		public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\Chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/");	
		}
		
		@Test(priority=1,groups= {"Sanity","Regression"})
		public void closeLoginModalScreen() {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			
			
		}
		@Test(priority=2,groups={"Sanity","Regression"})
		public void hoverMILink()  {
			driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
			
			WebElement elecElement=driver.findElement(By.xpath("//span[text()='Electronics']"));
			Actions act=new Actions(driver);
			act.moveToElement(elecElement).perform();
			
			driver.findElement(By.xpath("//a[text()='Mi']")).click();
		}
		@Test(priority=3,groups={"Sanity","Regression"})
		public void verifyLatestFromMI() 
		{
			
		String valMI=driver.findElement(By.xpath("//p[text()='Latest from MI : ']")).getText();
		if (valMI.contains("Latest from MI : "))
		{
			System.out.println("Latest from MI is present on search page");
		}
		else
		{
			System.out.println("error");
		}
		
		}
		
		@Test(priority=4,groups= {"Regression"})
		public void movePriceSlider() 
		{
		WebElement priceSlider=driver.findElement(By.xpath("//div[@class='_3FdLqY']"));
		Actions movSlider=new Actions(driver);
		movSlider.moveToElement(priceSlider, 0, 12).perform();
		
		}
		
		@Test(priority=5,groups= {"Regression"})
		public void selectMaxPriceDrfopdown()  {
			WebElement selPrice=driver.findElement(By.xpath("//div[@class='_3zohzR']/following::select"));
			Select sel=new Select(selPrice);
			sel.selectByValue("13000");
			System.out.println("Third element selected");
			
		}
		
		@Test(priority=6,groups= {"Regression"})
		public void searchRedmiGoandClick() throws InterruptedException {
			//Redmi black was out of stock hence tried with a different example
			driver.findElement(By.className("_3704LK")).sendKeys("Unistuff Back Cover for Mi Redmi Go  (Brown, Dual Protection)");
			driver.findElement(By.className("L0Z3Pu")).click();
			Thread.sleep(2000);
			WebElement mob=driver.findElement(By.xpath("//span[@class='_2i7N3j']/following::img[1]"));
			Actions act2=new Actions(driver);
			act2.moveToElement(mob).click().build().perform();
			Thread.sleep(3000);
		
		}
		@Test(priority=7,groups= {"Regression"})
		public void newWindowSwitch() {
			
			Set<String> allWindows=driver.getWindowHandles();
			String secWindow=(String)allWindows.toArray()[1];
			driver.switchTo().window(secWindow);
			 String amt=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
			 
			 if(amt!="0")
			 {
				 System.out.println("Product is not equal to zero");
				 
			 }
			
		}
		@Test(priority=8,groups= {"Regression"})
		public void enterPINCOde() {
			
			WebElement pin=driver.findElement(By.className("_36yFo0"));
			Actions act=new Actions(driver);
			act.moveToElement(pin).sendKeys(pin,"560070").build().perform();
			driver.findElement(By.className("_2P_LDn")).click();
		}
		@Test(priority=9,groups= {"Regression"})
		public void viewDetails() {
			driver.findElement(By.className("YxlyDn")).click();
			boolean present=driver.findElement(By.xpath("//span[text()='Delivery & Installation details']")).isDisplayed();
			if (present) {
				System.out.println("Modal popup is seen");
			}
			else 
				System.out.println("Modal popup is not present");
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _1KAjNd']")).click();
		}
		@Test(priority=10,groups= {"Regression"})
		public void addToCart() {
			driver.findElement(By.className("_3SkBxJ")).click();
		}
		
		@Test(priority=11)
		public void closeBrowser() {
			driver.quit();
		}

	


}
