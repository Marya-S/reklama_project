package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdPage extends BasicPage {
    public AdPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@id=\"favorites-link\"]")
    private WebElement favouriteButton;

    public void pushFavouriteButton(){
        favouriteButton.click();
    }
}
