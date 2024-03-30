package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlontTest {
	
	@Test(groups= {"Regression"})
	public void oneMore() throws Exception {
		
		System.out.println("***********"+System.getProperty("browser"));
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\AUTOMATION PROJECTS\\ONLY JAVA\\AUTOMATION_1\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("ding@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ding@123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='container']/div[2]//b"));
		String specific = "ZARA COAT 3";
		
		// (//div[@class='container']/div[2]//b)[2]
		String path1 = "(//div[@class='container']/div[2]//button[2])[";
		String path2 = "]";
		
		for(int i=0;i<products.size();i++) {
			if (products.get(i).getText().equals(specific))
				driver.findElement(By.xpath(path1+(i+1)+path2)).click();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
