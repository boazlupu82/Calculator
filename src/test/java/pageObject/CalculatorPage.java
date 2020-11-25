package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CalculatorPage extends BasePage {
	@FindBy(css = "#input")
	WebElement calcInput;
	@FindBy(css = "#BtnCalc")
	WebElement calcBtn;
	@FindBy(css = "#math-field")
	WebElement resultTextBox;
	@FindBy(css = ".btn.dropdown-toggle.pull-right")
	WebElement historyBtn;
	@FindBy(css = "#histframe li>.l")
	List<WebElement> formulaList;
	@FindBy(css = "#histframe li>.l")
	List<WebElement> resultList;

	public CalculatorPage(WebDriver driver) {
		super(driver);
	}

	@Step("Clicking = to calculate")
	public void clickCalcBtn() {
		click(calcBtn);
	}

	@Step("Get calculator result")
	public String getCalcResult() {
		sleep(2000);
		String result = calcInput.getAttribute("value");
		return result;
	}

	@Step("Click to view history")
	public void clickHistory() {
		click(historyBtn);
	}

	@Step("Choosing formula:{0}")
	public void calcOptionn(String opt) {
		String css = "#Btn" + opt;
		WebElement el = driver.findElement(By.cssSelector(css));
		click(el);
	}

	@Step
	public void clearResult() {
		calcOptionn("Clear");
		sleep(1000);
	}

	@Step("Is fromula exist:{0}")
	public boolean isEquationExist(String formula) {
		boolean exist = false;
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i).getText());
			if (formula.equalsIgnoreCase(resultList.get(i).getText())) {
				exist = true;
				System.out.println(exist);
				break;
			}
		}
		return exist;

	}
}
