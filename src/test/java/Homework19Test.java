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
        deletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedDeletedPlaylistMessage);
    }



}
