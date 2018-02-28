package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setup (){
        String browser = System.getProperty("browser", "chrome");

        driver = DriverFactory.getDriver(browser);

        driver.get(AppConfig.getSiteUrl());
    }
    @After
    public void teardown(){
        driver.quit();

    }
}
