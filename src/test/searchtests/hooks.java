package searchtests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.basepage;

public class hooks extends basepage {

    public hooks() {
    }

    @BeforeClass
    public void setup() {
        System.out.println("Invoking driver");
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path.concat("\\resources\\chromedriver.exe"));
        driver = new ChromeDriver();
        driver.get(walmartBaseURL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
