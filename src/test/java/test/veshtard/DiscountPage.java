package test.veshtard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

class DiscountPage {
    private WebDriver driver;
    @FindBy(css = "#tab_select_Discounts > div.tab_content")
    private WebElement discounts;
    @FindBy(className = "discount_pct")
    private List<WebElement> discountpct;
    private int min;

    void clickDiscounts()
    {
        discounts.click();
    }

    void findbestDiscount()
    {
        List<WebElement> discount = discountpct;
        int minimum = 0;
        WebElement bestdiscount = null;
        for (int i = 0; i < discount.size(); i++)
        {
            WebElement disc = discount.get(i);
            String s = disc.getText();
            if (s.length() > 0)
            {
                int tempdisc = Integer.parseInt(s.replace("%", ""));
                if (tempdisc < minimum)
                {
                    minimum = tempdisc;
                    bestdiscount = disc;
                }
            }

        }
        System.out.println(minimum + "%  is the best discount");
        if (bestdiscount != null)
        {
            bestdiscount.click();
        } else
        {
            System.out.println("Чет пусто тут");
        }
        setMin(minimum);
    }


    private void setMin(int min)
    {
        this.min = min;

    }

    int getMin()
    {
        return min;
    }

    DiscountPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
