package com.nodueck.scraper.pages.cboe;

import java.text.NumberFormat

import geb.Page;

public class CBOE extends Page {
	
	static url = "http://www.cboe.com/data/current-market-statistics"
	
	static content = {
		totalTable { $('.mktstat:first-child > table tbody')[0] }
		
		eodValue { 
				String eodValueText = totalTable.$('tr:last-child td:last-child').text()
				return Double.parseDouble(eodValueText) 
			}
		
		highestValue { 
			List<String> allValuesText = totalTable.$('tr td:last-child')*.text()
			return allValuesText.collect { Double.parseDouble(it) }.max()
		}
		
	}
}
