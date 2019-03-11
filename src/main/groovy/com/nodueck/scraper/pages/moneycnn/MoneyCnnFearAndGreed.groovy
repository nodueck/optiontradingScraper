package com.nodueck.scraper.pages.moneycnn;

import geb.Page;

public class MoneyCnnFearAndGreed extends Page {
	
	static url = 'https://money.cnn.com/data/fear-and-greed'
	
	static content = {
        fearAndGreedIndex { 
			String fearAndGreedText = js.exec("return document.querySelectorAll('#needleChart ul li')[0].textContent;")
			Integer.parseInt(fearAndGreedText.find(/\d+/))
		}
	}
}
