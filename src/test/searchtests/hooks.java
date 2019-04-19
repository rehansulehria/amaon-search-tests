package searchtests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.basepage;

public class hooks extends basepage {

    public hooks() {
    }

    @Before
    public void setup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path.concat("\\src\\resources\\driver\\chromedriver.exe"));
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
