package me.waterbroodje.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public class StaticScrapeService {

    public String scrapePage(String url, boolean includeUserAgent, boolean followRedirects, Map<String, String> headers) {
        try {
            Connection connection = Jsoup.connect(url);
            connection.followRedirects(followRedirects);
            connection.ignoreContentType(true);

            // Add headers if provided
            if (headers != null) {
                connection.headers(headers);
            }

            // Include user-agent
            if (includeUserAgent) {
                connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
            }

            Document document = connection.get();
            return document.body().html();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Document scrapeDocument(String url, boolean includeUserAgent, boolean followRedirects, Map<String, String> headers) {
        try {
            Connection connection = Jsoup.connect(url);
            connection.followRedirects(followRedirects);
            connection.ignoreContentType(true);

            // Add headers if provided
            if (headers != null) {
                connection.headers(headers);
            }

            // Include user-agent
            if (includeUserAgent) {
                connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
            }

            return connection.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}