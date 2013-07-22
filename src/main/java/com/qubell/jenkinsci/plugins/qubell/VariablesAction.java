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

package com.qubell.jenkinsci.plugins.qubell;

import hudson.model.Action;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom {@link Action} used to save and get simple variable between between build steps
 * @author Alex Krupnov
 */
public class VariablesAction implements Action {
    private Map<String, String> variables = new HashMap<String, String>();

    /**
     * {@inheritDoc}
     */
    public String getIconFileName() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String getDisplayName() {
        return "VariablesAction";
    }

    /**
     * Adds a variable to build persistent container
     * @param key key of variable
     * @param value value
     */
    public void addVariable(String key, String value) {

        variables.put(key, value);
    }

    /**
     * Gets variable for a key
     * @param key key of variable
     * @return value or null
     */
    public String getVariable(String key) {
        if (!variables.containsKey(key)) {
            return null;
        }

        return variables.get(key);
    }

    /**
     * {@inheritDoc}
     */
    public String getUrlName() {
        return null;
    }
}
