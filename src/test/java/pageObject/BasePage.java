package pageObject;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
	}

	void click(WebElement el) {
		
		el.click();
	}

	void fillText(WebElement el, String text) {
		
		el.clear();
		el.sendKeys(text);
	}

	String getText(WebElement el) {
		
		return el.getText();
	}

	
	public void sleep(int miliSecs) {
		try {
			Thread.sleep(miliSecs);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	
	

}
