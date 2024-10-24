import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchClass(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        navigateToPage();

    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[type='email']"))));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void submitBtn() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    public void searchSong(String songName)  {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[type='search']"))));
        searchField.sendKeys(songName);

    }
    public void clickViewAllBtn()  {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button[data-test='view-all-songs-btn']"))));
        viewAllBtn.click();
    }
    public void selectSong()  {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//section[@id='songResultsWrapper'] //tr[@class='song-item'][1]"))));
        firstSong.click();
    }
    public void clickAddToButton() {
        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button.btn-add-to"))));
        addToButton.click();

    }
    public void choosePlaylist()  {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Playlist1')]"))));
        playlist.click();

    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
    public void playNextSongBtn()  {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        WebElement nextSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.next")));
        nextSong.click();
        WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("span.play"))));
        playBtn.click();

    }
    public void findPlaylist() {
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id = 'playlists'] //a[contains(text(), 'Playlist1')]")));
        playlistName.click();
    }
    public void deletePlaylistBtn() {
        WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del")));
        delete.click();
    }
    public String getDeletedPlaylistMsg(){
        WebElement deleteMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deleteMsg.getText();
    }
    public void doubleClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();

    }
    public void newNameForPlaylist (){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Playlist Test Changed3");
        playlistInputField.sendKeys(Keys.ENTER);


    }
    public String getRenamePlaylistSuccessMsg (){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}