package me.waterbroodje;

import me.waterbroodje.service.DynamicScrapeService;
import me.waterbroodje.service.StaticScrapeService;

import java.util.HashMap;
import java.util.Map;

public class JavaScraper {

    private final DynamicScrapeService dynamicScrapeService;
    private final StaticScrapeService staticScrapeService;

    public JavaScraper() {
        this.dynamicScrapeService = new DynamicScrapeService();
        this.staticScrapeService = new StaticScrapeService();
    }

    public String getStaticPage(String url, boolean includeUserAgent, boolean followRedirects, Map<String, String> headers) {
        return staticScrapeService.scrapePage(url, includeUserAgent, followRedirects, headers);
    }

    public String getDynamicPage(String url, boolean headless, int wait) {
        return dynamicScrapeService.scrapePage(url, headless, wait);
    }

    public static Map<String, String> defaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        headers.put("Accept-Language", "en-US,en;q=0.5");
        headers.put("Cache-Control", "no-cache");
        return headers;
    }
}