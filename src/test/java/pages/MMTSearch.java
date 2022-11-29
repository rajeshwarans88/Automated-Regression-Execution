package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTSearch extends Hooks{


    public By toCity = By.id("toCity");
    public By toCityInputField = By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open");
    public By firstListItem = By.id("react-autowhatever-1-section-0-item-0");
    public By searchButton = By.cssSelector(".primaryBtn");
    public By langPopUpClose = By.className("langCardClose");

    public void searchFlightsAfterSelectingDestination(String from, String to) throws InterruptedException {
        handleLanguagePopUp();
        if(from!=null){
            System.out.println("Place holder condition");
        }
        else if(to!=null){
            driver.findElement(toCity).click();
            driver.findElement(toCityInputField).sendKeys(to);
            Thread.sleep(1000);

            //clicking the first item in the list
            driver.findElement(firstListItem).click();
        }

        //click on search button
        driver.findElement(searchButton).click();
    }

    public void handleLanguagePopUp(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(langPopUpClose)));
        if(driver.findElement(langPopUpClose).isDisplayed())
            driver.findElement(langPopUpClose).click();
    }


}
