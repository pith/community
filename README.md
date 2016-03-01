# Community
[![Build Status](https://travis-ci.org/pith/community.svg?branch=master)](https://travis-ci.org/pith/community)

A "good accounts make good friends" application. 

*This is a work in progress.*

# Run

In order to run REST backend, execute the following commands:

    git clone https://github.com/pith/community.git
    cd community
    mvn spring-boot:run
    
Then serve the frontend with grunt:

    cd src/main/resources/public
    grunt serve
    
Then open your browser at [http://localhost:9000/](http://localhost:9000/) to access the w20 app.

The REST API is accessible from [http://localhost:8080/api](http://localhost:8080/api):

* Get the expenses: /api/expenses
* Get the debts: /api/debts
