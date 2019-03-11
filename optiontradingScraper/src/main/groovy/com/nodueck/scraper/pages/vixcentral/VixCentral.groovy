package com.nodueck.scraper.pages.vixcentral;

import org.openqa.selenium.By

import geb.Page;

public class VixCentral extends Page {
	
	static url = "http://www.vixcentral.com"
	
	static content = {
		vixTable { $("#basicTable") }
		
		firstFuture { $(By.cssSelector('g.highcharts-data-labels:nth-child(15) > g:nth-child(1) > text:nth-child(1) > tspan:nth-child(2)')).text() }
		
		contango1 { vixTable.$("td", 0).text() }
		contango2 { vixTable.$("td", 1).text() }
		contango3 { vixTable.$("td", 2).text() }
		contango4 { vixTable.$("td", 3).text() }
		contango5 { vixTable.$("td", 4).text() }
		contango6 { vixTable.$("td", 5).text() }
		contango7 { vixTable.$("td", 6).text() }
		
		difference1 { vixTable.$("td", 7).text() }
		difference2 { vixTable.$("td", 8).text() }
		difference3 { vixTable.$("td", 9).text() }
		difference4 { vixTable.$("td", 10).text() }
		difference5 { vixTable.$("td", 11).text() }
		difference6 { vixTable.$("td", 12).text() }
		difference7 { vixTable.$("td", 13).text() }
	}
}
