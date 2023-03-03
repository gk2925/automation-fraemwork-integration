package com.idera.testrail.tests;

import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MultiplicationTests {

    @Test
    void MultiplyTwoNumbers() {

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
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        //Step 2- Navigation: Open a website
        driver.navigate().to("https://www.swtestacademy.com/");
        //Step 3- Assertion: Check its title is correct
        //assertEquals method Parameters: Expected Value, Actual Value, Assertion Message
        assertEquals("Software Test Academy", driver.getTitle(), "Title check failed!");
        //Step 4- Close Driver
        driver.close();
        //Step 5- Quit Driver
        driver.quit();

    }
}