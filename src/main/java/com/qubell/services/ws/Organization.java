package com.qubell.services.ws;

/**
 * A WS object container for Qubell organization
 * @author Alex Krupnov
 */
public class Organization {
    private String id;
    private String name;

    /**
     * Organization id
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /***
     * Sets organization id
     * @param id id value
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Organization name
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets organization name
     * @param name value to be set
     */
    public void setName(String name) {
        this.name = name;
    }
}
