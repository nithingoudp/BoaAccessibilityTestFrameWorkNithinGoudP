package boa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static boa.config.Hooks.driver;
import static boa.config.Hooks.wait;

public class OnlineBankingEnrollmentPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Enroll in Online & Mobile Banking')]")
    private WebElement pageHeader;

    @FindBy(id = "cancelCustomerAccount")
    private WebElement cancel_button;

    public void analyzeThisPage() {
        super.analyzePage(this.getClass().getSimpleName());
    }

    public OnlineBankingEnrollmentPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void checkPageLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(cancel_button));
        Assert.assertTrue(pageHeader.isDisplayed() && cancel_button.isDisplayed());
    }

}
