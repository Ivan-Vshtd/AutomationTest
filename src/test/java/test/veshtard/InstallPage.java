package test.veshtard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

class InstallPage {

    private WebDriver driver;
    @FindBy(css = "#about_install_steam_link > span")
    private WebElement install;
    private String localDownloadPath = System.getProperty("java.io.tmpdir");

    void install() throws InterruptedException
    {
        install.click();
        Thread.sleep(1000);
    }

    void Btnclk() throws AWTException, InterruptedException
    {
        Robot buttonclicker = new Robot();
        buttonclicker.keyPress(KeyEvent.VK_TAB);
        buttonclicker.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        buttonclicker.keyPress(KeyEvent.VK_ENTER);
        buttonclicker.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(8000);
    }

    void Downloaded() throws InterruptedException
    {
        File file = new File(localDownloadPath + "SteamSetup.exe");
        if (file.exists()) {
            while (!file.canRead())
            {
                Thread.sleep(100);
            }
        }
    }

    InstallPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
