/*
 * Copyright © 2016 Jennifer Lima and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "atomicNumber", "element", "symbol", "atomicWeight", "period", "group", "phase", "mostStable", "type",
						   "ionicRadious", "atomicRadius", "electronegativity", "firstIonizationPotential", "density", "meltingPoint",
						   "boilingPoint", "isotopes", "discoverer", "yearOfDiscovery", "specificHeatCapacity",
						   "electronConfiguration", "displayRow", "displayColumn" })
public class CsvElementTable
{
	private int atomicNumber;
	private String element;
	private String symbol;
	private float atomicWeight;
	private int period;
	private int group;
	private String phase;
	private String mostStable;
	private String type;
	private float ionicRadious;
	private float atomicRadius;
	private float electronegativity;
	private double firstIonizationPotential;
	private double density;
	private float meltingPoint;
	private double boilingPoint;
	private float isotopes;
	private String discoverer;
	private int yearOfDiscovery;
	private String specificHeatCapacity;
	private String electronConfiguration;
	private String displayRow;
	private String displayColumn;

	public int getAtomicNumber()
	{
		return atomicNumber;
	}

	public void setAtomicNumber(final int atomicNumber)
	{
		this.atomicNumber = atomicNumber;
	}

	public String getElement()
	{
		return element;
	}

	public void setElement(final String element)
	{
		this.element = element;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(final String symbol)
	{
		this.symbol = symbol;
	}

	public float getAtomicWeight()
	{
		return atomicWeight;
	}

	public void setAtomicWeight(final float atomicWeight)
	{
		this.atomicWeight = atomicWeight;
	}

	public int getPeriod()
	{
		return period;
	}

	public void setPeriod(final int period)
	{
		this.period = period;
	}

	public int getGroup()
	{
		return group;
	}

	public void setGroup(final int group)
	{
		this.group = group;
	}

	public String getPhase()
	{
		return phase;
	}

	public void setPhase(final String phase)
	{
		this.phase = phase;
	}

	public String getMostStable()
	{
		return mostStable;
	}

	public void setMostStable(final String mostStable)
	{
		this.mostStable = mostStable;
	}

	public String getType()
	{
		return type;
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public float getIonicRadious()
	{
		return ionicRadious;
	}

	public void setIonicRadious(final float ionicRadious)
	{
		this.ionicRadious = ionicRadious;
	}

	public float getAtomicRadius()
	{
		return atomicRadius;
	}

	public void setAtomicRadius(final float atomicRadius)
	{
		this.atomicRadius = atomicRadius;
	}

	public float getElectronegativity()
	{
		return electronegativity;
	}

	public void setElectronegativity(final float electronegativity)
	{
		this.electronegativity = electronegativity;
	}

	public double getFirstIonizationPotential()
	{
		return firstIonizationPotential;
	}

	public void setFirstIonizationPotential(final double firstIonizationPotential)
	{
		this.firstIonizationPotential = firstIonizationPotential;
	}

	public float getMeltingPoint()
	{
		return meltingPoint;
	}

	public void setMeltingPoint(final float meltingPoint)
	{
		this.meltingPoint = meltingPoint;
	}

	public float getIsotopes()
	{
		return isotopes;
	}

	public void setIsotopes(final float isotopes)
	{
		this.isotopes = isotopes;
	}

	public String getDiscoverer()
	{
		return discoverer;
	}

	public void setDiscoverer(final String discoverer)
	{
		this.discoverer = discoverer;
	}

	public int getYearOfDiscovery()
	{
		return yearOfDiscovery;
	}

	public void setYearOfDiscovery(final int yearOfDiscovery)
	{
		this.yearOfDiscovery = yearOfDiscovery;
	}

	public String getSpecificHeatCapacity()
	{
		return specificHeatCapacity;
	}

	public void setSpecificHeatCapacity(final String specificHeatCapacity)
	{
		this.specificHeatCapacity = specificHeatCapacity;
	}

	public String getElectronConfiguration()
	{
		return electronConfiguration;
	}

	public void setElectronConfiguration(final String electronConfiguration)
	{
		this.electronConfiguration = electronConfiguration;
	}

	public String getDisplayRow()
	{
		return displayRow;
	}

	public void setDisplayRow(final String displayRow)
	{
		this.displayRow = displayRow;
	}

	public String getDisplayColumn()
	{
		return displayColumn;
	}

	public void setDisplayColumn(final String displayColumn)
	{
		this.displayColumn = displayColumn;
	}

	public double getDensity()
	{
		return density;
	}

	public void setDensity(final double density)
	{
		this.density = density;
	}

	public double getBoilingPoint()
	{
		return boilingPoint;
	}

	public void setBoilingPoint(final double boilingPoint)
	{
		this.boilingPoint = boilingPoint;
	}

	@Override
	public String toString()
	{
		return "CsvElementTable{" + "atomicNumber=" + atomicNumber + ", element='" + element + '\'' + ", symbol='" + symbol + '\''
				+ ", atomicWeight=" + atomicWeight + ", period=" + period + ", group=" + group + ", phase='" + phase + '\''
				+ ", mostStable='" + mostStable + '\'' + ", type='" + type + '\'' + ", ionicRadious=" + ionicRadious
				+ ", atomicRadius=" + atomicRadius + ", electronegativity=" + electronegativity + ", firstIonizationPotential="
				+ firstIonizationPotential + ", density=" + density + ", meltingPoint=" + meltingPoint + ", boilingPoint="
				+ boilingPoint + ", isotopes=" + isotopes + ", discoverer='" + discoverer + '\'' + ", yearOfDiscovery="
				+ yearOfDiscovery + ", specificHeatCapacity='" + specificHeatCapacity + '\'' + ", electronConfiguration='"
				+ electronConfiguration + '\'' + ", displayRow='" + displayRow + '\'' + ", displayColumn='" + displayColumn + '\''
				+ '}';
	}
}
