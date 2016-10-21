package test.veshtard;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

class AssertPage
{
    private WebDriver driver;
    @FindBy(className = "discount_pct")
    private WebElement discountpct;
    @FindBy(linkText = "Install Steam")
    private WebElement installSteam;

    void Assert(DiscountPage discountPage)
    {
        Assert.assertEquals(discountPage.getMin(), Integer.parseInt((discountpct.getText().replace("%", ""))));
        installSteam.click();
    }


    AssertPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
