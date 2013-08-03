package com.qubell.services.ws;

import com.qubell.jenkinsci.plugins.qubell.Configuration;
import com.qubell.services.exceptions.InvalidCredentialsException;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.util.List;

/**
 * WS wrapper for Qubell service
 * @author Alex Krupnov
 */
public class OrganizationServiceWsImpl extends WebServiceBase implements OrganizationService {

    /**
     * Initializes WS wrapper with configuration
     * @param configuration plugin configuration
     */
    public OrganizationServiceWsImpl(Configuration configuration) {
        super(configuration);
    }

    /**
     * {@inheritDoc}
     */
    public List<Organization> listOrganizations() throws InvalidCredentialsException {
        WebClient client = getWebClient();

        try {
            List<Organization> response = (List<Organization>) client.path("organizations").get(List.class);
            return response;

        } catch (NotFoundException nfe) {
            throw new InvalidCredentialsException("Invalid credentials ", nfe);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 401 || e.getResponse().getStatus() == 404)
                throw new InvalidCredentialsException("Invalid credentials ", e);
            throw e;
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Application> listApplications(Organization organization) throws InvalidCredentialsException {
        WebClient client = getWebClient();

        try {
            List<Application> response = (List<Application>) client.path("organizations").path(organization.getId()).
                    path("applications")
                    .get(List.class);
            return response;

        } catch (NotFoundException nfe) {
            throw new InvalidCredentialsException("Invalid credentials ", nfe);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 401 || e.getResponse().getStatus() == 404)
                throw new InvalidCredentialsException("Invalid credentials ", e);
            throw e;
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Environment> listEnvironments(Organization organization) throws InvalidCredentialsException {
        WebClient client = getWebClient();

        try {
            List<Environment> response = (List<Environment>) client.path("organizations").path(organization.getId()).
                    path("environments")
                    .get(List.class);
            return response;

        } catch (NotFoundException nfe) {
            throw new InvalidCredentialsException("Invalid credentials ", nfe);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 401 || e.getResponse().getStatus() == 404)
                throw new InvalidCredentialsException("Invalid credentials ", e);
            throw e;
        }
    }
}
