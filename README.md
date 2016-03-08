# Community
[![Build Status](https://travis-ci.org/pith/community.svg?branch=master)](https://travis-ci.org/pith/community)

A "good accounts make good friends" application. 

*This is a work in progress.*

# Build

This application is composed of a backend and a frontend. To build it from source do the following:

    git clone https://github.com/pith/community.git
    cd community
    ./build.sh

It is also possible to build them separatly using `mvn clean install` and `grunt build`.

# Run

In order to run this app, execute the following commands:

    cd back
    mvn spring-boot:run

Then open your browser at [http://localhost:8080/](http://localhost:8080/).
The REST API is accessible from [http://localhost:8080/api](http://localhost:8080/api).

You can also run the front separatly as follows:

    cd front
    grunt serve

# Copyright and license

This source code is copyrighted by Pierre THIROUIN and released under the terms of the MIT license.
