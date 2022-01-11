package utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageHelper {
    protected AndroidDriver driver;
    private WebDriverWait wait;

    By moreActions = By.id("buttonMore");

    By audiobookIcon = By.id("imageAudioBook");
    By ebookIcon = By.id("imageEbook");

    By minimalizedPlayer = By.id("v_player_container");
    By minimalizedRewind = By.id("img_rewind");
    By minimalizedPlayOrPause = By.id("img_play");
    By minimalizedBookTitle = AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
            "\"com.bokus.play:id/constraint_parent\").childSelector(new UiSelector().resourceId(" +
            "\"com.bokus.play:id/txt_title\"))");

    //By unlockBook = By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='LÅS UPP BOKEN']");
    By unlockBook = By.id("button1");

    By sortButton = By.id("buttonSort");
    By sortFilterButton = By.id("btn_see_result");
    By filterButton = By.id("buttonFilter");
    By filterResultButton = By.id("btn_see_result");

    By moreActionsSheet = By.id("bottom_sheet");
    By addToFavorite = By.id("btn_favorite");
    By bookmark = By.id("btn_bookmarks");
    By markAsRead = By.id("btn_mark_as_read");
    By showMoreInfo = By.id("btn_show_more");
    By saveOffline = By.id("btn_sync_offline");

    By exploreTab = By.xpath("//android.widget.TextView[@text='Utforska']");
    By subjectsTab = By.xpath("//android.widget.TextView[@text='Ämnen']");
    By searchTab = By.xpath("//android.widget.TextView[@text='Sök']");
    By bookshelfTab = By.xpath("//android.widget.TextView[@text='Bokhylla']");
    By profileTab = By.xpath("//android.widget.TextView[@text='Profil']");

    public PageHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement webDriverWaitHelper(int seconds, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToAppear(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10l));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void sleepInMilliseconds(long period) {
        try {
            Thread.sleep(period);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickElementByText(String text) {
        waitForElementToAppear(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + text + "\")")).click();
    }

    public Actions longPressElement(By locator) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(waitForElementToAppear(locator)).perform();
        return actions;
    }

    public void scrollVerticallyOneViewDownwards() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollForward()"));
    }

    public void scrollVerticallyNumberOfViewsDownward(int number) {
        for (int i = 0; i < number; i++) {
            scrollVerticallyOneViewDownwards();
        }
    }

    public WebElement scrollToText(String text) {
        WebElement el = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"))"));
        return el;
    }

    public WebElement scrollToId(String id) {
        WebElement el = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().resourceIdMatches(\"" + id + "\"))"));
        return el;
    }

    public WebElement scrollHorizontallyToText(String text) {
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
        return element;
    }

    public boolean elementNotInDOM(By locator) { return driver.findElements(locator).size() == 0; }

    public void navigateBackButton() { driver.pressKey(new KeyEvent(AndroidKey.BACK)); }
    public void navigateHomeButton() { driver.pressKey(new KeyEvent(AndroidKey.HOME)); }

    public boolean audiobookIconDisplayed() { return driver.findElement(audiobookIcon).isDisplayed(); }
    public boolean ebookIconDisplayed() { return driver.findElement(ebookIcon).isDisplayed(); }

    public void clickUnlockBook() {
        driver.switchTo().alert().accept();
        //driver.switchTo().alert();
        //driver.findElement(unlockBook).click();
    }

    public void clickMoreActions() {
        waitForElementToAppear(moreActions).click();
        Assert.assertTrue(driver.findElement(moreActionsSheet).isDisplayed());
    }

    public void clickMinimalizedPlayOrPause() { driver.findElement(minimalizedPlayOrPause).click(); }
    public void clickMinimalizedRewind() { driver.findElement(minimalizedRewind).click(); }
    public void maximizePlayer() { driver.findElement(minimalizedBookTitle).click(); }
    public void getMinimizedBookTitle() { driver.findElement(minimalizedBookTitle).click(); }

    public void clickSortButton() { waitForElementToAppear(sortButton).click(); }
    public void clickSortResultButton() { waitForElementToAppear(sortFilterButton).click(); }
    public void clickFilterButton() { waitForElementToAppear(filterButton).click(); }
    public void clickFilterResultButton() { waitForElementToAppear(filterResultButton).click(); }

    public boolean moreActionsDisplayed() { return waitForElementToAppear(moreActionsSheet).isDisplayed(); }
    public void clickAddToFavorite() { waitForElementToAppear(addToFavorite).click(); }
    public void clickBookmark() { waitForElementToAppear(bookmark).click(); }
    public void clickMarkAsRead() { waitForElementToAppear(markAsRead).click(); }
    public void clickShowMoreInfo() { waitForElementToAppear(showMoreInfo).click(); }
    public void clickSaveOffline() { waitForElementToAppear(saveOffline).click(); }

    public void clickExploreTab() { waitForElementToAppear(exploreTab).click(); }
    public void clickSubjectsTab() { waitForElementToAppear(subjectsTab).click(); }
    public void clickSearchTab() { waitForElementToAppear(searchTab).click(); }
    public void clickBookshelfTab() { waitForElementToAppear(bookshelfTab).click(); }
    public void clickProfileTab() { waitForElementToAppear(profileTab).click(); }
}
