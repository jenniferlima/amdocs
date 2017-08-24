/*
 * Copyright © 2016 Jennifer Lima and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.messenger.model.CsvElementTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CsvParserProvider
{

	private static final Logger LOG = LoggerFactory.getLogger(CsvParserProvider.class);

	private final DataBroker dataBroker;

	private final Properties config;

	public CsvParserProvider(final DataBroker dataBroker, final Properties config)
	{
		this.dataBroker = dataBroker;
		this.config = config;
	}

	/**
	 * Method called when the blueprint container is created.
	 */
	public void init()
	{
		LOG.info("CsvParserProvider Session Initiated");
		loadConfig();

		processCSV();
	}

	/**
	 * Method called when the blueprint container is destroyed.
	 */
	public void close()
	{
		LOG.info("CsvParserProvider Closed");
	}

	public void loadConfig()
	{
		try
		{
			this.config.load(this.getClass().getResourceAsStream("/config.properties"));
		}
		catch (IOException e)
		{
			throw new RuntimeException("Error while loading the config file", e);
		}
	}

	public void processCSV()
	{
		final List<CsvElementTable> elements = parseCsvToObject();
		logParseResult(elements);
		exportObjectToJson(elements);
		exportObjectToXml(elements);
	}

	public List<CsvElementTable> parseCsvToObject()
	{
		CsvMapper csvMapper = new CsvMapper();
		final CsvSchema csvSchema = csvMapper.schemaFor(CsvElementTable.class).withHeader();
		final MappingIterator<CsvElementTable> objectMappingIterator;
		try
		{
			objectMappingIterator = csvMapper.readerWithSchemaFor(CsvElementTable.class)
					.with(csvSchema)
					.readValues(new File(this.config.getProperty("input_file")));
			return objectMappingIterator.readAll();
		}
		catch (IOException e)
		{
			throw new RuntimeException("Error while reading the csv ", e);
		}

	}

	public void logParseResult(final List<CsvElementTable> elements)
	{
		elements.stream().map(CsvElementTable::toString).forEach(LOG::info);
	}

	public void exportObjectToXml(final List<CsvElementTable> elements)
	{
		try
		{
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.writeValue(new File(this.config.get("output_dir") + File.separator + this.config.getProperty("xml_filename")),
					elements);
		}
		catch (IOException e)
		{
			throw new RuntimeException("Error while exporting XML file", e);
		}
	}

	public void exportObjectToJson(final List<CsvElementTable> elements)
	{
		//JSON
		try
		{
			ObjectMapper jsonMapper = new ObjectMapper();
			jsonMapper.writeValue(new File(this.config.get("output_dir") + File.separator + this.config.getProperty("json_filename")),
					elements);
		}
		catch (IOException e)
		{
			throw new RuntimeException("Error while exporting JSON file", e);
		}
	}

	public Properties getConfig()
	{
		return config;
	}
}
