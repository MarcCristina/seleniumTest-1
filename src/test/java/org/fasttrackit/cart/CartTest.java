package org.fasttrackit.cart;

import org.fasttrackit.TestBase;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest extends TestBase{


    @Test
    public void addProductToCart() {

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()" + " = 'Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();

        WebElement successMessageContainer = driver.findElement(By.cssSelector (".success-msg"));
        assertThat("Product not added to cart.", successMessageContainer.getText(), containsString("Herald Glass Vase"));

// todo: assert that product is present in cart
    }



}
