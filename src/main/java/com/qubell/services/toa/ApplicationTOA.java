package com.qubell.services.toa;

import com.qubell.services.Application;
import com.qubell.services.ws.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for assemble and dissable of {@link com.qubell.services.Application} object
 * @author Alex Krupnov
 */
public class ApplicationTOA {

    /**
     * Constructs app from ws data
     * @param wsApp ws app to use
     * @param wsOrg ws organization to use
     * @return app instance
     */
    public Application fromWs(com.qubell.services.ws.Application wsApp, Organization wsOrg){
        return new Application(wsApp.getId(), wsApp.getName(), (new OrganizationTOA()).fromWs(wsOrg));
    }

    /**
     * Converts a list of ws apps to list of apps
     * @param wsApps ws apps list
     * @param wsOrg ws org
     * @return a not null list of apps
     */
    public List<Application> fromWs(List<com.qubell.services.ws.Application> wsApps, Organization wsOrg){
        List<Application> apps = new ArrayList<Application>();

        for (com.qubell.services.ws.Application wsApp : wsApps){
            apps.add(fromWs(wsApp, wsOrg));
        }

        return apps;
    }
}
