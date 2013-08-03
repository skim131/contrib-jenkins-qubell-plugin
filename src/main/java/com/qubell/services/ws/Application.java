package com.qubell.services.ws;

/**
 * WS wrapper for Qubell application
 * @author Alex Krupnov
 */
public class Application {
    private String id;
    private String name;
    private String organizationId;

    /**
     * Application id
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets app id
     * @param id value to be set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Application name
     * @return name of app or null
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name for app
     * @param name value to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Id of organization which app belongs to
     * @return id of org
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets organization id
     * @param organizationId value to be set
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
