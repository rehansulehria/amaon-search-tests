package searchtests;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import locators.elementlocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.basepage;
import pageobjects.searchpage;

import java.util.List;

public class stepdefs {

    basepage base = new basepage();
    private int getPrice;
    private String searchResultPagePrice;
    private String productTitles;

    @When("^Perform Search for \"([^\"]*)\"$")
    public void performSearch(String query) throws Throwable {
        new searchpage().enterSearchQuery(query);
    }

    @Then("^Verify Search Results are Greater than (\\d+)$")
    public void verifySearchResultsAreGreaterThan(int arg0) throws Throwable {
        List<WebElement> productPrice = new searchpage().finProductImage();
        Assert.assertTrue("verify search results are greater than zero",
                productPrice.size() > 0);

    }

    @Then("^Verify Search Results Cotain word \"([^\"]*)\"$")
    public void verifySearchResultsCotainWord(String word) throws Throwable {
        List<WebElement> titles = new searchpage().findProductTitle();
        productTitles = titles.get(0).getText();
        Assert.assertTrue("verify product title contains batman",
                titles.get(0).getText().contains(word));
    }

    @Then("^Verify Price is Above (\\d+) for First Item$")
    public void verifyPriceAboveZero(int arg0) throws Throwable {
        List<WebElement> itemsPrice = new searchpage().searchResultPrice();
        searchResultPagePrice = itemsPrice.get(0).getText();
        try {
            getPrice = Integer.parseInt(searchResultPagePrice);
            System.out.println(getPrice);
            Assert.assertTrue("verify Price is above zero",
                    getPrice > 0);
        } catch (NumberFormatException ex) {
            ex.getStackTrace();
        }
    }

    @Then("^Verify Price has \"([^\"]*)\" postfix$")
    public void verifyPriceHasPostfix(String postfix) throws Throwable {
        List<WebElement> getPostfix = new searchpage().euroPostFix();
        String priceSymbol = getPostfix.get(0).getText();
        Assert.assertTrue("verify price has euro post fix"
                , priceSymbol.contains(postfix));
    }

    @Then("^Verify Price is same on Product Page$")
    public void verifyPriceIsSameOnProductPage() throws Throwable {
        new searchpage().clickProductPage();
        List<WebElement> priceOnProductPage = new searchpage().priceOnProductPage();
        String priceonProductPage = priceOnProductPage.get(0).getText().split(" ")[1];
        Assert.assertEquals(searchResultPagePrice, priceonProductPage);
    }

    @Then("^Verify Price and Title on Product Page$")
    public void verifyPriceAndTitleOnProductPage() throws Throwable {
        List<WebElement> priceOnProductPage = new searchpage().priceOnProductPage();
        String priceonProductPage = priceOnProductPage.get(0).getText().split(" ")[1];
        Assert.assertEquals("price  is same on product page",
                searchResultPagePrice, priceonProductPage);
    }

    @And("^Verify Title is same on Product Page$")
    public void verifyTitleIsSameOnProductPage() throws Throwable {
        WebElement titleProductPage = new searchpage().titleOnProductPage();
        String productPageTitleText = titleProductPage.getText();
        Assert.assertEquals("title is same on product page",
                productTitles, productPageTitleText);
    }

    @Then("^Verify Rating is displayed$")
    public void verifyRatingIsDisplayed() throws Throwable {
        WebElement ratingProduct = new searchpage().ratingProduct();
        Assert.assertTrue("Rating is displayed on product",
                ratingProduct.isDisplayed());
    }
}
