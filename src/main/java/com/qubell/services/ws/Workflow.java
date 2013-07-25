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

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Workflow informaion
 * @author Alex Krupnov
 */
@XmlRootElement
public class Workflow {
    private String name;
    private WorkflowStatus status;
    private String ownerId;
    private List<WorkflowStep> steps;

    /**
     * Command name
     * @return command name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets command name
     * @param name name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Execution status
     * @return enum value
     */
    public WorkflowStatus getStatus() {
        return status;
    }

    /**
     * Sets execution status
     * @param status status value
     */
    public void setStatus(WorkflowStatus status) {
        this.status = status;
    }

    /**
     * Execution owner
     * @return owner id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets owner id
     * @param ownerId owner id value
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Workflow execution steps
     * @return list of steps
     */
    public List<WorkflowStep> getSteps() {
        return steps;
    }

    /**
     * Sets execution steps
     * @param steps steps to set
     */
    public void setSteps(List<WorkflowStep> steps) {
        this.steps = steps;
    }
}
