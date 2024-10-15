import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest {
    String newPlaylistName = "Playlist Test Changed3";
    @Test
    public void renamePlaylist(){
        String updatedPlaylistName = "Updated playlist \"Playlist Test Changed3.\"";
        provideEmail("bohdan.ivasiv@testpro.io");
        providePassword("TkSDMvReT57X$ym");
        submitBtn();
        doubleClickOnPlaylist();
        newNameForPlaylist();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistName);
    }
    public void doubleClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();

    }
    public void newNameForPlaylist (){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);


    }
    public String getRenamePlaylistSuccessMsg (){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


}
