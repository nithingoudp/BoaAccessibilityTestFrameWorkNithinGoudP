package boa.tests;

import boa.pages.OnlineBankingEnrollmentPage;
import boa.pages.SearchResultsPage;
import boa.pages.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static boa.config.Hooks.driver;

public class BoaAxesTest {

    private String url = "https://bankofamerica.com/online-banking/sign-in";
    private SignInPage signIngPage;
    private OnlineBankingEnrollmentPage onlineBankingEnrollmentPage;
    private SearchResultsPage searchResultsPage;

    @BeforeClass
    public void setupClass() {
        signIngPage = new SignInPage();
        onlineBankingEnrollmentPage = new OnlineBankingEnrollmentPage();
        searchResultsPage = new SearchResultsPage();
    }

    @Test
    public void boaAxesTest() {
        //Step 1
        driver.get(url);
        signIngPage.checkPageLoaded();
        signIngPage.analyzeThisPage();

        //Step 2
        signIngPage.clickOnlineEnrollmentButton();

        onlineBankingEnrollmentPage.checkPageLoaded();
        onlineBankingEnrollmentPage.analyzeThisPage();

        //Step 3
        driver.navigate().back();

        signIngPage.globalSearch("routing number");
        signIngPage.checkSearchResultsPopupIsDisplayed();
        signIngPage.analyzeThisPage();
        signIngPage.analyzeSearchPopUp();

        //Step 4
        signIngPage.clickViewAllSearchResults();

        searchResultsPage.checkPageLoaded();
        searchResultsPage.analyzeThisPage();
    }


}
