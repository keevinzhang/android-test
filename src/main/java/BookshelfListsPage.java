import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utilities.PageHelper;

public class BookshelfListsPage extends PageHelper {
    By allTab = AppiumBy.accessibilityId("Alla");
    By favoritesTab = AppiumBy.accessibilityId("Favoriter");
    By offlineTab = AppiumBy.accessibilityId("Offline");
    By listsTab = AppiumBy.accessibilityId("Listor");

    By finishedBooks = By.id("buttonFinished");
    By addNewList = By.id("textView");
    By listsLoaded = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id" +
            "/recyclerView\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(0))");

    public BookshelfListsPage(AndroidDriver driver) { super(driver); }

    public boolean bookshelfListsPageSelected() { return waitForElementToAppear(listsTab).isSelected(); }

    public void clickAllTab() { driver.findElement(allTab).click(); }

    public void clickFavoritesTab() { driver.findElement(favoritesTab).click(); }

    public void clickOfflineTab() { driver.findElement(offlineTab).click(); }

    public void clickFinishedBooksList() { driver.findElement(finishedBooks).click(); }

    public void clickAddNewList() { driver.findElement(addNewList).click(); }

    public void clickFirstList() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(" +
                "\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/textTitle\"))")).click();
    }

    public void clickSpecificListByIndex(int index) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(" +
                "\"android.view.ViewGroup\").index(\"" + index + "\").childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/textTitle\"))")).click();
    }

    public void clickSpecificListByText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/textTitle\").text(\"" + text + "\")")).click();
    }

    public boolean waitForListsLoaded() {
        return webDriverWaitHelper(60, listsLoaded).isDisplayed();
    }
}
