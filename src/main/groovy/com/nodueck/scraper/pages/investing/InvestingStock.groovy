package com.nodueck.scraper.pages.investing;

enum InvestingStock {
	Russel2000('smallcap-2000'),
	DAX('germany-30'),
	TRCommodityExcessReturn('thomson-reuters---jefferies-crb')
	
	private final String urlKey;
	
	private InvestingStock(String urlKey) {
		this.urlKey = urlKey
	}
	
	@Override
	String toString() {
		return this.urlKey
	}
	
}
