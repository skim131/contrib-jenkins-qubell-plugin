package com.qubell.services.ws;

import com.qubell.services.exceptions.InvalidCredentialsException;

import java.util.List;

/**
 * Responsible for organization specific operations
 * @author Alex Krupnov
 */

public interface OrganizationService {

    /**
     * Lists Qubell organizations for given account
     * @return not empty list of organizations
     */
    List<Organization> listOrganizations() throws InvalidCredentialsException;

    /**
     * Returns list of applications for given organization
     * @param organization organization to use
     * @return list of apps
     */
    List<Application> listApplications(Organization organization) throws InvalidCredentialsException;

    /**
     * Returns list of environments for given organization
     * @param organization organization to use
     * @return list of environments
     */
    List<Environment> listEnvironments(Organization organization) throws InvalidCredentialsException;
}
