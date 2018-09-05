/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive.catalog.util.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.ow2.proactive.catalog.repository.entity.KeyValueLabelMetadataEntity;


/**
 * CatalogObjectParser is a generic class for objects parsing
 *
 * @author ActiveEon Team
 */
public abstract class AbstractCatalogObjectParser {

    protected static final String GENERAL_LABEL = "General";

    public List<KeyValueLabelMetadataEntity> parse(InputStream inputStream) throws XMLStreamException {

        List<KeyValueLabelMetadataEntity> keyValueMetadataEntities = new ArrayList<>();

        keyValueMetadataEntities.addAll(getMetadataKeyValues(inputStream));

        keyValueMetadataEntities.add(new KeyValueLabelMetadataEntity("main.icon",
                                                                     getIconPath(keyValueMetadataEntities),
                                                                     GENERAL_LABEL));

        return keyValueMetadataEntities;
    }

    public abstract String getIconPath(List<KeyValueLabelMetadataEntity> keyValueMetadataEntities);

    abstract List<KeyValueLabelMetadataEntity> getMetadataKeyValues(InputStream inputStream) throws XMLStreamException;

    public abstract boolean isMyKind(String kind);

}