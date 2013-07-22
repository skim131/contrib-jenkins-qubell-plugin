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

import com.qubell.jenkinsci.plugins.qubell.Configuration;
import com.qubell.services.exceptions.InvalidCredentialsException;
import com.qubell.services.exceptions.InvalidInputException;
import com.qubell.services.toa.InstanceStatusTOA;
import com.qubell.services.ws.*;

import java.util.Map;

/**
 * Joining multiple restfull web services, see {@link InstanceService} and {@link ApplicationService}
 * @author Alex Krupnov
 */
public class QubellFacadeImpl implements QubellFacade {
    private Configuration configuration;


    /**
     * Instance web service
     * @return istance of service
     */
    protected InstanceService getInstanceService(){
        return new InstanceServiceWsImpl(configuration);
    }

    /**
     * Application Web Service
     * @return instance of service
     */
    protected ApplicationService getApplicationService(){
        return new ApplicationServiceWsImpl(configuration);
    }

    /**
     * A configuration object for Qubell plugin
     * @param configuration instance of configuratio
     */
    public QubellFacadeImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * {@inheritDoc}
     */
    public Instance launchInstance(InstanceSpecification instanceSpecification, LaunchSettings launchSettings) throws InvalidCredentialsException {
        LaunchInstanceResponse instanceResponse = getApplicationService().launch(
                instanceSpecification.getApplication().getId(),
                instanceSpecification.getInstanceName(),
                instanceSpecification.getVersion(),
                launchSettings.getEnvironmentId(),
                launchSettings.getDestroyInterval(),
                launchSettings.getParameters()
        );

        return new Instance(instanceResponse.getId(), instanceSpecification.getInstanceName());
    }

    /**
     * {@inheritDoc}
     */
    public String updateManifest(Application application, Manifest manifest) throws InvalidCredentialsException, InvalidInputException {
        return getApplicationService().updateManifest(application.getId(), manifest.getContent()).getVersion();
    }

    /**
     * {@inheritDoc}
     */
    public InstanceStatus getStatus(Instance instance) throws InvalidCredentialsException {
        return new InstanceStatusTOA().fromWsResponse(getInstanceService().getStatus(instance.getId()));
    }

    /**
     * {@inheritDoc}
     */
    public void runCommand(Instance instance, String commandName) throws InvalidCredentialsException, InvalidInputException {
        runCommand(instance, commandName, null);
    }

    /**
     * {@inheritDoc}
     */
    public void runCommand(Instance instance, String commandName, Map<String, Object> parameters) throws InvalidCredentialsException, InvalidInputException {
        getInstanceService().runCommand(instance.getId(), commandName, parameters);
    }
}
