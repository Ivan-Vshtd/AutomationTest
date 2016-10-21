package test.veshtard;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class MainPage {

    private WebDriver driver;
    @FindBy(className = "pulldown_desktop")
    private WebElement pulldownDesktop;
    @FindBy(id = "language_pulldown")
    private WebElement languagePulldown;
    @FindBy(linkText = "English (английский)")
    private WebElement english;
    @FindBy(linkText = "Games")
    private WebElement games;
    @FindBy(xpath = "(//a[contains(text(),'Action')])[2]")
    private WebElement action;

    MainPage setLanguagePulldown() {
        if ("Игры".equals(pulldownDesktop.getText()))
        {
            languagePulldown.click();
            english.click();
        }
        return this;
    }

    void goToDiscountPage()
    {
        action.click();
    }

    void actionMove()
    {
        Actions action = new Actions(driver);

        WebElement elem = games;
        action.moveToElement(elem);
        action.perform();
    }

    MainPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
