/*
 * Copyright 2013 Qubell, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qubell.jenkinsci.plugins.qubell;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

/**
 * The plugin configuration holder, see {@link GlobalConfiguration} for details
 * @author Alex Krupnov
 */
@Extension
public class Configuration extends GlobalConfiguration {
    private String url;
    private String login;
    private String password;

    /**
     * @return the Jenkins managed singleton for the configuration object
     */
    public static Configuration get() {
        return GlobalConfiguration.all().get(Configuration.class);
    }

    public Configuration() {

    }


    public Configuration(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    /**
     * Loads configuration values from frm data
     * @param req current request
     * @param formData form data
     * @return true when successfull
     * @throws FormException
     */
    @Override
    public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
        // To persist global configuration information,
        // set that to properties and call save().
        login = formData.getString("login");
        password = formData.getString("password");
        url = formData.getString("url");
        // ^Can also use req.bindJSON(this, formData);
        //  (easier when there are many fields; need set* methods for this, like setUseFrench)
        save();
        return super.configure(req, formData);
    }

    /**
     * Qubell api login
     * @return string for email
     */
    public String getLogin() {
        return login;
    }

    /**
     * Qubell user password
     * @return string for password, not exposed to UI via native Jenkins password box
     */
    public String getPassword() {
        return password;
    }

    /**
     * Base URL for Qubell instance
     * @return url value
     */
    public String getUrl() {
        return url;
    }
}
