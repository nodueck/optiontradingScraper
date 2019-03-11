package com.nodueck.excel;

import java.awt.Color

import com.jameskleeh.excel.ExcelBuilder
import com.jameskleeh.excel.Font
import com.nodueck.model.MovingAverage
import com.nodueck.model.OptionIndicators
import com.nodueck.model.MovingAverage.Security

class ExcelWriter {
	
	public writeOptionIndicatorsToExcel(File file, OptionIndicators optionIndicators, Map<Security,MovingAverage> movingAverages) {
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet("Auswertung") {
				row {
					cell("MarkScan", [font: Font.BOLD])
					skipCells(1)
					formula("HEUTE()", [font: Font.BOLD])
				}
				skipRows(1)
				row {
					cell("VIX", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.vix)
				}
				row {
					cell("TSK", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.tsk.toString())
				}
				row {
					cell("VIX - VX1", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.vixMinuxVx1)
				}
				row {
					cell("VX1 - VX2", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.vx1MinuxVx2)
				}
				row {
					cell("VX2 - VX3", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.vx2MinuxVx3)
				}
				row {
					cell("VVIX", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.vvix)
				}
				row {
					cell("OVX", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.ovx)
				}
				row {
					cell("GVZ", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.gvz)
				}
				row {
					cell("EVZ", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.evz)
				}
				row {
					cell("AD", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.ad)
				}
				row {
					cell("F&G", [font: Font.BOLD])
					skipCells(1)
					cell(optionIndicators.fearAndGreed)
				}

				skipRows(1)
				row {
					cell("21er MA's", [font: Font.BOLD])
					skipCells(1)
					cell("DLY", [font: Font.BOLD])
				}
				movingAverages.each { sec, avg ->
					row {
						cell(sec.toString(), [font: Font.BOLD])
						skipCells(1)
						cell(avg.sec21MaValue, [backgroundColor: avg.isPositive() ? "#33cc33" : "#ff0000"])
						cell(avg.secValue - avg.sec21MaValue, [backgroundColor: avg.isPositive() ? "#33cc33" : "#ff0000"])
					}
				}

			}
		}
	}
}