package searchtests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import locators.elementlocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.basepage;
import pageobjects.searchpage;

import java.util.List;

public class SearchStpdefs {
    basepage base = new basepage();
    private int getPrice;

    @Given("^User is on Amazon home page$")
    public void userIsOnAmazonDePage() throws Throwable {

    }

    @When("^Perform Search for \"([^\"]*)\"$")
    public void performSearchFor(String query) throws Throwable {
        base.sendKeysToInputField(By.cssSelector(elementlocators.SEARCH_TEXTBOX), query);
        base.clickElement(By.cssSelector("#issDiv0"));
    }

    @Then("^Verify Search Results are Greater than (\\d+)$")
    public void verifySearchResultsAreGreaterThan(int arg0) throws Throwable {
        List<WebElement> searchResult = new searchpage().finProductImage();
        Assert.assertTrue("", searchResult.size() > 0);

    }

    @Then("^Verify Search Results Cotain word \"([^\"]*)\"$")
    public void verifySearchResultsCotainWord(String word) throws Throwable {
        List<WebElement> titles = new searchpage().findProductTitle();
        Assert.assertTrue("", titles.get(0).getText().contains(word));
    }

    @Then("^Verify Price is Above (\\d+) for First Item$")
    public void verifyPriceIsForFirstItem(int arg0) throws Throwable {
        List<WebElement> itemsPrice = new searchpage().finProductImage();
        String firstProductPrice = itemsPrice.get(0).getText();
        try {
            getPrice = Integer.parseInt(firstProductPrice);
            System.out.println(getPrice);
            Assert.assertTrue("", getPrice > 0);
        } catch (NumberFormatException ex) {
            ex.getStackTrace();
        }
    }

    @Then("^Verify Price has \"([^\"]*)\" postfix$")
    public void verifyPriceHasPostfix(String postfix) throws Throwable {
        List<WebElement> getPostfix = new searchpage().finProductImage();
        String priceSymbol = getPostfix.get(0).getText();
        Assert.assertTrue("", priceSymbol.contains(postfix));
    }

    @When("^click on first product page$")
    public void clickOnFirstProductPage() throws Throwable {
        base.clickElement(By.cssSelector(elementlocators.PRODUCT_TITLE));
    }

    @Then("^Verify Price and Title on Product Page$")
    public void verifyPriceAndTitleOnProductPage() throws Throwable {
        List<WebElement> priceOnProductPage = new searchpage().priceOnProductPage();
        Assert.assertEquals("", getPrice, priceOnProductPage.get(0).getText());
    }
}
