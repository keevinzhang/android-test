import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.PageHelper;

public class SubjectsPage extends PageHelper {
    By detectiveNovel = AppiumBy.androidUIAutomator("new UiSelector().text(\"Deckare\")");
    By novel = AppiumBy.androidUIAutomator("new UiSelector().text(\"Romaner\")");
    By fiction = AppiumBy.androidUIAutomator("new UiSelector().text(\"Skönlitteratur\")");
    By biographies = AppiumBy.androidUIAutomator("new UiSelector().text(\"Biografier\")");
    By childrenAndYoungAdult = AppiumBy.androidUIAutomator("new UiSelector().text(\"Barn & unga vuxna\")");
    By familyAndHealth = AppiumBy.androidUIAutomator("new UiSelector().text(\"Familj & hälsa\")");
    By societyAndPolitics = AppiumBy.androidUIAutomator("new UiSelector().text(\"Samhälle & politik\")");
    By personalDevelop = AppiumBy.androidUIAutomator("new UiSelector().text(\"Personlig utveckling\")");
    By romance = AppiumBy.androidUIAutomator("new UiSelector().text(\"Romantik\")");
    By history = AppiumBy.androidUIAutomator("new UiSelector().text(\"Historia\")");
    By philosophyOfLife = AppiumBy.androidUIAutomator("new UiSelector().text(\"Livsåskådning\")");
    By sport_freeTime_hobby = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Sport,\")");
    By classics = AppiumBy.androidUIAutomator("new UiSelector().text(\"Klassiker\")");
    By economy_leadership = AppiumBy.androidUIAutomator("new UiSelector().text(\"Ekonomi & ledarskap\")");
    By sciFiAndFantasy = AppiumBy.androidUIAutomator("new UiSelector().text(\"Sci-fi & fantasy\")");
    By homeAndGarden = AppiumBy.androidUIAutomator("new UiSelector().text(\"Hem & trädgård\")");
    By language = AppiumBy.androidUIAutomator("new UiSelector().text(\"Språk\")");

    public SubjectsPage (AndroidDriver driver) { super(driver); }

    public void clickDetectiveNovel() {
        driver.findElement(detectiveNovel).click();
        Assert.assertTrue(waitForElementToAppear(detectiveNovel).getText().equals("Deckare"));
    }

    public void clickNovel() {
        driver.findElement(novel).click();
        Assert.assertTrue(waitForElementToAppear(novel).getText().equals("Romaner"));
    }

    public void clickFiction() {
        driver.findElement(fiction).click();
        Assert.assertTrue(waitForElementToAppear(fiction).getText().equals("Skönlitteratur"));
    }

    public void clickBiographies() {
        driver.findElement(biographies).click();
        Assert.assertTrue(waitForElementToAppear(biographies).getText().equals("Biografier"));
    }

    public void clickChildrenAndYoungAdult() {
        scrollToText("Barn & unga vuxna").click();
        Assert.assertTrue(waitForElementToAppear(childrenAndYoungAdult).getText().equals("Barn & unga vuxna"));
    }

    public void clickFamilyAndHealth() {
        scrollToText("Familj & hälsa").click();
        Assert.assertTrue(waitForElementToAppear(familyAndHealth).getText().equals("Familj & hälsa"));
    }

    public void clickSocietyAndPolitics() {
        scrollToText("Samhälle & politik").click();
        Assert.assertTrue(waitForElementToAppear(societyAndPolitics).getText().equals("Samhälle & politik"));
    }

    public void clickPersonalDevelopment() {
        scrollToText("Personlig utveckling").click();
        Assert.assertTrue(waitForElementToAppear(personalDevelop).getText().equals("Personlig utveckling"));
    }

    public void clickRomance() {
        scrollToText("Romantik").click();
        Assert.assertTrue(waitForElementToAppear(romance).getText().equals("Romantik"));
    }

    public void clickHistory() {
        scrollToText("Historia").click();
        Assert.assertTrue(waitForElementToAppear(history).getText().equals("Historia"));
    }

    public void clickPhilosophyOfLife() {
        scrollToText("Livsåskådning").click();
        Assert.assertTrue(waitForElementToAppear(philosophyOfLife).getText().equals("Livsåskådning"));
    }

    public void clickSportAndFreeTimeAndHobby() {
        scrollToText("Sport, fritid & hobby").click();
        Assert.assertTrue(waitForElementToAppear(sport_freeTime_hobby).getText().equals("Sport, fritid & hobby"));
    }

    public void clickClassics() {
        scrollToText("Klassiker").click();
        Assert.assertTrue(waitForElementToAppear(classics).getText().equals("Klassiker"));
    }

    public void clickEconomyAndLeadership() {
        scrollToText("Ekonomi & ledarskap").click();
        Assert.assertTrue(waitForElementToAppear(economy_leadership).getText().equals("Ekonomi & ledarskap"));
    }

    public void clickSciFiAndFantasy() {
        scrollToText("Sci-fi & fantasy").click();
        Assert.assertTrue(waitForElementToAppear(sciFiAndFantasy).getText().equals("Sci-fi & fantasy"));
    }

    public void clickHomeAndGarden() {
        scrollToText("Hem & trädgård").click();
        Assert.assertTrue(waitForElementToAppear(homeAndGarden).getText().equals("Hem & trädgård"));
    }

    public void clickLanguage() {
        scrollToText("Språk").click();
        Assert.assertTrue(waitForElementToAppear(language).getText().equals("Språk"));
    }
}
