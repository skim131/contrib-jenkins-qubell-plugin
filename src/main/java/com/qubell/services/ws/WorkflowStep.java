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

/**
 * Workflow step
 * @author Alex Krupnov
 */
@XmlRootElement
public class WorkflowStep {
    private String name;
    private WorkflowStepStatus status;
    private int percentComplete;

    /**
     * Step name
     * @return name of step
     */
    public String getName() {
        return name;
    }

    /**
     * Sets step name
     * @param name name string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Step status
     * @return enum value
     */
    public WorkflowStepStatus getStatus() {
        return status;
    }

    /**
     * Sets status of step workflow
     * @param status
     */
    public void setStatus(WorkflowStepStatus status) {
        this.status = status;
    }

    /**
     * Step percent complete
     * @return percent complete number (0-100)
     */
    public int getPercentComplete() {
        return percentComplete;
    }

    /**
     * Sets percent complete
     * @param percentComplete percent complete value
     */
    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }
}
