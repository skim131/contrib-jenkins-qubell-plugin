/*
 * Copyright 2013 Qubell, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qubell.services;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Represents Qubell organization record
 * @author Alex Krupov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {
    private String name;
    private String id;

    /**
     * Initializes organization with id and name
     * @param name name of org
     * @param id id of org
     */
    public Organization(String id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * @return organization name
     */
    public String getName() {
        return name;
    }

    /**
     * @return organization id
     */
    public String getId() {
        return id;
    }
}
