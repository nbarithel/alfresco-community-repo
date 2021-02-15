/*
 * #%L
 * Alfresco Remote API
 * %%
 * Copyright (C) 2005 - 2021 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software.
 * If the software was purchased under a paid Alfresco license, the terms of
 * the paid license agreement will prevail.  Otherwise, the software is
 * provided under the following open source license terms:
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

package org.alfresco.rest.api.model;

import org.alfresco.service.cmr.dictionary.TypeDefinition;
import org.alfresco.service.cmr.i18n.MessageLookup;

import java.util.List;

public class Type extends AbstractClass
{
    public Type()
    {
    }

    public Type(TypeDefinition typeDefinition, MessageLookup messageLookup, List<PropertyDefinition> properties)
    {
        this.id = typeDefinition.getName().toPrefixString();
        this.title = typeDefinition.getTitle(messageLookup);
        this.description = typeDefinition.getDescription(messageLookup);
        this.parentId = getParentNameAsString(typeDefinition.getParentName());
        this.properties = setList(properties);
        this.model = getModelInfo(typeDefinition, messageLookup);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder(512);
        builder.append("Type [id=").append(this.id)
                .append(", title=").append(this.title)
                .append(", description=").append(this.description)
                .append(", parentId=").append(parentId)
                .append(", properties=").append(properties)
                .append(']');
        return builder.toString();
    }
}

