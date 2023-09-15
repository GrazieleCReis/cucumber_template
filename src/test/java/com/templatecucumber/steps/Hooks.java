package com.templatecucumber.steps;

import com.templatecucumber.core.Config;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.templatecucumber.core.DriverManager.getDriver;
import static com.templatecucumber.core.DriverManager.killDriver;

public class Hooks {

    @After
    public static void quit(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        if(Config.BROWSER_CLOSE) killDriver();
    }
}
