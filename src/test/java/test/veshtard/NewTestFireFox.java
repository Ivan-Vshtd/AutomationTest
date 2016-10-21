package test.veshtard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;


public class NewTestFireFox {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception
    {
        driver = new FirefoxDriver();
        baseUrl = "http://store.steampowered.com/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception
    {
        driver.get(baseUrl + "/");

        MainPage mainPage = new MainPage(driver);
        DiscountPage discountPage = new DiscountPage(driver);
        AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver);
        AssertPage assertPage = new AssertPage(driver);
        InstallPage installPage = new InstallPage(driver);


        mainPage.setLanguagePulldown();
        mainPage.actionMove();
        mainPage.goToDiscountPage();
        discountPage.clickDiscounts();
        discountPage.findbestDiscount();

        if (ageVerificationPage.isAgeVerify())
            ageVerificationPage.AgeVerification();

        assertPage.Assert(discountPage);
        installPage.install();
        installPage.Btnclk();
        installPage.Downloaded();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception
    {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }

}