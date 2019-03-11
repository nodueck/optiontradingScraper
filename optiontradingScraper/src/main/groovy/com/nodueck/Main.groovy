package com.nodueck

import com.nodueck.excel.ExcelWriter
import com.nodueck.model.MovingAverage
import com.nodueck.model.OptionIndicators
import com.nodueck.scraper.Scraper

class Main {
	static void main(String[] args) {
		OptionIndicators indicators = new Scraper().scrapeOptionIndicators()
		Map<MovingAverage.Security, MovingAverage> movingAverages = new Scraper().scrapeMovingAverages()

		File file = new File('test.xlsx')

		new ExcelWriter().writeOptionIndicatorsToExcel(file, indicators, movingAverages)
		
		//OptionIndicators2 indicators2 = new Scraper().scrapeOptionIndicators2()
		//println indicators2
	}
}
