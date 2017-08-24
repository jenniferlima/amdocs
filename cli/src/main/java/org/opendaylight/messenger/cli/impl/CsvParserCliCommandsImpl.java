/*
 * Copyright © 2016 Jennifer Lima and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.cli.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.messenger.cli.api.CsvParserCliCommands;

public class CsvParserCliCommandsImpl implements CsvParserCliCommands {

    private static final Logger LOG = LoggerFactory.getLogger(CsvParserCliCommandsImpl.class);
    private final DataBroker dataBroker;

    public CsvParserCliCommandsImpl(final DataBroker db) {
        this.dataBroker = db;
        LOG.info("CsvParserCliCommandImpl initialized");
    }

    @Override
    public Object testCommand(Object testArgument) {
        return "This is a test implementation of test-command";
    }
}