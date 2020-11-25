package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.AgreeDisagreePage;
import pageObject.CalculatorPage;

public class MathOperationTest extends BaseTest {

	@Test(description = "Calculate with Sum function")
	public void tc01_CalculateSum() {
		AgreeDisagreePage adp = new AgreeDisagreePage(driver);
		adp.clickOnAgreeBtn("AGREE");
		CalculatorPage cp = new CalculatorPage(driver);
		cp.calcOptionn("2");
		cp.calcOptionn("Plus");
		cp.calcOptionn("3");
		cp.clickCalcBtn();
		String expeted = "5";
		String actual = cp.getCalcResult();
		Assert.assertEquals(actual, expeted, "Calculation succeeded");
	}

	@Test(description = "Calculate with Minus function")
	public void tc02_calculateMinus() {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.clearResult();
		cp.calcOptionn("1");
		cp.calcOptionn("0");
		cp.calcOptionn("Minus");
		cp.calcOptionn("2");
		cp.clickCalcBtn();
		String expeted = "8";
		String actual = cp.getCalcResult();
		Assert.assertEquals(actual, expeted, "Calculation succeeded");
	}

	@Test(description = "Calculate with formula-1 function")
	public void tc03_calculateFormula1() {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.clearResult();
		cp.calcOptionn("ParanL");
		cp.calcOptionn("1");
		cp.calcOptionn("0");
		cp.calcOptionn("Minus");
		cp.calcOptionn("2");
		cp.calcOptionn("ParanR");
		cp.calcOptionn("Mult");
		cp.calcOptionn("2");
		cp.clickCalcBtn();
		String expeted = "16";
		String actual = cp.getCalcResult();
		Assert.assertEquals(actual, expeted, "Calculation succeeded");
	}

	@Test(description = "Sinus Formula")
	public void tc04_calculatingFormula2() {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.clearResult();
		cp.calcOptionn("Sin");
		cp.calcOptionn("3");
		cp.calcOptionn("0");
		cp.calcOptionn("ParanR");
		cp.clickCalcBtn();
		String expeted = "0.5";
		String actual = cp.getCalcResult();
		Assert.assertEquals(actual, expeted, "Calculation succeeded");

	}

	@Test(description = "Formula validation")
	public void tc05_CheckingIfExistEquation() {
		boolean actual;
		CalculatorPage cp = new CalculatorPage(driver);
		cp.clickHistory();
		boolean sin = cp.isEquationExist("sin(30)");
		boolean minus = cp.isEquationExist("10-2");
		boolean plus = cp.isEquationExist("2+3");
		boolean pows = cp.isEquationExist("(10-2)*2");
		if (sin && minus && plus && pows) {
			actual = true;
		} else
			actual = false;
		Assert.assertEquals(actual, true);

	}
}
