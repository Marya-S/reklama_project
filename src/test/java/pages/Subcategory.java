package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Subcategory extends BasicPage {
    public Subcategory(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(tagName = "h2")
    private List<WebElement> subcategoryList;

    public void chooseFirstSubcategory(){
        subcategoryList.get(0).click();
    }


}
