package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AgreeDisagreePage extends BasePage{
	@FindBy(css=".qc-cmp2-summary-buttons>button:nth-child(3)")
	List<WebElement> btnList ;

	public AgreeDisagreePage(WebDriver driver) {
		super(driver);
	}
	@Step
	public void clickOnAgreeBtn(String btnName) {
		sleep(2000);
		for (WebElement name : btnList) {
			if(name.getText().equalsIgnoreCase("agree")) {
				click(name);
			}
			
		}
		
	}

}

