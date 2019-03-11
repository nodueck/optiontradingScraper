package com.nodueck.scraper.pages.barchart;

enum BarchartStock {
	DowJonesIndustrial('$DOWI'),
	GSCommodityIndex('GDY00'),
	Nasdaq100Index('$IUXX'),
	NYSEAdvancesAndDeclines('$NSHF'),
	MSCIWorldETF('URTH'),
	DowJonesIndustrialTransport('$DTWI'),
	SAndPIndex('$INX'),
	EuroStoxx50('MOY00');
	
	private final String urlKey;
	
	private BarchartStock(String urlKey) {
		this.urlKey = urlKey
	}
	
	@Override
	String toString() {
		return this.urlKey
	}
	
}
