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

import com.qubell.services.WorkflowStep;
import com.qubell.services.ws.WorkflowStepStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Responsible for converting WS  - > Domain workflow step data
 * @author Alex Krupnov
 */
public class WorkflowStepTOA {
    /**
     * Convert WS workflow steps to domain entities
     * @param wsSteps WS workflow steps
     * @return a list of domain workflow step objects, not null
     */
    public List<WorkflowStep> fromWs(List<com.qubell.services.ws.WorkflowStep> wsSteps) {
        List<WorkflowStep> steps = new ArrayList<WorkflowStep>();
        if (wsSteps != null) {
            for (com.qubell.services.ws.WorkflowStep wsStep : wsSteps) {
                steps.add(new WorkflowStep(wsStep.getName(), getStepStatus(wsStep.getStatus()) ,wsStep.getPercentComplete()));
            }
        }

        return steps;
    }

    private com.qubell.services.WorkflowStepStatus getStepStatus(WorkflowStepStatus wsStepStatus) {
        return com.qubell.services.WorkflowStepStatus.valueOf(wsStepStatus.toString().toUpperCase(Locale.ENGLISH));
    }
}
