package com.practice;

// Generated by Selenium IDE
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;


public class BcWorkbenchTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"firef_bcw.log");

        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(FirefoxDriverLogLevel.TRACE);

        driver = new FirefoxDriver(options);

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() {
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./image_bcw.png"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    @Test
    public void bcWorkbench() {
        // Step # | name | target | value
        // 1 | open | /business-central/kie-wb.jsp |
        driver.get("http://localhost:8080/business-central/kie-wb.jsp");
        // 2 | setWindowSize | 1632x888 |
        driver.manage().window().setSize(new Dimension(1632, 888));
        // 3 | click | name=j_username |
        driver.findElement(By.name("j_username")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 4 | type | name=j_username | krisv
        driver.findElement(By.name("j_username")).sendKeys("krisv");
        // 5 | click | css=fieldset |
        driver.findElement(By.cssSelector("fieldset")).click();
        // 6 | click | name=j_password |
        driver.findElement(By.name("j_password")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 7 | type | name=j_password | krisv
        driver.findElement(By.name("j_password")).sendKeys("krisv");
        // 8 | click | css=.button |
        driver.findElement(By.cssSelector(".button")).click();
        // 9 | assertText | css=h3 | Login failed: Not Authorized
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Login failed: Not Authorized"));
    }
}