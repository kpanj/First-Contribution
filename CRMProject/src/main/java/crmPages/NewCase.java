package crmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCase {
	@FindBy(xpath= "(//input[@role='combobox'])[1]")
	private WebElement account;
}
