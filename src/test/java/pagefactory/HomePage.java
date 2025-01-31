package pagefactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    @FindBy (css = "img.avatar" )
    WebElement avatarIcon;
    @FindBy (css = " i[data-testid=\"sidebar-create-playlist-btn\"]")
    WebElement plus;
    @FindBy (xpath ="//nav //li[@data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylist;
    @FindBy (css = "input[name='name']")
    WebElement newNameForPlaylist;
    @FindBy(css = "div.success.show")
    WebElement createdPlaylistMsg;
    @FindBy (xpath = "//section[@id = 'playlists'] //a[contains(text(), 'Relax mix')]")
    WebElement playlistName;
    @FindBy(css = "div.success.show")
    WebElement deleteMsg;
    @FindBy (css = "input[type='search']")
    WebElement searchField;
    @FindBy(css = "[data-testid='play-btn']")
    WebElement play;
    @FindBy(css = "i.next")
    WebElement nextSong;
    @FindBy(css = "span.play")
    WebElement playBtn;
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement menuCreateSimple;
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAllBtn;
    @FindBy(css = "form.create input[name='name']")
    public WebElement nameField;
    @FindBy (css = "a.songs")
    WebElement allSongs;
    @FindBy (xpath ="//nav //li[@data-testid='playlist-context-menu-create-smart']")
    WebElement newSmartPlaylist;
    @FindBy(css = "div.form-row input[name='name']")
    WebElement fieldNameForSmartPlaylist;
    @FindBy(css = "select[name=\"model[]\"]")
    WebElement firstCriteria;
    @FindBy(xpath = "//select[@name=\"model[]\"] //option[contains(text(), 'Title')]")
    WebElement titleOption;
    @FindBy(xpath = "//select[@name=\"operator[]\"] ")
    WebElement secondCriteria;
    @FindBy(xpath = "//select[@name=\"operator[]\"] //option[contains(text(), 'is')][1]")
    WebElement isOption;
    @FindBy(css = "input[name='value[]']")
    WebElement thirdCriteria;
    @FindBy(xpath = "//footer //button[@type='submit']")
    WebElement saveSmartPlaylistBtn;
    @FindBy(css = "button.btn-add-rule")
    WebElement addRuleBtn;
    @FindBy(xpath = " //div[@class='form-row rules'] //div[@class='row'][2] //select[@name='model[]']")
    WebElement secondRuleFirstCriteria;
    @FindBy(xpath = " //div[@class='form-row rules'] //div[@class='row'][2] //select[@name='model[]'] //option[contains(text(), 'Title')]")
    WebElement titleOptionForSecondRule;
    @FindBy(xpath = " //div[@class='form-row rules'] //div[@class='row'][2] //select[@name='operator[]']")
    WebElement secondRuleSecondCriteria;
    @FindBy(xpath = " //div[@class='form-row rules'] //div[@class='row'][2] //select[@name='operator[]'] //option[contains(text(), 'contains')]")
    WebElement containsOptionForSecondRule;
    @FindBy(xpath = " //div[@class='form-row rules'] //div[@class='row'][2] //input[@name='value[]']")
    WebElement thirdCriteriaForSecondRule;
    @FindBy(css = "button.btn-add-group")
    WebElement addGroupBtn;
    @FindBy(css = ".smart-playlist-form .rule-group:nth-of-type(2) select[name='model[]']")
    WebElement firstCriteriaForGroup;
    @FindBy(xpath = "(//div[@class='smart-playlist-form']//div[@class='rule-group'])[2]//select[@name='model[]']//option[contains(text(), 'Title')]")
    WebElement titleOptionForGroup;
    @FindBy(css = ".smart-playlist-form .rule-group:nth-of-type(2) select[name='operator[]']")
    WebElement secondCriteriaForGroup;
    @FindBy(xpath = "(//div[@class='form-row rules']//div[@class='row'])[2]//select[@name='operator[]'] //option[contains(text(), 'is')][1]")
    WebElement isOptionForGroup;
    @FindBy(xpath = "(//div[@class='form-row rules'] //div[@class='row'])[2]//input[@name='value[]']")
    WebElement thirdCriteriaForGroup;
    @FindBy (xpath = "//section[@id='playlists'] //li[@class='playlist playlist smart'][1]")
    WebElement smartPlaylistName;



    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getAvatarIcon(){
        return avatarIcon;
    }
    public HomePage plusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plus));
        plus.click();
        try{
            wait.until(ExpectedConditions.elementToBeClickable(menuCreateSimple));
        }catch(TimeoutException e){
            plus.click();
            wait.until(ExpectedConditions.elementToBeClickable(menuCreateSimple));
        }
        return this;
    }
    public HomePage newPlaylistNameBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist));
        newPlaylist.click();
        return this;
    }
    public HomePage newPlaylistName(String name)  {
        newNameForPlaylist.sendKeys(name);
        newNameForPlaylist.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage nameFieldForPlaylist(){
            wait.until(ExpectedConditions.visibilityOf(nameField));
            return this;
    }
    public String getCreatedPlaylistMsg() {
        return wait.until(ExpectedConditions.visibilityOf(createdPlaylistMsg)).getText();
    }

    public HomePage findPlaylist(){
        playlistName.click();
        return this;
    }
    public Boolean isDeleteMsg (){
        try{
            wait.until(ExpectedConditions.visibilityOf(deleteMsg));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getDeletePlaylistMsg(){
        return wait.until(ExpectedConditions.visibilityOf(deleteMsg)).getText();

    }
    public HomePage searchSong(String songName){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn));
        }catch(TimeoutException e) {
            searchField.sendKeys(songName);
            wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn));
        }
        return this;
    }
    public HomePage playNextSongBtn(){
        actions.moveToElement(play).perform();
        nextSong.click();
        return this;
    }
    public HomePage playButton(){
        playBtn.click();
        return this;
    }
    public HomePage allSongsSection(){
        wait.until(ExpectedConditions.elementToBeClickable(allSongs)).click();
        return this;
    }
    public HomePage smartPlaylist(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(plus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(newSmartPlaylist)).click();
        wait.until(ExpectedConditions.visibilityOf(fieldNameForSmartPlaylist)).sendKeys(name);
        return this;
    }
    public HomePage firstRuleForSmartPlaylist(String value){
        wait.until(ExpectedConditions.elementToBeClickable(firstCriteria)).click();
        wait.until(ExpectedConditions.visibilityOf(titleOption)).click();
        wait.until(ExpectedConditions.visibilityOf(secondCriteria)).click();
        wait.until(ExpectedConditions.visibilityOf(isOption)).click();
        wait.until(ExpectedConditions.visibilityOf(thirdCriteria)).sendKeys(value);
        return this;
    }
    public HomePage saveForNewSmartPlaylistBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(saveSmartPlaylistBtn)).click();
        return this;
    }
    public HomePage addRuleButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addRuleBtn)).click();
        return this;
    }
    public HomePage secondRuleForSmartPlaylist(String valueForSecondRule){
        wait.until(ExpectedConditions.elementToBeClickable(secondRuleFirstCriteria)).click();
        wait.until(ExpectedConditions.visibilityOf(titleOptionForSecondRule)).click();
        wait.until(ExpectedConditions.visibilityOf(secondRuleSecondCriteria)).click();
        wait.until(ExpectedConditions.visibilityOf(containsOptionForSecondRule)).click();
        wait.until(ExpectedConditions.visibilityOf(thirdCriteriaForSecondRule)).sendKeys(valueForSecondRule);
        return this;
    }
    public HomePage groupForSmartPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(addGroupBtn)).click();
        return this;
    }
    public HomePage groupWithRuleForSmartPlaylist(String valueForGroup){
        wait.until(ExpectedConditions.elementToBeClickable(firstCriteriaForGroup)).click();
        wait.until(ExpectedConditions.visibilityOf(titleOptionForGroup)).click();
        wait.until(ExpectedConditions.visibilityOf(secondCriteriaForGroup)).click();
        wait.until(ExpectedConditions.visibilityOf(isOptionForGroup)).click();
        wait.until(ExpectedConditions.visibilityOf(thirdCriteriaForGroup)).sendKeys(valueForGroup);
        return this;
    }
    public boolean isNameFieldForSmartPlaylistDisplayed(){
        return fieldNameForSmartPlaylist.isDisplayed();
    }
    public HomePage findSmartPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(smartPlaylistName)).click();
        return this;
    }






}