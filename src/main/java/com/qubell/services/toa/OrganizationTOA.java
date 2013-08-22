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

package com.qubell.services.toa;

import com.qubell.services.ws.Organization;

/**
 * Responsible for assembling {@link com.qubell.services.Organization} objects
 * @author Alex Krupnov
 */
public class OrganizationTOA  {

    /**
     * Converts WS org to service org
     * @param wsOrg original ws object
     * @return value of assembled organization
     */
    public com.qubell.services.Organization fromWs(Organization wsOrg) {
        return new com.qubell.services.Organization(wsOrg.getId(), wsOrg.getName());
    }
}
