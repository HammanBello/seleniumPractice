package com.zenity.intranet;

import com.zenity.intranet.config.SystemPropertiesReader;
import com.zenity.intranet.driver.DriverFactory;
import com.zenity.intranet.driver.WebDriverManager;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@CucumberOptions(
        features = {"./src/test/resources/features/ShortPasswdReset.feature"},
        glue = {"com.zenity.intranet.steps", "com/zenity/intranet/pageObjects"},
        monochrome = true,
        plugin = {
                "pretty",
                "json:target/cucumber-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    private static final SystemPropertiesReader SYSTEM_PROPERTIES = SystemPropertiesReader.getInstance();

    @BeforeClass
    public static void beforeTest() {
        WebDriverManager.setDriver(SYSTEM_PROPERTIES.browser);
        driver = WebDriverManager.getDriver();
    }

    @AfterClass
    public static void afterTest() {
        WebDriverManager.getDriver().quit();
    }
}

