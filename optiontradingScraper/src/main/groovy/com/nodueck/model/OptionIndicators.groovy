package com.nodueck.model

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class OptionIndicators {
	enum TSK {
		Contango,
		Backwardation
	}
	
	Double vix;
	TSK tsk;
	Double vixMinuxVx1;
	Double vx1MinuxVx2;
	Double vx2MinuxVx3;
	Double vvix;
	Double ovx;
	Double gvz;
	Double evz;
	Double ad;
	Integer fearAndGreed;
}

