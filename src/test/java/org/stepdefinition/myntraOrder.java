package org.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class myntraOrder {
	public WebDriver driver;

	@Given("I open the Myntra web application")
	public void i_open_the_Myntra_web_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
	}

	@When("I type and search for the {string} product")
	public void i_type_and_search_for_the_product(String string) throws AWTException {
		WebElement search = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		search.sendKeys("T shirt");
		Robot r = new Robot();
		// To click the virtual KeyBoard Enter Click
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@When("I select the first product")
	public void i_select_the_first_product() {
		
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

	}

	@When("I select the {string} size")
	public void i_select_the_size(String string) throws InterruptedException {
		String wH = driver.getWindowHandle();
		Set<String> wHs = driver.getWindowHandles();
		for (String handle : wHs) {
			if (!handle.equals(wH)) {
				driver.switchTo().window(handle);
			}

		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//p[@class='size-buttons-unified-size'])[3]")).click();

	}

	@When("I click the {string} button")
	public void i_click_the_button(String string) {
		driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();

	}

	@Then("I close the current tab")
	public void i_close_the_current_tab() {
		driver.close();

	}

	@Then("I click the bag icon")
	public void i_click_the_bag_icon() {
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		WebElement bag = driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']"));
		bag.click();

	}

	@Then("I take a screenshot of the selected bag")
	public void i_take_a_screenshot_of_the_selected_bag() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\testMyntra\\screenShot\\Bag.png");
		FileUtils.copyFile(img, destination);
		driver.close();

	}

}
