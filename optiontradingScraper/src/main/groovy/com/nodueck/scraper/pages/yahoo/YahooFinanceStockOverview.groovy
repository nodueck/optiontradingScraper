package com.nodueck.scraper.pages.yahoo;

import geb.Page

public class YahooFinanceStockOverview extends YahooFinance {

	static url = "https://finance.yahoo.com/"

    enum YahooStock {
        EVZ,
        GVZ,
        RUT,
        VVIX,
        OVX,
        VIX
    }

    String convertToPath(YahooStock stock) {
        return "/quote/%5E${stock}"
    }
}
