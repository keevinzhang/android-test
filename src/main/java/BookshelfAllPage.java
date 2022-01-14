import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

public class BookshelfAllPage extends PageHelper {
    By allTab = AppiumBy.accessibilityId("Alla");
    By favoritesTab = AppiumBy.accessibilityId("Favoriter");
    By offlineTab = AppiumBy.accessibilityId("Offline");
    By listsTab = AppiumBy.accessibilityId("Listor");

    By searchButton = By.id("button1");
    By sortButton = By.id("button2");
    By filterButton = By.id("button3");

    By downloadingText = By.id("textDownloaded");
    By allListLoaded = AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
            "\"com.bokus.play:id/itemView\").index(1)");

    public BookshelfAllPage(AndroidDriver driver) { super(driver); }

    public boolean bookshelfAllTabSelected() { return waitForElementToAppear(allTab).isSelected(); }

    public void clickAllTab() { driver.findElement(allTab).click(); }

    public void clickFavoritesTab() { driver.findElement(favoritesTab).click(); }

    public void clickOfflineTab() { driver.findElement(offlineTab).click(); }

    public void clickListsTab() { driver.findElement(listsTab).click(); }

    public void clickSearchButtonBookshlefPage() { driver.findElement(searchButton).click(); }

    public void clickSortButtonBookshlefPage() { driver.findElement(sortButton).click(); }

    public void clickFilterButtonBookshlefPage() { driver.findElement(filterButton).click(); }

    public void clickBookTitleMoreActions(String bookTitle) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(" +
                "\"android.view.ViewGroup\").resourceId(\"com.bokus.play:id/itemView\").childSelector(new UiSelector()"+
                ".text(\"" + bookTitle + "\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/imageMenu\")))"
        )).click();
        Assert.assertTrue(moreActionsDisplayed());
    }

    public void clickBookTitleDownloadIcon(String bookTitle) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(" +
                "\"android.view.ViewGroup\").resourceId(\"com.bokus.play:id/itemView\").childSelector(new UiSelector()"+
                ".textContains(\"" + bookTitle + "\").fromParent(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/layoutDownloadIndicator\")))")).click();
        Assert.assertTrue(webDriverWaitHelper(2, downloadingText).isDisplayed());
    }

    public String getFirstBookTitle() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/textBookTitle\"))")).getText();
    }

    public String getBookTitle(String bookTitle) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").childSelector(new UiSelector().text(\""+bookTitle+"\"))")).getText();
    }

    public String getIndexBookTitle(int index) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/itemView\").index(" + index + ").childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/textBookTitle\"))")).getText();
    }

    public boolean waitForAllListLoaded() {
        return webDriverWaitHelper(60, allListLoaded).isDisplayed();
    }
}
