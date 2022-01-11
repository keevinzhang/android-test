import io.appium.java_client.android.AndroidDriver;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

public class AudiobookPlayerPage extends PageHelper {
    By minimizePlayer = By.id("buttonClose");
    By bookCover = By.id("imageArtwork");
    By bookTitle = By.id("textTitle");
    By bookAuthor = By.id("textSubtitle");
    By progressTime = By.id("textProgress");
    By remainingTime = By.id("textDuration");
    By playOrPause = By.id("buttonPlayPause");
    By playbackSpeedIcon = By.id("buttonPlaybackSpeed");
    By bookmarkIcon = By.id("buttonBookmarks");
    By sleepTimerIcon = By.id("buttonSleepTimer");

    public AudiobookPlayerPage(AndroidDriver driver) {super(driver);}

    public boolean bookCoverDisplayed() { return waitForElementToAppear(bookCover).isDisplayed(); }

    public void clickMinimizePlayer() { waitForElementToAppear(minimizePlayer).click(); }

    public String getBookTitle() { return driver.findElement(bookTitle).getText(); }

    public String getBookAuthor() { return driver.findElement(bookAuthor).getText(); }

    public String getProgressTime() { return waitForElementToAppear(progressTime).getText(); }

    public String getRemainingTime() { return waitForElementToAppear(remainingTime).getText(); }

    public void clickPlayOrPause() { driver.findElement(playOrPause).click(); }

    public void clickPlaybackSpeedIcon() { driver.findElement(playbackSpeedIcon).click(); }

    public void clickBookmarkIcon() { driver.findElement(bookmarkIcon).click(); }

    public void pauseAudiobookAndClickBookmarkIcon() {
        String time = getProgressTime();
        sleepInMilliseconds(1200);
        if (!time.equals(getProgressTime())) {
            clickPlayOrPause();
        }
        driver.findElement(bookmarkIcon).click();
    }

    public void clickSleepTimerIcon() { driver.findElement(sleepTimerIcon).click(); }

    public void assertAudioBookPlayed() {
        String time = getProgressTime();
        sleepInMilliseconds(2000);
        if (!time.equals(getProgressTime())) {
            clickPlayOrPause();
        }
        Assert.assertNotEquals(time, getProgressTime());
        /*Assert.assertTrue(time.equals(baseForSplittingTimeAndSubtractSeconds(2))
                || time.equals(baseForSplittingTimeAndSubtractSeconds(3))
                || time.equals(baseForSplittingTimeAndSubtractSeconds(4))
                || time.equals(baseForSplittingTimeAndSubtractSeconds(5))
                || time.equals(baseForSplittingTimeAndSubtractSeconds(6)));*/
    }

    public void assertEmptySleepTimer() {
        webDriverWaitHelper(62,
                By.xpath("//android.widget.TextView[@resource-id='com.bokus.play:id/buttonSleepTimer' and @text='']"));
        String timeAfterOneMinute = getProgressTime();
        sleepInMilliseconds(2000);
        System.out.println("Time after one minute sleep timer is: " + timeAfterOneMinute +
                "\nTime after 2 seconds sleep is: " + getProgressTime());
        Assert.assertEquals(timeAfterOneMinute, getProgressTime());
    }

    private String baseForSplittingTimeAndSubtractSeconds(int seconds) {
        String time = getProgressTime(); //getProgressTime() = e.g. 0:01:02 (0 hours, 1 min, 2 seconds)
        String[] split = time.split(":");
        DateTime dt = new DateTime().withTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]), //split[0] = 0
                Integer.parseInt(split[2]), 0).minusSeconds(seconds); //split[1] = 01, split[2] = 02
        DateTimeFormatter dftOut = DateTimeFormat.forPattern("H:mm:ss");
        String result = dftOut.print(dt); //result = 0:01:02
        return result;
    }

    private String baseForSplittingTimeAndAddSeconds(int seconds) {
        String time = getProgressTime();
        String[] split = time.split(":");
        DateTime dt = new DateTime().withTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
                Integer.parseInt(split[2]), 0).plusSeconds(seconds);
        DateTimeFormatter dftOut = DateTimeFormat.forPattern("H:mm:ss");
        String result = dftOut.print(dt);
        return result;
    }
}
