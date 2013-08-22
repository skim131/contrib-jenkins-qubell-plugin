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

package com.qubell.services.ws;

/**
 * A WS object container for Qubell organization
 * @author Alex Krupnov
 */
public class Organization {
    private String id;
    private String name;

    /**
     * Organization id
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /***
     * Sets organization id
     * @param id id value
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Organization name
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets organization name
     * @param name value to be set
     */
    public void setName(String name) {
        this.name = name;
    }
}
