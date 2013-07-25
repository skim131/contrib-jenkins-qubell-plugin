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

import java.util.Locale;

/**
 * Responsible for converting WS  - > Domain workflow  data
 * @author Alex Krupnov
 */
public class WorkflowTOA {
    /**
     * Converts WS workflows to re
     * @param wsWorkflow WS workflow object
     * @return domain entity, nullable
     */
    public com.qubell.services.Workflow fromWSWorkflow(com.qubell.services.ws.Workflow wsWorkflow) {
        if(wsWorkflow == null){
            return null;
        }
        return new com.qubell.services.Workflow(wsWorkflow.getName(), getWorkflowStatus(wsWorkflow.getStatus()), new WorkflowStepTOA().fromWs(wsWorkflow.getSteps()));
    }

    private com.qubell.services.WorkflowStatus getWorkflowStatus(com.qubell.services.ws.WorkflowStatus status) {
        return com.qubell.services.WorkflowStatus.valueOf(status.toString().toUpperCase(Locale.ENGLISH));
    }
}
