

import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest {

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


}
