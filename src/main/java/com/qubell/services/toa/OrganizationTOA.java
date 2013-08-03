package com.qubell.services.toa;

import com.qubell.services.ws.Organization;

/**
 * Responsible for assembling {@link com.qubell.services.Organization} objects
 * @author Alex Krupnov
 */
public class OrganizationTOA  {

    /**
     * Converts WS org to service org
     * @param wsOrg original ws object
     * @return value of assembled organization
     */
    public com.qubell.services.Organization fromWs(Organization wsOrg) {
        return new com.qubell.services.Organization(wsOrg.getId(), wsOrg.getName());
    }
}
