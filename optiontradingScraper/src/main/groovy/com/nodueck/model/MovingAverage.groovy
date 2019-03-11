package com.nodueck.model;

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
public class MovingAverage {

	enum Security {
		SPX,
		DJIA,
		DJTA,
		NDX,
		RUT,
		DAX,
		EX,
		URTH,
		CR,
		GI
	}
	
	public MovingAverage(Security security) {
		this.secName = security
	}
	
	Security secName;
	Double secValue;
	Double sec21MaValue;
	
	boolean isPositive() {
		return secValue > sec21MaValue
	}
	
}
