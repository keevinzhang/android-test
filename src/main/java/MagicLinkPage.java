import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utilities.PageHelper;

public class MagicLinkPage extends PageHelper {
    By backButton = By.id("btn_back");
    //WORKING - By magicLinkTitle = MobileBy.ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().textContains(\"Skriv in din mailadress\")");
    //NOT WORKING - should be @text instead of text() - By magicLinkTitle = By.xpath("//android.widget.TextView[contains(text(), 'Skriv in din mailadress')]");
    By magicLinkTitle = By.xpath("//android.widget.TextView[contains(@text, 'Skriv in din mailadress')]");
    By email = By.id("edt_email");
    By sendButton = By.id("btn_send");
    By resultTitle = By.id("txt_result_info");
    By openMailButton = By.id("btn_action");

    public MagicLinkPage(AndroidDriver driver) { super(driver); }

    public boolean magicLinkTitleDisplayed() { return waitForElementToAppear(magicLinkTitle).isDisplayed(); }

    public void clickBackButton() { driver.findElement(backButton).click(); }

    public void typeEmail(String mailaddress) { waitForElementToAppear(email).sendKeys(mailaddress); }

    public void clickSendButton() { driver.findElement(sendButton).click(); }

    public boolean resultTitleDisplayed() { return waitForElementToAppear(resultTitle).isDisplayed(); }

    public void clickOpenMailButton() { driver.findElement(openMailButton).click(); }

    public void sendMagicLink(String mailaddress) {
        typeEmail(mailaddress);
        clickSendButton();
    }
}
