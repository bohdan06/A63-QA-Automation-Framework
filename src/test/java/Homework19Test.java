import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletedPlaylistMessage = "Deleted playlist \"Playlist1.\"";
        provideEmail("bohdan.ivasiv@testpro.io");
        providePassword("TkSDMvReT57X$ym");
        submitBtn();
        findPlaylist();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedDeletedPlaylistMessage);
    }
    public void findPlaylist() throws InterruptedException {
        WebElement playlistName = driver.findElement(By.xpath("//section[@id = 'playlists'] //a[contains(text(), 'Playlist1')]"));
        playlistName.click();
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("button.del"));
        deletePlaylistBtn.click();
        Thread.sleep(2000);
    }
    public String getDeletedPlaylistMsg(){
        WebElement deleteMsg = driver.findElement(By.cssSelector("div.success.show"));
        return deleteMsg.getText();
    }
}
