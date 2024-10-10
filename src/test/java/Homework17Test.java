import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist()  {
        String expectedSongAddedMessage = "Added 1 song into \"Playlist1.\"";
        navigateToPage();
        provideEmail("bohdan.ivasiv@testpro.io");
        providePassword("TkSDMvReT57X$ym");
        submitBtn();
        searchSong("Lament");
        clickViewAllBtn();
        selectSong();
        clickAddToButton();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);



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

}
