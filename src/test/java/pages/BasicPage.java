package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicPage {
   public WebDriver driver;
    public void scrollPageDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    public void returnBack(){
        driver.navigate().back();
    }

    public void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public void moveAndClickToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        builder.moveToElement(element).click().perform();
        System.out.println("test");
    }

    /*Плохое решение, но не смогла подобрать вариант как кликнуть на исчезающий элемент*/
    public void clickOnInvisibleElement(WebElement element) {
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);";
        ((JavascriptExecutor)driver).executeScript(script, element);
    }

}
