package com.qubell.services;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Represents Qubell organization record
 * @author Alex Krupov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {
    private String name;
    private String id;

    /**
     * Initializes organization with id and name
     * @param name name of org
     * @param id id of org
     */
    public Organization(String id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * @return organization name
     */
    public String getName() {
        return name;
    }

    /**
     * @return organization id
     */
    public String getId() {
        return id;
    }
}
