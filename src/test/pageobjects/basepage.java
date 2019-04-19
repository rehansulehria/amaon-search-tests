package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class basepage {
    public static WebDriver driver;
    public static final String walmartBaseURL = "https://www.amazon.de/";
    private WebDriverWait wait;

    public basepage() {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement findElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }
    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
         List<WebElement> eleement = driver.findElements(by);
        return eleement;
    }


    public void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
         driver.findElement(by).click();
    }

    public void sendKeysToInputField(By by, String keys) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        this.findElement(by).clear();
        this.findElement(by).sendKeys(keys);
    }

}
