package com.nodueck.scraper.pages.barchart

import java.text.NumberFormat

import geb.Page

public class BarchartTechnicalAnalysis extends Page {

	static url = 'https://www.barchart.com'

	String convertToPath(BarchartStock stock) {
		return "/stocks/quotes/${stock}/technical-analysis"
	}
	
	static content = {
		movingAvg20 { 
			waitFor(2) {
				String movingAvg20Text = $('div.analysis-table-wrapper:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ng-transclude:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)').text()
				NumberFormat.getInstance(Locale.US).parse(movingAvg20Text).doubleValue()
			}
		}
	}
}
