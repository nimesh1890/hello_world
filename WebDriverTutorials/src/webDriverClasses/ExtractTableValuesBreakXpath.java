package webDriverClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractTableValuesBreakXpath {

	static WebDriver driver = null;
	
	public static void main(String[] args) {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/compucrack/catalog/admin/login.php");
		adminSignIn("compucrack", "compucrack");
		
		String startXpath = "//*[@id='contentText']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr[";
		String midXpath = "]/td[";
		String endXpath = "]";
		
		for(int row=1;row<=7;row++){
			
			for(int col=1;col<=4;col++){
				
				String value = driver.findElement(By.xpath(startXpath+row+midXpath+col+endXpath)).getText();
				System.out.print(value+"      ");
			}
			System.out.println();
		}
		
	}
	
	public static void adminSignIn(String username, String password){
		
		driver.get("http://localhost/compucrack/catalog/admin/login.php");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		
	}

}
