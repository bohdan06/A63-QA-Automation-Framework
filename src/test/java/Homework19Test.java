import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist()  {
        String expectedDeletedPlaylistMessage = "Deleted playlist \"Playlist1.\"";
        provideEmail("bohdan.ivasiv@testpro.io");
        providePassword("TkSDMvReT57X$ym");
        submitBtn();
        findPlaylist();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedDeletedPlaylistMessage);
    }
    public void findPlaylist() {
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id = 'playlists'] //a[contains(text(), 'Playlist1')]")));
        playlistName.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del")));
        deletePlaylistBtn.click();
    }
    public String getDeletedPlaylistMsg(){
        WebElement deleteMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deleteMsg.getText();
    }
}
