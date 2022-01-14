import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FacebookLoginPage {
    @FindBy(how = How.CSS, using = "div._8ice>img")
    WebElement facebookLogo;
    @FindBy(how = How.ID, using = "email") WebElement userName;
    @FindBy(how = How.ID, using = "pass") WebElement password;
    @FindBy(how = How.NAME, using = "login") WebElement loginBtn;
}
