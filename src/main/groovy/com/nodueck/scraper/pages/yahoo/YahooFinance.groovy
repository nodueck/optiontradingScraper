package com.nodueck.scraper.pages.yahoo;

import geb.Page

public class YahooFinance extends Page {
	
	static url = "https://finance.yahoo.com"
	
	static content = {
		button {$("body > div > div > div > form > div > button.btn.primary")}
		
		index { 
			String indexText = $(".quote-header-section").$("span", "data-reactid": "34").text()
			Double.parseDouble(indexText) 
		}
	}
}
