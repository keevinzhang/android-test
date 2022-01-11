import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

import org.joda.time.LocalTime;

public class BookmarkPage extends PageHelper {
    //By createBookmarkTitleText = By.id("txt_title");
    //By createBookmarkTitleText = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Nytt bokmärke\")");
    By createBookmarkTitleText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Nytt bokmärke\")");
    //By savedBookmarkTitleText = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Bokmärken\")");
    By savedBookmarkTitleText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Bokmärken\")");
    By cancel = By.id("btn_cancel");
    By done = By.id("btn_action");
    By description = By.id("edt_description");

    By change = By.id("btn_action");
    By deleteBookmark = By.id("btn_remove");
    By emptyBookmark = By.id("txt_empty_message");

    public BookmarkPage(AndroidDriver driver) {super(driver);}

    public boolean createBookmarkTitleDisplayed(){return waitForElementToAppear(createBookmarkTitleText).isDisplayed();}

    public boolean savedBookmarkTitleDisplayed() { return waitForElementToAppear(savedBookmarkTitleText).isDisplayed();}

    public void clickCancel() { driver.findElement(cancel).click(); }

    public void clickDone() { driver.findElement(done).click(); }

    public void typeDescription(String text) { driver.findElement(description).sendKeys(text); }

    public void createBookmark(String text) {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();
        typeDescription(text + " - " + dtf.print(now));
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        clickDone();
    }

    public void clickChange() { driver.findElement(change).click(); }

    public void clickRemoveBookmark() { waitForElementToAppear(deleteBookmark).click(); }

    public void assertEmptyBookmark() {
        Assert.assertTrue(driver.findElement(emptyBookmark).getText().startsWith("Här hittar du bokmärken du sparat"));
    }
}
