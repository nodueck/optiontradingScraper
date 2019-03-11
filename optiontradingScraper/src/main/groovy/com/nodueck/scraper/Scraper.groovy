package com.nodueck.scraper
import com.nodueck.model.MovingAverage
import com.nodueck.model.OptionIndicators
import com.nodueck.model.OptionIndicators2
import com.nodueck.model.MovingAverage.Security
import com.nodueck.scraper.pages.barchart.BarchartOverview
import com.nodueck.scraper.pages.barchart.BarchartStock
import com.nodueck.scraper.pages.barchart.BarchartTechnicalAnalysis
import com.nodueck.scraper.pages.cboe.CBOE
import com.nodueck.scraper.pages.investing.InvestingStock
import com.nodueck.scraper.pages.investing.InvestingTechnical
import com.nodueck.scraper.pages.moneycnn.MoneyCnnFearAndGreed
import com.nodueck.scraper.pages.vixcentral.VixCentral
import com.nodueck.scraper.pages.yahoo.YahooFinance
import com.nodueck.scraper.pages.yahoo.YahooFinanceStockOverview
import com.nodueck.scraper.pages.yahoo.YahooFinanceStockOverview.YahooStock

import geb.Browser


class Scraper {
	
	OptionIndicators scrapeOptionIndicators() {
		OptionIndicators indicators = new OptionIndicators();
		Browser.drive {
			
			to YahooFinance
			button.click()
			
			to YahooFinanceStockOverview, YahooStock.VIX
			indicators.vix = index
			
			to VixCentral
			indicators.tsk = Double.parseDouble(difference1) > 0.0 ? OptionIndicators.TSK.Contango : OptionIndicators.TSK.Backwardation
			indicators.vixMinuxVx1 = Double.parseDouble(firstFuture) - indicators.vix
			indicators.vx1MinuxVx2 = Double.parseDouble(difference1)
			indicators.vx2MinuxVx3 = Double.parseDouble(difference2)
			
			
			to YahooFinanceStockOverview, YahooStock.VVIX
			indicators.vvix = index
			
			to YahooFinanceStockOverview, YahooStock.OVX
			indicators.ovx = index
			
			to YahooFinanceStockOverview, YahooStock.GVZ
			indicators.gvz = index
			
			to YahooFinanceStockOverview, YahooStock.EVZ
			indicators.evz = index

			BarchartOverview bo = to BarchartOverview, BarchartStock.NYSEAdvancesAndDeclines
			indicators.ad = bo.index
			
			to MoneyCnnFearAndGreed
			indicators.fearAndGreed = fearAndGreedIndex
		}
		
		return indicators
	}
	
	
	Map<Security, MovingAverage> scrapeMovingAverages() {
		
		def movingAverages = [:]

		Browser.drive {
			MovingAverage sandpMA20 = new MovingAverage(Security.SPX)
			to BarchartTechnicalAnalysis, BarchartStock.SAndPIndex
			sandpMA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.SAndPIndex
			sandpMA20.secValue = index
			movingAverages.put(Security.SPX, sandpMA20)
			
			MovingAverage dowJonesIndustrialMA20 = new MovingAverage(Security.DJIA)
			to BarchartTechnicalAnalysis, BarchartStock.DowJonesIndustrial
			dowJonesIndustrialMA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.DowJonesIndustrial
			dowJonesIndustrialMA20.secValue = index
			movingAverages.put(Security.DJIA, dowJonesIndustrialMA20)
			
			MovingAverage dowJonesTransportMA20 = new MovingAverage(Security.DJTA)
			to BarchartTechnicalAnalysis, BarchartStock.DowJonesIndustrialTransport
			dowJonesTransportMA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.DowJonesIndustrialTransport
			dowJonesTransportMA20.secValue = index
			movingAverages.put(Security.DJTA, dowJonesTransportMA20)
			
			MovingAverage nasdaq100MA20 = new MovingAverage(Security.NDX)
			to BarchartTechnicalAnalysis, BarchartStock.Nasdaq100Index
			nasdaq100MA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.Nasdaq100Index
			nasdaq100MA20.secValue = index
			movingAverages.put(Security.NDX, nasdaq100MA20)
			
			MovingAverage russell2000MA20 = new MovingAverage(Security.RUT)
			to InvestingTechnical, InvestingStock.Russel2000
			russell2000MA20.secValue = index
			russell2000MA20.sec21MaValue = movingAvg20
			movingAverages.put(Security.RUT, russell2000MA20)
			
			MovingAverage daxMA20 = new MovingAverage(Security.DAX)
			to InvestingTechnical, InvestingStock.DAX
			daxMA20.secValue = index
			daxMA20.sec21MaValue = movingAvg20
			movingAverages.put(Security.DAX, daxMA20)
			
			MovingAverage euroStoxx50MA20 = new MovingAverage(Security.EX)
			to BarchartTechnicalAnalysis, BarchartStock.EuroStoxx50
			euroStoxx50MA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.EuroStoxx50
			euroStoxx50MA20.secValue = index
			movingAverages.put(Security.EX, euroStoxx50MA20)
			
			MovingAverage msciWorldMA20 = new MovingAverage(Security.URTH)
			to BarchartTechnicalAnalysis, BarchartStock.MSCIWorldETF
			msciWorldMA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.MSCIWorldETF
			msciWorldMA20.secValue = index
			movingAverages.put(Security.URTH, msciWorldMA20)
			
			MovingAverage trCommodityIndexMA20 = new MovingAverage(Security.CR)
			to InvestingTechnical, InvestingStock.TRCommodityExcessReturn
			trCommodityIndexMA20.secValue = index
			trCommodityIndexMA20.sec21MaValue = movingAvg20
			movingAverages.put(Security.CR, trCommodityIndexMA20)
			
			MovingAverage gsCommodityIndexMA20 = new MovingAverage(Security.GI)
			to BarchartTechnicalAnalysis, BarchartStock.GSCommodityIndex
			gsCommodityIndexMA20.sec21MaValue = movingAvg20
			to BarchartOverview, BarchartStock.GSCommodityIndex
			gsCommodityIndexMA20.secValue = index
			movingAverages.put(Security.GI, gsCommodityIndexMA20)
			
		}
		
		return movingAverages
	}
	
	
	OptionIndicators2 scrapeOptionIndicators2() {
		Browser browser = new Browser()
		OptionIndicators2 optionIndicators2 = new OptionIndicators2()
		
		browser.drive {
			CBOE cboePage = to CBOE
			optionIndicators2.pcrEOD = cboePage.eodValue
			optionIndicators2.pcrHighest = cboePage.highestValue
		}
		return optionIndicators2
	}
}