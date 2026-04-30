package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.name("q");

    public void searchProduct(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }
}