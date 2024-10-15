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

}
