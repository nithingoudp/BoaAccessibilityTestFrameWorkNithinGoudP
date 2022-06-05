package boa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static boa.config.Hooks.driver;

public class SearchResultsPage extends BasePage {

    @FindBy(id="nav-search-query")
    private WebElement search_textbox;

    @FindBy(xpath="//h2[contains(text(), 'How can we help?')]")
    private WebElement search_header;

    public void analyzeThisPage() {
        super.analyzePage(this.getClass().getSimpleName());
    }

    public SearchResultsPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void checkPageLoaded() {
        Assert.assertTrue(search_textbox.isDisplayed() && search_header.isDisplayed());
    }


}
