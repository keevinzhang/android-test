import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

public class ExplorePage extends PageHelper {
    By exploreTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Topplistan ljudböcker\")");
    String base = "new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\")";

    public ExplorePage(AndroidDriver driver) { super(driver); }

    public void clickBook() {
        driver.findElement(AppiumBy.androidUIAutomator(base + ".childSelector(new UiSelector().className("+
                "\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(" +
                "\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/cover_frame\")))))")).click();
    }

    public String getBookTitle() {
        return driver.findElement(AppiumBy.androidUIAutomator(base + ".childSelector(new UiSelector()" +
                ".className(\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(" +
                "\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/txt_title\")))))")).getText();
    }

    public String getBookAuthor() {
        String author = driver.findElement(AppiumBy.androidUIAutomator(base + ".childSelector(" +
                "new UiSelector().className(\"android.view.ViewGroup\").index(0).childSelector(new UiSelector()" +
                ".resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(" +
                "\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/txt_author\")))))")).getText();
        String[] split = author.split(" ", 2);
        String splitAuthor = split[1];
        return splitAuthor;
    }

    public boolean exploreTitleDisplayed() {
        //return waitForElementToAppear(exploreTitle).getText().equals("Topplistan ljudböcker");
        return webDriverWaitHelper(15, exploreTitle).getText().equals("Topplistan ljudböcker");
    }

    public void assertAudiobookOnly() {
        Assert.assertTrue(driver.findElement(AppiumBy.androidUIAutomator(base + ".childSelector(" +
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(" +
                "\"Topplistan ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\")"+
                ".childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector()" +
                ".resourceId(\"com.bokus.play:id/txt_title\").textContains(\"Anomali\").fromParent(new UiSelector()" +
                ".resourceId(\"com.bokus.play:id/img_audio_book\")))))))")).isDisplayed()
                && elementNotInDOM(AppiumBy.androidUIAutomator("new UiSelector().resourceId(" +
                "\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(" +
                "\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Topplistan ljudböcker\")" +
                ".fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(" +
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/txt_title\").textContains(\"Anomali\").fromParent(new UiSelector().resourceId(" +
                "\"com.bokus.play:id/img_ebook\")))))))")));
    }

    public void assertEbookOnly(String sectionToScrollTo, String bookTitle) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(" +
                "true)).setAsVerticalList().scrollIntoView(new UiSelector().text(\"" + sectionToScrollTo + "\"))"));
        Assert.assertTrue(driver.findElement(AppiumBy.androidUIAutomator(base + ".childSelector(" +
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(" +
                "\"Nyheter eböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\")" +
                ".childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector()" +
                ".text(\"" + bookTitle + "\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/img_ebook\")" +
                "))))))")).isDisplayed() && elementNotInDOM(AppiumBy.androidUIAutomator("new UiSelector()"+
                ".resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(" +
                "\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Nyheter eböcker\").fromParent(" +
                "new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector()" +
                ".className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"" + bookTitle + "\")" +
                ".fromParent(new UiSelector().resourceId(\"com.bokus.play:id/img_audio_book\")))))))")));
    }
}
