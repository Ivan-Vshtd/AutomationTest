package test.veshtard;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

class AgeVerificationPage {

    private WebDriver driver;
    @FindBy(name = "ageDay")
    private WebElement ageDay;
    @FindBy(name = "ageMonth")
    private WebElement ageMonth;
    @FindBy(id = "ageYear")
    private WebElement ageYear;
    @FindBy(css = "a.btnv6_blue_hoverfade.btn_small > span")
    private WebElement submit;

    boolean isAgeVerify()
    {
        try
        {
            ageDay.isEnabled();
            return true;
        } catch (NoSuchElementException e)
        {
            return false;
        }
    }

    void AgeVerification()
    {
        new Select(ageDay).selectByVisibleText("18");
        new Select(ageMonth).selectByVisibleText("July");
        new Select(ageYear).selectByVisibleText("1987");
        submit.click();
    }


    AgeVerificationPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
