import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

public class ProfilePageLoggedIn extends PageHelper {
    By mailOrPseudonym = By.id("txt_email");
    By changeProfile = By.id("btn_edit_profile");
    By subscriptionContainer = By.id("subscriptionContainer");
    By premium = AppiumBy.androidUIAutomator("new UiSelector().text(\"Premium\")");
    By subscriptionSubHeader = By.id("txtSubHeader");

    String commonQuestions = "com.bokus.play:id/btn_questions";
    String feedback = "com.bokus.play:id/btn_feedback";
    String logOut = "com.bokus.play:id/btn_log_out";
    By logOutHeader = By.id("android:id/message");
    By acceptLogOut = AppiumBy.androidUIAutomator("new UiSelector().text(\"JA\")");
    By denyLogOut = AppiumBy.androidUIAutomator("new UiSelector().text(\"NEJ\")");
    String version = "com.bokus.play:id/txt_version_number";

    public ProfilePageLoggedIn(AndroidDriver driver) { super(driver); }

    public boolean mailOrPseudonymDisplayed() { return waitForElementToAppear(mailOrPseudonym).isDisplayed(); }

    public boolean subscriptionContainerDisplayed(){return waitForElementToAppear(subscriptionContainer).isDisplayed();}

    public void clickChangeProfile() { driver.findElement(changeProfile).click(); }

    public void getPremiumText() { driver.findElement(premium).getText(); }

    public void getPremiumSubHeader() { driver.findElement(subscriptionSubHeader).getText(); }

    public void clickCommonQuestions() { scrollToId(commonQuestions).click(); }

    public void clickFeedback() { scrollToId(feedback).click(); }

    public void clickLogOut() {
        scrollToId(logOut).click();
        String logOutText = waitForElementToAppear(logOutHeader).getText();
        Assert.assertTrue(logOutText.equals("Du är på väg att logga ut, vill du fortsätta?"));
        driver.findElement(acceptLogOut).click();
    }

    public void getVersion() { scrollToId(version).getText(); }
}
