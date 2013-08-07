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

package com.qubell.services.ws;

import com.qubell.jenkinsci.plugins.qubell.Configuration;
import hudson.cli.NoCheckTrustManager;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl;
import org.apache.cxf.transport.http.HTTPConduit;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.RuntimeDelegate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * Base Web Service for Qubell API integration
 *
 * @author Alex Krupnov
 */
public abstract class WebServiceBase {
    /**
     * App configuration
     */
    protected final Configuration configuration;

    public WebServiceBase(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Returns an Apache CXF Web Client
     *
     * @return client new instance
     */
    protected WebClient getWebClient() {
        setRuntimeDelegate();

        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());

        String url = configuration.getUrl();
        if (!url.endsWith("/")) {
            url = url.concat("/");
        }

        WebClient client = WebClient.create(url.concat("api/1/"), providerList);
        if (configuration.isSkipCertificateChecks()) {
            configurePassThroughSSLCheck(client);
        }


        // Replace 'user' and 'password' by the actual values
        String authorizationHeader = "Basic "
                + org.apache.cxf.common.util.Base64Utility.encode(String.format("%s:%s",
                configuration.getLogin(), configuration.getPassword()).getBytes());

        client.header("Authorization", authorizationHeader);
        client.accept(MediaType.APPLICATION_JSON_TYPE);
        client.header("Content-Type", MediaType.APPLICATION_JSON_TYPE);

        if (configuration.isEnableMessageLogging()) {
            WebClient.getConfig(client).getInInterceptors().add(new LoggingInInterceptor());
            WebClient.getConfig(client).getOutInterceptors().add(new LoggingOutInterceptor());
        }

        return client;
    }

    private void configurePassThroughSSLCheck(WebClient client) {
        TrustManager tm = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType)
                    throws CertificateException {
                //do nothing, you're the client
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType)
                    throws CertificateException {
            }
        };
        System.setProperty("jsse.enableSNIExtension", "false");
        HTTPConduit conduit = WebClient.getConfig(client)
                .getHttpConduit();

        TLSClientParameters params = conduit.getTlsClientParameters();
        if (params == null) {
            params = new TLSClientParameters();
        }
        params.setTrustManagers(new TrustManager[]{tm});
        params.setDisableCNCheck(true);

        conduit.setTlsClientParameters(params);
    }

    //Due to jenkins container issue, Apache CXF runtime delegate is not found and hence has to be set manually
    private void setRuntimeDelegate() {
        try {
            RuntimeDelegate.getInstance();
        } catch (Exception e) {
            RuntimeDelegate.setInstance(new RuntimeDelegateImpl());
        }
    }
}
