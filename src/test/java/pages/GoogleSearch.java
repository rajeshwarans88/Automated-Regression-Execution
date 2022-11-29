package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.bind.SchemaOutputResolver;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class GoogleSearch extends Hooks{

    public void searchUrl(String url) throws InterruptedException {

        //Navigate to google and give the search term
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(url);
        searchField.submit();
        Thread.sleep(1000);
    }

    public String clickUrl(String urlContains) throws InterruptedException {

        //Click on the url with given href and return the title of the page
        driver.findElement(By.cssSelector("a[href*='"+urlContains+"']")).click();
        Thread.sleep(1000);
        return driver.getTitle();
    }

    public void getTitlesPreceedingBookNow(){

/*      List<WebElement> bookNowElements = driver.findElements(By.linkText("BOOK NOW"));
        System.out.println(bookNowElements.size());
        for (WebElement w:bookNowElements) {
            System.out.println(w.getText());
        }*/

        //Not completed
        List<WebElement> bookNowElements1 = driver.findElements(By.xpath("//a[contains(text(),\"BOOK NOW\")]/preceding-sibling::div[@class='itemDesc']/p"));
        System.out.println(bookNowElements1.size());
        for (WebElement w:bookNowElements1) {
            if(w.isDisplayed())
                System.out.println(w.getText());
        }
    }

    public void searchByImage() throws InterruptedException, AWTException {
        driver.get("https://www.google.com/imghp?hl=en");
        driver.manage().window().maximize();
        driver.findElement(By.className("Gdd5U")).click();
        driver.findElement(By.className("DV7the")).click();
        Thread.sleep(1000);

        Robot robot = new Robot();

        // copying File path to Clipboard
        String currentOS = System.getProperty("os.name");

        //Windows we simply paste the file path
        if(currentOS.contains("Windows")) {
            StringSelection filePath = new StringSelection("C:\\Users\\Rajeshwaran_Sarangar\\Pictures\\bday.jpg");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(10000);
        }

        //In Mac os we need to use the Go to option
        if(currentOS.contains("Mac")) {

            File file = new File("/Users/rajeshwaransarangarajan/Downloads/GoW-R.jpeg");
            StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(5000);

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);
            robot.delay(5000);

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(5000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(10000);
        }

    }

}
