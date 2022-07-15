package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public class ValidateAddCategoryTest {

	WebDriver driver;

	@Test
	public void validateNewCategory() throws InterruptedException {

		driver = BrowserFactory.init();
		AddCategoryPage addcategorypage = PageFactory.initElements(driver, AddCategoryPage.class);
		Thread.sleep(3000);

		addcategorypage.insertNewCategory();
		Thread.sleep(3000);

		addcategorypage.addNewInsertion();
		Thread.sleep(3000);
		
		addcategorypage.usertNotAbleToAddDuplicateCategory();
		Thread.sleep(3000);
		
		addcategorypage.validateDropdownMonths();

		BrowserFactory.tearDown();
	}

}
