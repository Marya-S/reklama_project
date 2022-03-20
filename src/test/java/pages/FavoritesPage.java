package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritesPage extends BasicPage {
    public FavoritesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id=\"icon_view\"]//td[@class=\"img\"]/a")
    private WebElement adLink;

    @FindBy(xpath = "//input[@value=\"Очистить список\"]")
    private WebElement clearListButton;

    public String returnUrlAd(){
       return adLink.getAttribute("href");
    }

    public void clearFavouriteList(){
        clearListButton.click();

    }
}
