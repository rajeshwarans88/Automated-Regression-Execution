package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableCount extends Hooks{

    public void statusCount() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        Thread.sleep(1000);
        List<WebElement> statusRows = driver.findElements(By.xpath("//*[@id=\"task-table\"]/tbody/tr/td[4]"));
        List<String> allStatusText = new ArrayList<>();
        for (WebElement rowElement : statusRows) {
            allStatusText.add(rowElement.getText());
        }
        List<String> uniqueStatus = allStatusText.stream().distinct().collect(Collectors.toList());
        for (String statusText:uniqueStatus) {
            System.out.println(statusText+" occurs "+allStatusText.stream().filter(s -> s.equalsIgnoreCase(statusText)).count());
        }
    }
}
