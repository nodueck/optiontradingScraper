package com.nodueck.scraper.pages.investing;

import java.text.NumberFormat

import geb.Page

class InvestingTechnical extends Page {
	
	static url = 'https://www.investing.com'
	
	String convertToPath(InvestingStock stock) {
		return "/indices/${stock}-technical"
	}
	
	static content = {
		index {
			String indexText = $('#last_last').text()
			NumberFormat.getInstance(Locale.US).parse(indexText).doubleValue()
		}
		
		movingAvg20 {
			String movingAverage20Text = $('.movingAvgsTbl > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)').text()
			NumberFormat.getInstance(Locale.US).parse(movingAverage20Text).doubleValue()
		}
	}
}