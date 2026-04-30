package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.Data;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class SearchTest extends BaseTest {

    // ✅ Logger
    Logger log = LogManager.getLogger(SearchTest.class);

    SearchPage sp;

    // 🔥 DATA DRIVEN TEST
    @Test(dataProvider = "searchData", dataProviderClass = Data.class)
    public void testSearch(String keyword) {

        log.info("Browser opened");
        log.info("Test Started with keyword: " + keyword);

        sp = new SearchPage(driver);

        sp.search(keyword);
        log.info("Search done");

        // Verify URL contains search
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));

        // Better validation
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(keyword.toLowerCase()));

        log.info("Test passed");
    }

    // 🔹 Title check
    @Test
    public void testTitle() {

        log.info("Test Started - Title check");

        Assert.assertTrue(driver.getTitle().contains("Google"));

        log.info("Title verified - Test passed");
    }

    // 🔹 Back navigation
    @Test
    public void testBackNavigation() {

        log.info("Test Started - Back navigation");

        driver.navigate().to("https://www.google.com/search?q=phone");
        driver.navigate().back();

        Assert.assertTrue(driver.getTitle().contains("Google"));

        log.info("Back navigation successful - Test passed");
    }

    // 🔹 Page load time
    @Test
    public void testPageLoadTime() {

        log.info("Test Started - Page load time");

        long start = System.currentTimeMillis();
        driver.navigate().refresh();
        long end = System.currentTimeMillis();

        Assert.assertTrue((end - start) < 5000);

        log.info("Page loaded within time - Test passed");
    }

    // 🔹 Search box visible
    @Test
    public void testSearchBoxVisible() {

        log.info("Test Started - Search box visibility");

        Assert.assertTrue(driver.findElement(
                org.openqa.selenium.By.name("q")).isDisplayed());

        log.info("Search box is visible - Test passed");
    }

    // 🔹 Search box enabled (INTENTIONAL FAIL)
    @Test
    public void testSearchBoxEnabled() {

        log.info("Test Started - Search box enabled check");

        Assert.assertFalse(driver.findElement(
                org.openqa.selenium.By.name("q")).isEnabled());

        log.info("Search box disabled - Expected (Test will fail)");
    }
}