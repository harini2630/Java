package testCode;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		// to verify the Title
		String title = driver.getTitle();
		if (title.equals("Google")) {
			System.out.println(title + " Title is verified ");
		}
		// to verify the Url
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("https://www.google.com/")) {
			System.out.println(currentUrl + "  URL is verified ");
		}
		driver.close();
	}

	

}
