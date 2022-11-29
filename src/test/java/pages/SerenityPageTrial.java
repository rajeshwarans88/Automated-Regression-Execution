package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class SerenityPageTrial extends PageObject {
    private WebDriver localDriver;

    public SerenityPageTrial(WebDriver driver){
        super(driver);
        localDriver = getDriver();
        System.out.println("I am here!!!!");
    }

    public void isDriverInit(){
        System.out.println(localDriver);
    }
}
