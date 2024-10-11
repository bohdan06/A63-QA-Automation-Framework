import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest {
    @Test
    public void renamePlaylist(){
        navigateToPage();
        provideEmail("bohdan.ivasiv@testpro.io");
        providePassword("TkSDMvReT57X$ym");
        submitBtn();
        doubleClickOnPlaylist();
        newNameForPlaylist();
    }
    public void newNameForPlaylist (){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys("PlaylistTest");
        playlistInputField.sendKeys(Keys.ENTER);


    }

    public void doubleClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists'] //a[contains(text(), 'PlaylistNameChanged')]")));
        actions.doubleClick(playlist).perform();

    }
}
