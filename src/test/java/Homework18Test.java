import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideValidEmail("bohdan.ivasiv@testpro.io");
        provideValidPassword("TkSDMvReT57X$ym");
        submitBtn();
        Thread.sleep(2000);
        playNextSongBtn();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("span.pause")).isDisplayed());

    }
    public void playNextSongBtn() throws InterruptedException {
        WebElement nextSong = driver.findElement(By.cssSelector("i.next"));
        nextSong.click();
        Thread.sleep(2000);
        WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
        playBtn.click();
        Thread.sleep(2000);


    }









}
