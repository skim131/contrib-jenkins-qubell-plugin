package com.qubell.services;

import com.qubell.jenkinsci.plugins.qubell.Configuration;

/**
 * @author Alex Krupnov
 * @created 17.07.13 11:29
 */
public class BaseServiceIT {
    protected Configuration getTestConfiguration(){
        return new Configuration("https://kohls-beta.qubell.com/","a.krupnov@gmail.com","123123123");
    }
}
