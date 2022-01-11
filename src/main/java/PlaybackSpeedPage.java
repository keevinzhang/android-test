//import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.PageHelper;

public class PlaybackSpeedPage extends PageHelper {
    By speed = By.id("txt_speed");
    By playbackSpeedSheet = By.id("bottom_sheet");
    By minimize = By.id("btn_cancel");

    public PlaybackSpeedPage(AndroidDriver driver) { super(driver); }

    public boolean playbackSpeedSheetDisplayed() { return waitForElementToAppear(playbackSpeedSheet).isDisplayed(); }

    public void clickZeroPointSeven() { baseForScrolling("0.7"); }

    public void clickZeroPointEight() { baseForScrolling("0.8"); }

    public void clickZeroPointNine() { baseForScrolling("0.9"); }

    public void clickOne() { baseForScrolling("1.0"); }

    public void clickOnePointOne() { baseForScrolling("1.1"); }

    public void clickOnePointTwo() { baseForScrolling("1.2"); }

    public void clickOnePointThree() { baseForScrolling("1.3"); }

    public void clickOnePointFive() { baseForScrolling("1.5"); }

    public void clickOnePointSeven() { baseForScrolling("1.7"); }

    public void clickTwo() { baseForScrolling("2.0"); }

    public void clickMinimize() { driver.findElement(minimize).click(); }

    /*public void test(String playbackSpeed) {
        MobileElement element = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\")).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"" + playbackSpeed + "\"))");
    }*/

    public void baseForScrolling(String playbackSpeed) {
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(" +
                "new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\"))" +
                ".setAsHorizontalList().scrollIntoView(new UiSelector().className(\"android.widget.TextView\")" +
                ".text(\"" + playbackSpeed + "\"))"));
        String speedText = speed.toString().replace("x", "");
        if (!speedText.equals(playbackSpeed)) {
            element.findElement(By.xpath("//android.widget.TextView[@text='" + playbackSpeed + "']")).click();
        }
    }

}
