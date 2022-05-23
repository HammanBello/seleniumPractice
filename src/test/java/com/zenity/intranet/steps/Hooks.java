package com.zenity.intranet.steps;

import com.zenity.intranet.driver.WebDriverManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver = WebDriverManager.getDriver();

    public Hooks() {
    }

    @Before
    public void beforeTests() {
        //this.driver.get("https://ztrain-web.vercel.app");
    }
}
