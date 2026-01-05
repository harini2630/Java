package testCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public static void main(String[] args) {

		// to launch the ChromeBrowser

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles", Keys.ENTER);

		//
		String text = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println(text);

		List<WebElement> elements = driver.findElements(By.className("a-price-whole"));
		for (int i = 0; i < elements.size(); i++) {

			System.out.println(elements.get(i).getText());
		}

	}

}
