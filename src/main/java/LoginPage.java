import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.PageHelper;

public class LoginPage extends PageHelper {
    By backButton = By.id("btn_back");
    By loginTitle = By.xpath("//android.widget.TextView[@text='Logga in']");
    By usernameElement = By.id("edt_username");
    By passwordElement = By.id("edt_password");
    By showOrHidePassword = By.id("btn_toggle_password_visibility");
    By login = By.id("btn_log_in");
    By resetPassword = By.id("btn_forgot_password");
    By magicLink = By.id("btn_magic_link");

    public LoginPage(AndroidDriver driver) { super(driver); }

    public boolean isDisplayed() {
        //return webDriverWait(5).until(ExpectedConditions.presenceOfElementLocated(loginTitle)).isDisplayed();
        return waitForElementToAppear(loginTitle).isDisplayed();
    }

    public void clickBackButton() { driver.findElement(backButton).click(); }

    public void typeUsername(String username) {
        //webDriverWait(5).until(ExpectedConditions.presenceOfElementLocated(usernameElement)).sendKeys(username);
        waitForElementToAppear(usernameElement).sendKeys(username);
    }

    public void typePassword(String password) { driver.findElement(passwordElement).sendKeys(password); }

    public void clickShowOrHidePassword() { driver.findElement(showOrHidePassword).click(); }

    public void clickLogin() { driver.findElement(login).click(); }

    public void clickResetPassword() {
        //webDriverWait(5).until(ExpectedConditions.presenceOfElementLocated(resetPassword)).click();
        waitForElementToAppear(resetPassword).click();
    }

    public void clickMagicLink() {
        //webDriverWait(5).until(ExpectedConditions.presenceOfElementLocated(magicLink)).click();
        waitForElementToAppear(magicLink).click();
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLogin();
    }
}
