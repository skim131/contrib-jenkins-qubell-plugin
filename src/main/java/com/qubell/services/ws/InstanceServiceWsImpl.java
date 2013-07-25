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

import com.qubell.jenkinsci.plugins.qubell.Configuration;
import com.qubell.services.exceptions.InvalidCredentialsException;
import com.qubell.services.exceptions.InvalidInputException;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.util.Map;

/**
 * @author Alex Krupnov
 * @created 17.07.13 11:27
 */
public class InstanceServiceWsImpl extends WebServiceBase implements InstanceService {

    public InstanceServiceWsImpl(Configuration configuration) {
        super(configuration);
    }

    public RunCommandResponse runCommand(String instanceId, String commandName, Map<String, Object> parameters) throws InvalidCredentialsException, InvalidInputException {
        WebClient client = getWebClient();
        RunCommandRequestBuilder builder = new RunCommandRequestBuilder();
        builder.addParameters(parameters);

        try {
            RunCommandResponse response = client.path("instances").path(instanceId).path(commandName).post(
                    builder.getRequest(), RunCommandResponse.class);

            return response;
        } catch (NotFoundException nfe) {
            throw new InvalidCredentialsException("Invalid credentials ", nfe);
        } catch (BadRequestException bre) {
            throw new InvalidInputException("Invalid input", bre);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 400) {
                throw new InvalidInputException("Invalid input", e);
            }
            if (e.getResponse().getStatus() == 401 || e.getResponse().getStatus() == 404) {
                throw new InvalidCredentialsException("Invalid credentials ", e);
            }
            throw e;
        }


    }


    public InstanceStatusResponse getStatus(String instanceId) throws InvalidCredentialsException {
        WebClient client = getWebClient();

        try {
            InstanceStatusResponse response = client.path("instances").path(instanceId).get(InstanceStatusResponse.class);

            return response;
        } catch (NotFoundException nfe) {
            throw new InvalidCredentialsException("Invalid credentials ", nfe);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 401 || e.getResponse().getStatus() == 404) {
                throw new InvalidCredentialsException("Invalid credentials ", e);
            }
            throw e;
        }


    }
}
