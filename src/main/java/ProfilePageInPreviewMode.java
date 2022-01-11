import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utilities.PageHelper;

public class ProfilePageInPreviewMode extends PageHelper {
    By profileTitle = By.id("txt_always");
    By loginButton = By.id("btn_log_in");

    public ProfilePageInPreviewMode(AndroidDriver driver) { super(driver); }

    public boolean profileTitleDisplayed() { return waitForElementToAppear(profileTitle).isDisplayed(); }

    public void clickLoginButton() { waitForElementToAppear(loginButton).click(); }
}
