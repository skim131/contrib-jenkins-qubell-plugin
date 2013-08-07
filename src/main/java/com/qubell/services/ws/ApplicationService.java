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

import com.qubell.services.exceptions.InvalidCredentialsException;
import com.qubell.services.exceptions.InvalidInputException;

import java.util.Map;

/**
 * Service for app specific operations
 * @author Alex Krupnov
 */
public interface ApplicationService {
    /**
     * Launches new instance
     * @param applicationId app id
     * @param instanceName instnance name (optional)
     * @param version version to use (optional)
     * @param environmentId environment id (optional)
     * @param destroyInterval interval for destroy (optional)
     * @param parameters extra launch parameters
     * @return server response
     * @throws InvalidCredentialsException when credentials are invalid
     */
    LaunchInstanceResponse launch(String applicationId, String instanceName, Integer version, String environmentId, long destroyInterval, Map<String, Object> parameters) throws InvalidCredentialsException;

    /**
     * Updates application manifest
     * @param applicationId id of app to update
     * @param manifest yaml manifest string
     * @return server response
     * @throws InvalidCredentialsException when credentials are invalid
     * @throws InvalidInputException when manifes is invalid
     */
    UpdateManifestResponse updateManifest(String applicationId, String manifest) throws InvalidCredentialsException, InvalidInputException;
}
