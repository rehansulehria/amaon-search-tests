package pageobjects;

import locators.elementlocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchpage {
    basepage base = new basepage();

    public void enterSearchQuery(String query) {
        base.sendKeysToInputField(By.cssSelector(elementlocators.SEARCH_TEXTBOX), query);
        base.clickElement(By.cssSelector(elementlocators.SEARCH_RESULTS));
    }

    public List<WebElement> finProductImage() {
        return base.findElements
                (By.cssSelector(elementlocators.PRODUCT_IMAGE));
    }

    public List<WebElement> findProductTitle() {
       return base.findElements
                (By.cssSelector(elementlocators.PRODUCT_TITLE));
    }

    public List<WebElement> searchResultPrice() {
        return base.findElements
                (By.cssSelector(elementlocators.PRODUCT_PRICE));
    }

    public List<WebElement>  euroPostFix() {
        return base.findElements
                (By.cssSelector(elementlocators.PRICE_SYMBOL));
    }

    public void clickProductPage() {
        base.clickElement(By.cssSelector(elementlocators.PRODUCT_TITLE));
    }

    public List<WebElement>  priceOnProductPage() {
        return base.findElements
                (By.xpath(elementlocators.PRICE_PRODUCT_PAGE));
    }

    public WebElement  titleOnProductPage() {
        return base.findElement
                (By.id(elementlocators.TITLE_PRODUCT_PAGE));
    }


}
