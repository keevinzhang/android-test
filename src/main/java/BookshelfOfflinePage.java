import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PageHelper;

public class BookshelfOfflinePage extends PageHelper {
    By allTab = AppiumBy.accessibilityId("Alla");
    By favoritesTab = AppiumBy.accessibilityId("Favoriter");
    By offlineTab = AppiumBy.accessibilityId("Offline");
    By listsTab = AppiumBy.accessibilityId("Listor");

    By downloadedIcon = By.id("imageOffline");
    By downloadedText = By.id("textDownloaded");
    By offlineTabTitleText = By.id("textInfo");

    public BookshelfOfflinePage(AndroidDriver driver) { super(driver); }

    public void clickRemoveDownloadedBookIcon(String bookTitle) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(" +
                "\"android.view.ViewGroup\").resourceId(\"com.bokus.play:id/itemView\").childSelector(new UiSelector()"+
                ".text(\"" + bookTitle + "\").fromParent(new UiSelector().className(\"android.widget.FrameLayout\")" +
                ".resourceId(\"com.bokus.play:id/layoutDownloadIndicator\").childSelector(new UiSelector().resourceId("+
                "\"com.bokus.play:id/downloadIndicator\"))))")).click();
        driver.switchTo().alert().accept();
    }

    public boolean bookshelfOfflinePageSelected() { return waitForElementToAppear(offlineTab).isSelected(); }

    public void clickAllTab() { driver.findElement(allTab).click(); }

    public void clickFavoritesTab() { driver.findElement(favoritesTab).click(); }

    public void clickListsTab() { driver.findElement(listsTab).click(); }

    public void assertDownloaded() {
        WebElement downloadText = webDriverWaitHelper(120, downloadedText);
        WebElement downloadIcon = webDriverWaitHelper(120, downloadedIcon);
        Assert.assertTrue(downloadText.getText().contains("Nedladdad"));
        Assert.assertTrue(downloadIcon.isDisplayed());
    }

    public String getBookDownloadedTitle() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector()" +
                ".resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector()" +
                ".resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText();
    }

    public String assertBookDownloadedTitle(String bookTitle) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(" +
                "\"android.widget.TextView\").text(\"" + bookTitle + "\")")).getText();
    }

    public void assertNoBooksDownloaded() {
        String titleText = waitForElementToAppear(offlineTabTitleText).getText();
        Assert.assertTrue(titleText.startsWith("Totalt 0 MB"));
    }

    public void clickBookTitle(String title) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+title+"\")")).click();
    }
}
