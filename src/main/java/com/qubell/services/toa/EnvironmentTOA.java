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

import com.qubell.services.Environment;
import com.qubell.services.ws.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for assembling and disassembling {@link com.qubell.services.Environment} objec
 * @author Alex Krupnov
 */
public class EnvironmentTOA {
    /**
     * Builds environment object based on WS org and env
     * @param wsEnv web service object for environment
     * @param wsOrg web service object for organization
     * @return instance of environment
     */
    public Environment fromWs(com.qubell.services.ws.Environment wsEnv, Organization wsOrg){
        return new Environment(wsEnv.getId(), new OrganizationTOA().fromWs(wsOrg), wsEnv.getName());
    }

    /**
     * Converts a list of web service environments to list of environments
     * @param wsEnvironments ws environments
     * @param wsOrg ws organization
     * @return not null list of environments
     */
    public List<Environment> fromWs(List<com.qubell.services.ws.Environment> wsEnvironments, Organization wsOrg){
        List<Environment> environments = new ArrayList<Environment>();

        for(com.qubell.services.ws.Environment wsEnv : wsEnvironments){
            environments.add(fromWs(wsEnv, wsOrg));
        }

        return environments;
    }
}
