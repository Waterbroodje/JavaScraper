package me.waterbroodje.service;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DynamicScrapeService {

    public String scrapePage(String url, boolean headless, Integer wait) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        ChromeDriver driver;
        if (headless) {
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.get(url);

        return driver.getPageSource();
    }
}
