import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.PageHelper;

public class SearchPage extends PageHelper {
    By searchBox = By.id("searchView");
    By clearText = By.id("btnClear");
    By topHit = By.id("cover_frame");
    By topHitAuthor = By.id("txt_subtitle");
    //By moreBooksLink = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Visa fler böcker\")");
    By moreBooksLink = AppiumBy.androidUIAutomator("new UiSelector().text(\"Visa fler böcker\")");

    public SearchPage(AndroidDriver driver) { super(driver); }

    public boolean searchBoxDisplayed() { return waitForElementToAppear(searchBox).isDisplayed(); }

    public void typeInSearchBox(String search) {
        WebElement text = driver.findElement(searchBox);
        text.sendKeys(search);
        text.click();
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
        if (driver.isKeyboardShown()) {
            //driver.hideKeyboard();
            driver.navigate().back();
        }
    }

    public void clickClearText() { waitForElementToAppear(clearText).click(); }

    public void clickShowMoreBooksLink() { scrollToText("Visa fler böcker").click(); }

    public void clickTopHit() { waitForElementToAppear(topHit).click(); }

    public String getTopHitAuthor() {
        String author = waitForElementToAppear(topHitAuthor).getText();
        String[] split = author.split(" ", 2);
        String splitAuthor = split[1];
        return splitAuthor;
    }

    public void clickTitle(String bookTitle) {
        waitForElementToAppear(AppiumBy.androidUIAutomator("new UiSelector()" +
                ".textContains(\"" + bookTitle + "\")")).click();
    }
}
