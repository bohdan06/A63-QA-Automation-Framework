import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void playNextSongBtn()  {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        WebElement nextSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.next")));
        nextSong.click();
        WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("span.play"))));
        playBtn.click();

    }
}
