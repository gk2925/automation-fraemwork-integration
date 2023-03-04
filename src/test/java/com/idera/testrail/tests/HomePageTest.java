package com.idera.testrail.tests;

import org.apache.commons.lang3.SystemUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HomePageTest {

    public static WebDriver driver;

    @BeforeEach
    public void setUp() {
        String os = SystemUtils.OS_NAME;
        System.out.println("The name of the operating system is " + os);
        String pathToChromeDriver = null;
        if (os.contains("Windows")) {
            pathToChromeDriver = "drivers/windows/chromedriver.exe";
        } else {
            pathToChromeDriver = "drivers/linux/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--no-proxy-server");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        //Navigation: Open a website
        driver.navigate().to("https://www.gurock.com/testrail");
    }

    @AfterEach
    public void tearDown(){
        //Quit Driver after completing of every test
        driver.quit();
    }

    @Test
    void verifyTitleOfHomePage() {
        //Assertion: Check its title is correct
        //assertEquals method Parameters: Expected Value, Actual Value, Assertion Message
        assertEquals("TestRail: Test Management & QA Software for Agile Teams", driver.getTitle(), "Title check failed!");
    }

    @Test
    void verifyPresenceOfDemoLinkOnHomePage() {
        //Assertion: Check the presence of demo link
        WebElement demoLinkElement = driver.findElement(By.cssSelector("a.btn.btn-medium.btn-outline-white"));
        assertTrue(demoLinkElement.isDisplayed());
    }


}