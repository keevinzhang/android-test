import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.PageHelper;

public class ResetPasswordPage extends PageHelper {
    By forgotPasswordTitle = By.id("txt_input_info");
    By backButton = By.id("btn_back");
    By email = By.id("edt_email");
    By sendButton = By.id("btn_send");
    By resultTitle = By.id("txt_result_info");
    By openMailButton = By.id("btn_action");

    public ResetPasswordPage(AndroidDriver driver) { super(driver); }

    public boolean forgotPasswordTitleDisplayed() { return waitForElementToAppear(forgotPasswordTitle).isDisplayed(); }

    public void clickBackButton() { driver.findElement(backButton).click(); }

    public void typeEmail(String mailaddress) { waitForElementToAppear(email).sendKeys(mailaddress); }

    public void clickSendButton() { driver.findElement(sendButton).click(); }

    public boolean resultTitleDisplayed() { return waitForElementToAppear(resultTitle).isDisplayed(); }

    public void clickOpenMailButton() { driver.findElement(openMailButton).click(); }

    public void resetPassword(String mailaddress) {
        typeEmail(mailaddress);
        clickSendButton();
    }
}
