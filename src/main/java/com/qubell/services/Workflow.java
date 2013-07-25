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
 * A Qubell workflow
 * @author Alex Krupnov
 */
public class Workflow {
    private String name;
    private WorkflowStatus status;
    private List<WorkflowStep> steps;

    /**
     * Inits workflow with name, status and steps
     * @param name workflow name
     * @param status status of workflow
     * @param steps step of execution
     */
    public Workflow(String name, WorkflowStatus status, List<WorkflowStep> steps) {
        this.name = name;
        this.status = status;
        this.steps = steps;
    }

    /**
     * Name of workflow (command)
     * @return workflow name
     */
    public String getName() {
        return name;
    }

    /**
     * Status of workflow execution
     * @return valid status
     */
    public WorkflowStatus getStatus() {
        return status;
    }

    /**
     * List of running, passed and scheduled WF steps
     * @return list of steps
     */
    public List<WorkflowStep> getSteps() {
        return steps;
    }
}

