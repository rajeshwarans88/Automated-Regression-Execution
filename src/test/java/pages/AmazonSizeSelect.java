package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import utils.MarkSessionStatus;

public class AmazonSizeSelect extends Hooks{

    public void searchUrl() throws InterruptedException {
        MarkSessionStatus sessionStatus = new MarkSessionStatus(driver);
        //Navigate to google and give the search term
        driver.get("https://www.amazon.in/Nike-Revolution-Glacier-Blue-Sequoia-Running/dp/B0B2PMQGHT/ref=sr_1_1?crid=2QQI65XZ74EY3&keywords=Nike&qid=1668661739&qu=eyJxc2MiOiIxMC45MiIsInFzYSI6IjEwLjgwIiwicXNwIjoiOC4xNSJ9&sprefix=ni%2Caps%2C325&sr=8-1&th=1");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("native_dropdown_selected_size_name")));
        //Select selectSizeDropDown = new Select(driver.findElement(By.name("dropdown_selected_size_name")));
        Select selectSizeDropDown = new Select(driver.findElement(By.id("native_dropdown_selected_size_name")));
        selectSizeDropDown.selectByVisibleText("6 UK (6.5 US)");
        sessionStatus.markTestStatus("passed", "Product size set to 6 UK");
        Thread.sleep(3000);
        selectSizeDropDown.selectByVisibleText("7 UK (7.5 US)");
        sessionStatus.markTestStatus("passed", "Product size set to 7 UK");
        Thread.sleep(3000);
        selectSizeDropDown.selectByVisibleText("8 UK (8.5 US)");
        sessionStatus.markTestStatus("passed", "Product size set to 8 UK");
        Thread.sleep(3000);
        selectSizeDropDown.selectByIndex(1);
        sessionStatus.markTestStatus("passed", "Product size set to 6 UK");
        Thread.sleep(3000);
        selectSizeDropDown.selectByIndex(2);
        sessionStatus.markTestStatus("passed", "Product size set to 7 UK");
        Thread.sleep(3000);
        selectSizeDropDown.selectByIndex(3);
        sessionStatus.markTestStatus("passed", "Product size set to 8 UK");
        Thread.sleep(3000);
    }
}
