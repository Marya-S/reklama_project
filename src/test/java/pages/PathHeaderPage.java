package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PathHeaderPage extends BasicPage{
    public PathHeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "favorites-link")
    private WebElement favorite;

    public void pushFavoriteButton(){
        favorite.click();
    }


}
