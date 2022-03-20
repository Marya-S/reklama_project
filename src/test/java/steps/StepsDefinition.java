package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.WebDriverFactory;
import utils.driverType;

import static org.junit.Assert.assertTrue;

public class StepsDefinition {
    WebDriver driver;
    String url;

    @Given("Open start page {string}")
    public void openStartPage(String url) {
        driver = WebDriverFactory.create(driverType.chrome, "start-maximized");
        driver.get(url);
    }

    @And("choose a {string} category")
    public void chooseCategory(String category) {
        MainPage mainPage = new MainPage(driver);
        Subcategory subcategory = new Subcategory(driver);
        mainPage.chooseCategory(category);
        if (driver.getCurrentUrl().endsWith("/menus.html")) {
            subcategory.chooseFirstSubcategory();
        }
        assertTrue("The page with ads is open",
                driver.getCurrentUrl().endsWith("/table.html"));
    }

    @And("choose view type {string}")
    public void pushViewType(String viewType) {
        AdListPage adListPage = new AdListPage(driver);
        switch (viewType) {
            case "cardView":
                adListPage.pushCardView();
                break;
            case "textView":
                adListPage.pushTextView();
                break;
            case "tableView":
                adListPage.pushTableView();
                break;
            default:
                System.out.println("choose type view");
                break;
        }
    }

    @Then("open first ad in view {string}")
    public void chooseFirstAdAndOpen(String viewType) {
        AdListPage adListPage = new AdListPage(driver);
        adListPage.chooseFirstElement(viewType);
        url = adListPage.saveAdUrl();
    }

    @And("scroll page down")
    public void scrollPageDown() {
        AdPage adPages = new AdPage(driver);
        adPages.scrollPageDown();
    }

    @Then ("choose first ad in view {string} and click to favourite button")
    public void chooseAdAndAddToFavourite(String viewType){
        AdListPage adListPage = new AdListPage(driver);
        url = adListPage.returnUrlFirstAd(viewType);
        adListPage.addFirstToFavourite(viewType);

    }

    @When("Click on the 'add to favorites' button")
    public void pushFavoritesButton() {
        AdPage adPages = new AdPage(driver);
        adPages.pushFavouriteButton();
    }

    @Then("clear the favourite list")
    public void clearFavouriteList() {
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        favoritesPage.clearFavouriteList();
    }

    @And("open favorites page")
    public void openFavoritesPage() {
        PathHeaderPage headerPage = new PathHeaderPage(driver);
        headerPage.pushFavoriteButton();
    }

    @And ("checkFavoritesListIsClear")
    public void checkFavoritesListIsClear() {
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        try{
            openFavoritesPage();
            clearFavouriteList();
            favoritesPage.returnBack();
        }
        catch (ElementNotInteractableException e){
            System.out.println("Favourite list is clear");
        }

    }

    @And("Check that the ad has been added")
    public void checkAdHasAdded() {
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        assertTrue("Ad was not add to favourite list", url.contains(favoritesPage.returnUrlAd()));
    }


}
