package com.qubell.services;

import com.qubell.services.ws.*;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

public class OrganizationServiceImplIT  extends BaseServiceIT {

    private final String orgId = "51fc2492e4b06130966ff0f4";

    @Test
    public void testGetOrganizations() throws Exception {
        OrganizationServiceWsImpl organizationService = new OrganizationServiceWsImpl(getTestConfiguration());

        List<Organization> orgs = organizationService.listOrganizations();

        assertNotNull(orgs);
        assertNotSame(0, orgs.size());
    }

    @Test
    public void testGetApps() throws Exception {
        OrganizationServiceWsImpl organizationService = new OrganizationServiceWsImpl(getTestConfiguration());
        Organization organization = new Organization();

        organization.setId(orgId);
        List<com.qubell.services.ws.Application> apps = organizationService.listApplications(organization);

        assertNotNull(apps);
        assertNotSame(0, apps.size());
    }

    @Test
    public void testGetEnvs() throws Exception {
        OrganizationServiceWsImpl organizationService = new OrganizationServiceWsImpl(getTestConfiguration());
        Organization organization = new Organization();

        organization.setId(orgId);
        List<Environment> envs = organizationService.listEnvironments(organization);

        assertNotNull(envs);
        assertNotSame(0, envs.size());
    }

}
