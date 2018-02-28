package org.fasttrackit.search;

import org.fasttrackit.webviews.Header;
import org.fasttrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest {


    @Test
    public void SimpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium driver\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        String keyword = "vase";

        Header header = PageFactory.initElements(driver,Header.class);

        header.getSearchField().sendKeys("vase" + Keys.ENTER);

        ProductsGrid productsGrid = PageFactory.initElements(driver,ProductsGrid.class);

        System.out.println("Stored" + productsGrid.getProductNameContainers().size() + "product names from search results");

        for (WebElement productName : productsGrid.getProductNameContainers()) {

            assertThat("Some of the product names do not contain the searched keyword.",
                    productName.getText(), containsString(keyword.toUpperCase()));

        }
    }

    @Test
    public void specialPriceDisplayAfterSimpleSearch() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        String keyword = "vase";

                driver.findElement(By.id("search")).sendKeys(keyword + Keys.ENTER);

        System.out.println("Pressed Enter in search field.");

        driver.findElement(By.xpath("//p[@class='old-price']//span[@class='price']")).getText();

        String oldPrice = driver.findElement(By.xpath("//p[@class='old-price']//span[@class='price']")).getText();
        String specialPrice = driver.findElement(By.xpath("//p[@class='special-price']//span[@class='price']")).getText();




    }
}