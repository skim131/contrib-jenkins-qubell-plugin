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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Base type for Qubell WS request builder
 * @author Alex Krupnov
 */
public abstract class AbstractRequestBuilder<T extends AbstractRequestBuilder> {
    protected Map<String, Object> targetFields = new HashMap<String, Object>();

    /**
     * Adds custom parameters
     * @param parameters parameters map
     * @return instance of builder itself
     */
    public T addParameters(Map<String, Object> parameters)
    {
        if(parameters != null){
            targetFields.putAll(parameters);
        }

        return (T) this;
    }

    /**
     * Builds a request map from current step
     * @return value of request map
     */
    public Map<String, Object> getRequest() {
        return Collections.unmodifiableMap(targetFields);
    }
}
