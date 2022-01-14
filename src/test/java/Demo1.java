import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    WebDriver driver;

    @Test(priority = 1, dependsOnMethods = {"openBrowser"})
    public void openFacebook(){
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Assert.assertTrue(driver.getTitle().contains("Facebook"));  // checking title of the page

        FacebookLoginPage facebookElements = PageFactory.initElements(driver, FacebookLoginPage.class);
        Assert.assertTrue(facebookElements.facebookLogo.isDisplayed());     // checking facebook logo

    }


    @Test(priority = 2, dependsOnMethods = {"openFacebook"})
    public void facebookLogin(){
        FacebookLoginPage facebookLoginElement = PageFactory.initElements(driver, FacebookLoginPage.class);
        facebookLoginElement.userName.sendKeys("pitabasdehury@gmail.com");      // Entering username
        facebookLoginElement.password.sendKeys("Kala@1532");                    // Entering password
        facebookLoginElement.loginBtn.click();
    }


    @Test(priority = 0)
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

    }
}
