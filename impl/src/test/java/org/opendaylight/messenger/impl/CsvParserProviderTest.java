/*
 * Copyright © 2016 Jennifer Lima and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl;

import org.junit.Before;
import org.junit.Test;
import org.opendaylight.messenger.model.CsvElementTable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CsvParserProviderTest
{
	private CsvParserProvider parserProvider;

	@Before
	public void setup()
	{
		parserProvider = new CsvParserProvider(null, new Properties());
	}

	@Test
	public void shouldLoadConfig()
	{
		assertTrue(parserProvider.getConfig().size() == 0);
		parserProvider.loadConfig();
		assertTrue(parserProvider.getConfig().size() == 4);
	}

	@Test
	public void shouldParseCsvToObject() throws IOException
	{
		parserProvider.loadConfig();
		final List<CsvElementTable> elements = parserProvider.parseCsvToObject();
		assertNotNull(elements);
		assertFalse(elements.isEmpty());
	}

	@Test
	public void shouldExportToJson() throws IOException
	{
		parserProvider.loadConfig();
		String jsonPath = parserProvider.getConfig().getProperty("output_dir") + File.separator + parserProvider.getConfig()
				.getProperty("json_filename");
		final Path jsonFile = Paths.get(jsonPath);

		Files.deleteIfExists(jsonFile);
		assertTrue(Files.notExists(jsonFile));

		parserProvider.exportObjectToJson(parserProvider.parseCsvToObject());
		assertTrue(Files.exists(jsonFile));
	}

	@Test
	public void shouldExportToXml() throws IOException
	{
		parserProvider.loadConfig();
		String xmlPath = parserProvider.getConfig().getProperty("output_dir") + File.separator + parserProvider.getConfig()
				.getProperty("xml_filename");
		Files.deleteIfExists(Paths.get(xmlPath));
		assertTrue(Files.notExists(Paths.get(xmlPath)));
		parserProvider.exportObjectToXml(parserProvider.parseCsvToObject());
		assertTrue(Files.exists(Paths.get(xmlPath)));
	}
}
