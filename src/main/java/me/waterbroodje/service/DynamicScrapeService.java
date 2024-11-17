package me.waterbroodje.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DynamicScrapeService {

    public String scrapePage(String url, boolean headless, Integer wait) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver;
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
