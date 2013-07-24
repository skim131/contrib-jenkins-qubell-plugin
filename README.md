Jenkins Plug-in for Qubell Platform
===================================

[![Build Status](https://travis-ci.org/qubell/contrib-jenkins-qubell-plugin.png?branch=master)](https://travis-ci.org/qubell/contrib-jenkins-qubell-plugin)

Functionality
-------------

Jenkins Plug-in for [Qubell Platform](http://qubell.com) allows to launch and manipulate Qubell instances as a part of a Jenkins build job.

This plug-in provides the following functionality:

* Configure access credentials as a part of global configuration.
* Launch a new instance from a manifest located in the source repository.
* Execute a custom job on the newly-launched instance.
* Destroy the newly-launched instance.
* Execute a custom job on an instance specified by instance ID.
* Fail the build job if any of the actions above is not finished after a configurable timeout.
* Gather instance properties and job execution results in a JSON file to be consumed by the rest of the pipeline.

Compatibility
-------------

This plug-in uses [Qubell Platform API v. 1.3](http://docs.qubell.com/api) and can be used with Qubell Platform R19
and above, either Express or Enterprise editions.
