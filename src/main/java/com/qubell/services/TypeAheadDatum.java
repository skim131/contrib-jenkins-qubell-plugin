package com.qubell.services;

import java.util.List;

/**
 * Defines base contract for providing TypeAhead.js Datum {@link "https://github.com/twitter/typeahead.js#datum"}
 * @author Alex Krupnov
 */
public interface TypeAheadDatum {
    /**
     * The string that represents the underlying value of the datum
     * @return value of string
     */
    String getValue();

    /**
     * Collection of strings that aid typeahead.js in matching datums with a given query
     * @return tokens collecion
     */
    List<String> getTokens();

}
