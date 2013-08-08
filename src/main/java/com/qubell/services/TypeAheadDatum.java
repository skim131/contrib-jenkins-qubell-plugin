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

import java.util.List;

/**
 * Defines base contract for providing TypeAhead.js Datum {@link "https://github.com/twitter/typeahead.js#datum"}
 * @author Alex Krupnov
 */
public interface TypeAheadDatum {
    /**
     * The string that represents the underlying value of the datum
     * @return value of string
     */
    String getValue();

    /**
     * Collection of strings that aid typeahead.js in matching datums with a given query
     * @return tokens collecion
     */
    List<String> getTokens();

}
