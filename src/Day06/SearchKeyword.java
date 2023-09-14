package Day06;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchKeyword extends BaseDriver {
    @Test
    @Parameters ({"keyword","username","password"})
    public void searchKeyword(String keyword, String username, String password){
        login(username,password);

        WebElement searchInbox = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchInbox.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> results = driver.findElements(By.cssSelector("div[class='caption'] a"));

        for (WebElement r : results){
            Assert.assertTrue(r.getText().toLowerCase().contains(keyword));
        }

    }
}
