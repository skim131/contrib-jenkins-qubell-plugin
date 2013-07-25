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

import com.qubell.services.Application;
import com.qubell.services.Instance;
import com.qubell.services.InstanceStatus;
import com.qubell.services.InstanceStatusCode;
import com.qubell.services.ws.InstanceStatusResponse;

import java.util.Locale;

/**
 * Responsible for converting WS < - > Domain instance data
 * @author Alex Krupnov
 */
public class InstanceStatusTOA {
    /**
     * Builds a domain instance status from WS response
     * @param response WS response
     * @return domain object
     */
    public InstanceStatus fromWsResponse(InstanceStatusResponse response) {
        Instance i = new Instance(response.getId(), response.getName());

        InstanceStatus instanceStatus = new InstanceStatus();
        instanceStatus.setInstance(i);
        instanceStatus.setStatus(getStatusCode(response.getStatus()));
        instanceStatus.setApplication(new Application(response.getApplicationId()));
        instanceStatus.setErrorMessage(response.getErrorMessage());
        instanceStatus.setReturnValues(response.getReturnValues());
        instanceStatus.setVersion(response.getVersion());
        instanceStatus.setCurrentWorkflow(new WorkflowTOA().fromWSWorkflow(response.getWorkflow()));

        return instanceStatus;
    }

    private InstanceStatusCode getStatusCode(com.qubell.services.ws.InstanceStatus status) {
        return InstanceStatusCode.valueOf(status.toString().toUpperCase(Locale.ENGLISH));
    }

}
