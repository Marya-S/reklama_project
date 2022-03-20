package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdListPage extends BasicPage {
    public AdListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//em[@class='view1']/..")
    private WebElement cardView;

    @FindBy(xpath = "//em[@class='view2']/..")
    private WebElement textView;

    @FindBy(xpath = "//em[@class='view3']/..")
    private WebElement tableView;

    @FindBy(css = "ul.table_ver2 li")
    private List<WebElement> cardAdList;

    @FindBy(xpath = "//*[@id=\"icon_view\"]//tr")
    private List<WebElement> textAdList;

    @FindBy(xpath = "//div[@id=\"details_view\"]//tbody/tr")
    private List<WebElement> tableAdList;

    public void pushCardView() {
        cardView.click();
    }

    public void pushTextView() {
        textView.click();
    }

    public void pushTableView() {
        tableView.click();
    }

    public void chooseFirstElement(String viewType) {
        switch (viewType) {
            case "cardView":
                cardAdList.get(0).click();
                break;
            case "textView":
                textAdList.get(0).click();
                break;
            case "tableView":
                tableAdList.get(0).click();
                break;
            default:
                System.out.println("choose type view");
                break;
        }
    }

    public String saveAdUrl(){
       return driver.getCurrentUrl();
    }

    public void addFirstToFavourite(String viewType){
        switch (viewType) {
            case "cardView":
                moveToElement(cardAdList.get(0));
                cardAdList.get(0).findElement(By.cssSelector("div.info a.fav-add")).click();
                break;
            case "textView":
                moveToElement(textAdList.get(0));
                textAdList.get(0).findElement(By.xpath("//div[@class=\"info\"]/a[@class=\"fav-add\"]")).click();
                break;
            case "tableView":
                moveToElement(tableAdList.get(0));
                moveAndClickToElement(tableAdList.get(0).findElement(By.xpath("//div[@class=\"info\"]")));
                break;
            default:
                System.out.println("choose type view");
                break;
        }
    }

    public String returnUrlFirstAd(String viewType){
        String url = new String();
        switch (viewType) {
            case "cardView":
                url = cardAdList.get(0).findElement(By.cssSelector("a[target=\"_blank\"]")).getAttribute("href");
                break;
            case "textView":
                url = textAdList.get(0).findElement(By.xpath("//a[@target=\"_blank\"]")).getAttribute("href");
                break;
            case "tableView":
                url = tableAdList.get(0).findElement(By.xpath("//a[@target=\"_blank\"]")).getAttribute("href");
                break;
            default:
                System.out.println("choose type view");
                break;
        }
        return url;
    }
}
