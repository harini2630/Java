package testCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class VerifySecondLargestPrice {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");
        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        Select sort = new Select(
                driver.findElement(By.className("product_sort_container"))
        );
        sort.selectByVisibleText("Price (high to low)");
        Thread.sleep(3000);

        String productName =
                driver.findElements(By.className("inventory_item_name"))
                      .get(0).getText();
        System.out.println("Second Product Name: " + productName);

        String inventoryPriceText =
                driver.findElements(By.className("inventory_item_price"))
                      .get(0).getText();
        System.out.println("Second Product Price: " + inventoryPriceText);

        driver.findElements(By.className("btn_inventory"))
              .get(0).click(); 
        Thread.sleep(2000);

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        String cartPrice =
                driver.findElement(By.className("inventory_item_price"))
                      .getText();

        if (inventoryPriceText.equals(cartPrice)) {
            System.out.println("Price Verification PASSED");
        } else {
            System.out.println("Price Verification FAILED");
        }

        driver.findElement(By.className("checkout_button")).click();
        Thread.sleep(2000); 

        driver.findElement(By.id("first-name")).sendKeys("Sri");
        driver.findElement(By.id("last-name")).sendKeys("Harini");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(2000);

        driver.findElement(By.className("cart_button")).click();
        Thread.sleep(3000);

        List<WebElement> prices =
                driver.findElements(By.className("inventory_item_price"));

        ArrayList<Double> priceList = new ArrayList<>();

        for (WebElement price : prices) {
            priceList.add(
                Double.parseDouble(price.getText().replace("$", ""))
            );
        }

        Collections.sort(priceList, Collections.reverseOrder());
        System.out.println("Second Largest Price: $" + priceList.get(1));

        driver.findElement(By.className("cart_button")).click();
        Thread.sleep(3000);

        driver.close();
    }
}
