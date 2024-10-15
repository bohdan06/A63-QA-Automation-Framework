import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18Test extends BaseTest {
    @Test
    public void playSong()  {
        navigateToPage();
        provideEmail("bohdan.ivasiv@testpro.io");
        providePassword("TkSDMvReT57X$ym");
        submitBtn();
        playNextSongBtn();
        Assert.assertTrue(driver.findElement(By.cssSelector("span.pause")).isDisplayed());

    }

}
