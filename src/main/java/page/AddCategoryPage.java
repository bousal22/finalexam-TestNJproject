package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import util.BrowserFactory;

public class AddCategoryPage {
	WebDriver driver;
	String newInput = "Salah2022";

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_NEW_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']")
	WebElement MONTH_DROPDOWN_ELEMENT;

	public void insertNewCategory() {

		CATEGORY_ELEMENT.sendKeys(newInput);
	}

	public void addNewInsertion() {
		ADD_NEW_ELEMENT.click();
	}

	public void usertNotAbleToAddDuplicateCategory() throws InterruptedException {
		CATEGORY_ELEMENT.sendKeys(newInput);
    	Thread.sleep(3000);
		ADD_NEW_ELEMENT.click();
		if ( driver.getPageSource().contains("The category you want to add already exists:")){
	         System.out.println(" the text is present");
	      } else {
	         System.out.println(" the text is not present");
	     	Thread.sleep(3000);

	      }
	   }


	public void validateDropdownMonths() throws InterruptedException {
		
		Select sel = new Select(MONTH_DROPDOWN_ELEMENT);
		List<WebElement> Ddown = sel.getOptions();

		for (WebElement A : Ddown) {
			System.out.println(A.getText());

		}
	}

}
