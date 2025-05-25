package saucedemo_automation_testing_Pack;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SauceDemo {

	public static void main(String[] args) throws InterruptedException {
		//WEBDRIVER INITIALIZATION
		
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();
				
				//Browser on
				
				driver.get("https://www.saucedemo.com/v1/");
				driver.manage().window().maximize();	
				
				//  Implicit wait of 2 seconds
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		        
				
		       // Test Case 1: Wrong username - Right password
		        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
		        driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        driver.findElement(By.id("login-button")).click();
		        resetToLogin(driver);
		        
		             
		       //  Implicit wait of 2 seconds
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  
		        

		        // Test Case 2: Right username - Wrong password
		        driver.findElement(By.id("user-name")).sendKeys("standard_user");
		        driver.findElement(By.id("password")).sendKeys("wrong_pass");
		        driver.findElement(By.id("login-button")).click();
		        resetToLogin(driver);
		        
		        // Implicit wait of 2 seconds
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3 ));

		        // Test Case 3: Wrong username - Wrong password
		        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
		        driver.findElement(By.id("password")).sendKeys("wrong_pass");
		        driver.findElement(By.id("login-button")).click();
		        resetToLogin(driver);

		        // Test Case 4: Right username - Right password
		        driver.findElement(By.id("user-name")).sendKeys("standard_user");
		        driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        driver.findElement(By.id("login-button")).click();
		       
		       // Using absolute XPath to add the first product to the cart
		       driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();
		        
		        // Using absolute XPath to add the second product to the cart
		        
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/button")).click();
		        
		        // Click on the shopping cart icon using CSS selector
		        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		        
		       // Click "Continue Shopping"
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[1]")).click();
		        
		        //  Implicit wait of 2 seconds
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		        
		        // Remove first product from the cart (after it's added)
		        //driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();
		        
		     // Click the Add/Remove button for "Sauce Labs Backpack"
		        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();

		        
		        Thread.sleep(3000);

		        // Add 2 more products
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button")).click();
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[4]/div[3]/button")).click();
		        
		        // Click on the shopping cart icon using CSS selector
		        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		        
		        
		        
		        
		        
		         // ---------------- CHECKOUT PROCESS ----------------

		        // Click the "Checkout" button on the cart page
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]")).click();
		        
		        // Fill in checkout form: first name, last name, and postal code
		        driver.findElement(By.id("first-name")).sendKeys("wrong");
		        driver.findElement(By.id("last-name")).sendKeys("secret");
		        driver.findElement(By.id("postal-code")).sendKeys("z098");
		        
		        // Click the "Continue" button
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input")).click();
		        
		        // Click the "Finish" button to complete checkout
		        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]")).click();
		        
		        //  close browser
		        driver.quit();
		      
		    }

		    // Go back to login page and clear fields
		    public static void resetToLogin(WebDriver driver) {
		        driver.get("https://www.saucedemo.com/v1/");
		        driver.findElement(By.id("user-name")).clear();
		        driver.findElement(By.id("password")).clear();
		        
		        
		        
		    

	}

}
