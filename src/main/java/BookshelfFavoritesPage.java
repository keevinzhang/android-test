import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

public class BookshelfFavoritesPage extends PageHelper {
    By allTab = AppiumBy.accessibilityId("Alla");
    By favoritesTab = AppiumBy.accessibilityId("Favoriter");
    By offlineTab = AppiumBy.accessibilityId("Offline");
    By listsTab = AppiumBy.accessibilityId("Listor");

    By downloadingText = By.id("textDownloaded");
    By favoritesListLoaded = AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
            "\"com.bokus.play:id/itemView\").index(1)");

    public BookshelfFavoritesPage(AndroidDriver driver) { super(driver); }

    public void clickAllTab() { driver.findElement(allTab).click(); }

    public void clickOfflineTab() { driver.findElement(offlineTab).click(); }

    public void clickListsTab() { driver.findElement(listsTab).click(); }

    public boolean assertBookshelfFavoritesPageSelected() { return waitForElementToAppear(favoritesTab).isSelected(); }

    public String getFirstBookTitle() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/textBookTitle\"))")).getText();
    }

    public String getBookTitle(String bookTitle) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").childSelector(new UiSelector().text(\""+bookTitle+"\"))")).getText();
    }

    public boolean waitForFavoritesListLoaded() {
        return webDriverWaitHelper(60, favoritesListLoaded).isDisplayed();
    }

    public void clickBookTitleMoreActions(String bookTitle) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").fromParent(new UiSelector().text(\"" + bookTitle + "\")" +
                ".fromParent(new UiSelector().resourceId(\"com.bokus.play:id/imageMenu\")))")).click();
        Assert.assertTrue(moreActionsDisplayed());
    }

    public void clickBookTitleDownloadIcon(String bookTitle) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").fromParent(new UiSelector().text(\"" + bookTitle + "\")" +
                ".fromParent(new UiSelector().resourceId(\"com.bokus.play:id/layoutDownloadIndicator\")))")).click();
        Assert.assertTrue(webDriverWaitHelper(2, downloadingText).isDisplayed());
    }
}
