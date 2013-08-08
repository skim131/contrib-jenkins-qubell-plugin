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

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Qubell environment
 * @author Alex Krupnov
 */
public class Environment implements TypeAheadDatum {
    private String id;
    private Organization organization;
    private String name;

    /**
     * Initializes environment with id only
     * @param id id to use
     */
    public Environment(String id) {
        this.id = id;
    }

    /**
     * Initializes environment
     * @param id id of environment
     * @param organization organizatio
     * @param name name of environment
     */
    public Environment(String id, Organization organization, String name) {
        this.id = id;
        this.organization = organization;
        this.name = name;
    }

    /**
     * Environment identifier
     * @return id value
     */
    public String getId() {
        return id;
    }

    /**
     * Environment's org
     * @return org value or null
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Environment name
     * @return name value or null
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public String getValue() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    public List<String> getTokens() {
        List<String> tokens = new ArrayList<String>();
        tokens.add(id);
        if (name != null) {
            for (String token : name.split(" ")) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}
