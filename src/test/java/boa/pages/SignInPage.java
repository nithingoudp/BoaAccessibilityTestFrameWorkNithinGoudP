package boa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static boa.config.Hooks.driver;
import static boa.config.Hooks.wait;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Enroll in Online Banking') and @id='header-enroll-in-online-banking-button']")
    private WebElement enrollOnlineBanking_button;

    @FindBy(id = "oid")
    private WebElement userId_textfield;

    @FindBy(id = "global-search-button")
    private WebElement globalSearch_button;

    @FindBy(id = "nav-search-query")
    private WebElement globalSearch_textfield;

    @FindBy(xpath ="//a[contains(text(), 'View all search results')]")
    private WebElement viewAllSearchResults_link;

    @FindBy(id = "global-search-results-flyout-wrapper")
    private WebElement searchResults_popUp;

    public SignInPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void analyzeThisPage() {
        super.analyzePage(this.getClass().getSimpleName());
    }

    public void analyzeSearchPopUp() {
        super.analyzePage(searchResults_popUp, "SearchPopUp");
    }

    public void checkPageLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(userId_textfield));
        Assert.assertTrue(userId_textfield.isDisplayed());
    }

    public void clickOnlineEnrollmentButton() {
        enrollOnlineBanking_button.click();
    }

    public void clickGlobalSearch() {
        globalSearch_button.click();
    }

    public void globalSearch(String input) {
        if (!globalSearch_textfield.isDisplayed())
            globalSearch_button.click();

        wait.until(ExpectedConditions.elementToBeClickable(globalSearch_textfield));
        globalSearch_textfield.sendKeys(input);
        globalSearch_button.click();
    }

    public void checkSearchResultsPopupIsDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllSearchResults_link));
        Assert.assertTrue(viewAllSearchResults_link.isDisplayed(), "View All Search Results PupUp is not loaded");
    }

    public void clickViewAllSearchResults() {
        checkSearchResultsPopupIsDisplayed();
        viewAllSearchResults_link.click();
    }
}
