import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.PageHelper;

public class SleepTimerPage extends PageHelper {
    By sleepTimerSheet = By.id("bottom_sheet");
    By titleText = AppiumBy.androidUIAutomator("new UiSelector().text(\"MINUTER SOVTIMER\")");
    By custom = By.id("edt_custom_duration");
    By minimize = By.id("btn_cancel");

    public SleepTimerPage(AndroidDriver driver) { super(driver); }

    public boolean sleepTimerTextDisplayed(){return waitForElementToAppear(sleepTimerSheet).isDisplayed()
            && waitForElementToAppear(titleText).isDisplayed();}

    public void clickOff() { baseForScrolling("Av").click(); }

    public void clickFive() { baseForScrolling("5").click(); }

    public void clickTen() { baseForScrolling("10").click(); }

    public void clickTwenty() { baseForScrolling("20").click(); }

    public void clickThirty() { baseForScrolling("30").click(); }

    public void clickFortyFive() { baseForScrolling("45").click(); }

    public void clickSixty() { baseForScrolling("60").click(); }

    public void clickCustom(String minutes) {
        /*WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(" +
                "new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\"))" +
                ".setAsHorizontalList().scrollIntoView(new UiSelector().className(\"android.widget.TextView\")" +
                ".text(\"Annat\"))"));*/
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(" +
                "new UiSelector().scrollable(true)).setAsHorizontalList().scrollToEnd(5)"));
        if (!element.getText().equals("Annat")) {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()" +
                    ".scrollable(true)).setAsHorizontalList().scrollToEnd(1)"));
        }
        driver.findElement(custom).sendKeys(minutes);
        //driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Check"));
    }

    public void clickMinimize() { driver.findElement(minimize).click(); }

    public WebElement baseForScrolling(String sleepTimer) {
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(" +
                "new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\"))" +
                ".setAsHorizontalList().scrollIntoView(new UiSelector().className(\"android.widget.TextView\")" +
                ".text(\"" + sleepTimer + "\"))"));
        if (!element.getText().equals(sleepTimer)) {
            element.findElement(By.xpath("//android.widget.TextView[@text='" + sleepTimer + "']")).click();
        }
        return element;
    }

    public void assertOneMinuteSleepTimer() {
        clickCustom("1");
        driver.navigate().back();
        clickMinimize();
    }
}
