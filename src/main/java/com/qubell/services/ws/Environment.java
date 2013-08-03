package com.qubell.services.ws;

/**
 * WS wrapper for Qubell app
 * @author Alex Krupnov
 */
public class Environment {
    private String id;
    private String name;
    private boolean isDefault;

    /**
     * Id of environment
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets env id
     * @param id value to be set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name of environment
     * @return name or null
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of environment
     * @param name value to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return true if environment is default within organization
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Sets whether env is default
     * @param aDefault value to be set
     */
    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
