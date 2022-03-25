package com.stepDefinitions;

import com.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){

        Driver.get().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File source = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.FILE);
            String fileSuffix = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
            FileHandler.copy(source, new File("screenshot/Screenshot_"+fileSuffix+".png"));
        }
        Driver.closeDriver();

    }

}
