import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utilities.PageHelper;

public class WelcomePage extends PageHelper {
    By welcomeTitle = By.id("txt_welcome_title");
    By previewMode = By.id("btn_preview_mode");
    By loginHereLink = By.id("btn_login");

    public WelcomePage(AndroidDriver driver) { super(driver); }

    public boolean isDisplayed() {
        return waitForElementToAppear(welcomeTitle).isDisplayed();
    }

    public void clickPreviewModeButton() { driver.findElement(previewMode).click(); }

    public void clickLoginHereLink() { driver.findElement(loginHereLink).click(); }
}
