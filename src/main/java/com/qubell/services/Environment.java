package com.qubell.services;

/**
 * Represents Qubell environment
 * @author Alex Krupnov
 */
public class Environment {
    private String id;
    private Organization organization;
    private String name;

    /**
     * Initializes environment with id only
     * @param id id to use
     */
    public Environment(String id) {
        this.id = id;
    }

    /**
     * Initializes environment
     * @param id id of environment
     * @param organization organizatio
     * @param name name of environment
     */
    public Environment(String id, Organization organization, String name) {
        this.id = id;
        this.organization = organization;
        this.name = name;
    }

    /**
     * Environment identifier
     * @return id value
     */
    public String getId() {
        return id;
    }

    /**
     * Environment's org
     * @return org value or null
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Environment name
     * @return name value or null
     */
    public String getName() {
        return name;
    }
}
