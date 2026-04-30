package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    // constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // locator
    By searchBox = By.name("q");

    // actions
    public void enterSearch(String value) {
        driver.findElement(searchBox).sendKeys(value);
    }

    public void clickSearch() {
        driver.findElement(searchBox).submit();
    }

    // ⭐ THIS FIXED METHOD (your error solution)
    public void search(String value) {
        enterSearch(value);
        clickSearch();
    }
}