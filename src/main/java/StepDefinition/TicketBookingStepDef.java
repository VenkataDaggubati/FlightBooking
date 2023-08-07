package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TicketBookingStepDef {

	public static WebDriver driver=null;

	@Given("^User launches flight booking application (.+)$")
	public void launchBrowser(String url){		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@And("^User selects trip type and cabin as (.+) and (.+)$")
	public void selectTrip(String tripType, String cabinType) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Agree & Close')]")).click();
		driver.findElement(By.xpath("//*[text()='"+tripType+"']")).click();
		driver.findElement(By.xpath("//*[@class='odf-link']")).click();
		driver.findElement(By.xpath("//li[text()='"+cabinType+"']")).click();
	}

	@And("^User select origin and destination as (.+) and (.+)$")
	public void launchBrowser(String origin, String destination) throws InterruptedException{	
		driver.findElement(By.xpath("//*[@placeholder='Where from?']")).sendKeys(origin);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Where from?']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@placeholder='Where from?']/parent::div/div")).click();
		driver.findElement(By.xpath("//*[@placeholder='Where to?']")).sendKeys(destination);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Where to?']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@placeholder='Where to?']/parent::div/div")).click();
	}

	@And("^User selects travel dates (.+)$")
	public void selectDates(String tripType) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='odf-calendar-month'])[2]/div[3]/div[1]")).click(); 
		if(!tripType.equalsIgnoreCase("One way")) {
			driver.findElement(By.xpath("(//div[@class='odf-calendar-month'])[2]/div[4]/div[1]")).click();
		}
		driver.findElement(By.xpath("//button[@class='odf-btn odf-btn-primary']")).click();
	}

	@And("^User selects passengers as (.+)$")
	public void selectPassengers(String passengerType) throws InterruptedException{
		driver.findElement(By.xpath("//*[@data-testid='pax-selector-summary']")).click(); 
		//Adults-2,Children-2
		String[] paxArray = passengerType.split(",");
		for(int i=0;i<paxArray.length;i++) {	
			if(paxArray[i].contains("Adults")) {
				String num = "";
				while(!num.equals(passengerType.split("-")[2])) {
					driver.findElement(By.xpath("//*[text()='Adults']/parent::div/following-sibling::div/div/div[3]/button")).click(); 
					num = driver.findElement(By.xpath("//*[text()='Adults']/parent::div/following-sibling::div/div/div[2]/div")).getText(); 
				}
			}
			else if(paxArray[i].contains("Children")) {
				String num = "";
				while(!num.equals(passengerType.split("-")[2])) {
					driver.findElement(By.xpath("//*[text()='Children']/parent::div/following-sibling::div/div/div[3]/button")).click(); 
					num = driver.findElement(By.xpath("//*[text()='Children']/parent::div/following-sibling::div/div/div[2]/div")).getText(); 
				}
			}
			else if(paxArray[i].contains("Infants")) {
				String num = "";
				while(!num.equals(passengerType.split("-")[2])) {
					driver.findElement(By.xpath("//*[text()='Infants']/parent::div/following-sibling::div/div/div[3]/button")).click(); 
					num = driver.findElement(By.xpath("//*[text()='Infants']/parent::div/following-sibling::div/div/div[2]/div")).getText(); 
				}
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@data-testid='pax-selector-summary']")).click();
		driver.findElement(By.xpath("//button[text()='Search Flights']")).click();
	}

	@And("^User selects airlines and flight Type as (.+) and (.+)$")
	public void selectairLine(String airLine, String flightType) throws InterruptedException{	
		Thread.sleep(15000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Airlines = driver.findElement(By.xpath("//span[text()='Airlines']"));
		js.executeScript("arguments[0].scrollIntoView();", Airlines);
		driver.findElement(By.xpath("//span[text()='Airlines']")).click(); 
		driver.findElement(By.xpath("//a[text()='Deselect all']")).click(); 		
		driver.findElement(By.xpath("//div[text()='"+airLine+"']")).click(); 		
		driver.findElement(By.xpath("(//div[contains(@class,'BaseBox') and text()='"+flightType+"'])[1]")).click(); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[text()='Select'])[1]")).click(); 
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//button[text()='Continue without hotel'])[1]")).click(); 
		Thread.sleep(20000);
		WebElement chooseFare = driver.findElement(By.xpath("//*[text()='Choose your fare']"));
		js.executeScript("arguments[0].scrollIntoView();", chooseFare);
		
	}

	@And("^User selects fare Type as (.+)$")
	public void selectFair(String fareType){
		List<WebElement> fareList = driver.findElements(By.xpath("//div[contains(@class,'product-header')]/div/div[text()]"));
		List<WebElement> selectBtn = driver.findElements(By.xpath("//span[text()='Select']"));
		for(int i=0;i<fareList.size();i++) {		
			if(fareList.get(i).getText().equals(fareType)) {
				selectBtn.get(i).click();
			}
		}
	}
}