package com.nodueck.scraper.pages.barchart

import java.text.NumberFormat

import geb.Page

public class BarchartOverview extends Page {

	static url = 'https://www.barchart.com'

	
	String convertToPath(BarchartStock stock) {
		return "/stocks/quotes/${stock}/overview"
	}
	
	static content = {
		index { 
			waitFor(2) {
					String indexText = $(".pricechangerow").$("span", 'data-ng-class': "highlightValue('lastPrice')").text()
					return NumberFormat.getInstance(Locale.US).parse(indexText).doubleValue()
			}
		}
	}
}
