package com.company;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Main
{
    public static void main(String[] args) throws Exception {

        final int MAX_CRAWL_DEPTH = 1;
        final int NUMBER_OF_CRAWELRS = 2;
        final String CRAWL_STORAGE = "F:\\crawler-data";

        /*
         * Instantiate crawl config
         */
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(CRAWL_STORAGE);
        config.setMaxDepthOfCrawling(MAX_CRAWL_DEPTH);

        /*
         * Instantiate controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);


        /*
         * Add seed URLs
         */
        controller.addSeed("https://www.bbc.com/sport");

        /*
         * Start the crawl.
         */
        controller.start(TestCrawler.class, NUMBER_OF_CRAWELRS);
    }
}