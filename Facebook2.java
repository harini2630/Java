package testCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook2 {
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		List<WebElement> languages = driver.findElements(
                By.xpath("//ul[contains(@class,'localeSelectorList')]//a")
        );
		
		for(int i=0;i<languages.size();i++) {
			System.out.println(i+" -> "+languages.get(i).getAttribute("href"));
		}
		
		List<WebElement> footerLinks = driver.findElements(
		        By.xpath("//div[@id='pageFooter']//a")
		);
	
		for (int i = 0; i < footerLinks.size(); i++) {
		    System.out.println(i + " -> " + footerLinks.get(i).getAttribute("href"));
		}
			
	
		
		
		
		
	}

}
