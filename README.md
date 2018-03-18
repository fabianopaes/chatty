# Chatty
[![Build Status](https://travis-ci.org/fabianopaes/nw-chatty-rest-api.svg?branch=master)](https://travis-ci.org/fabianopaes/nw-chatty-rest-api)

The chatty repository contains all projects that you need to run properly the chatty solution, an API which deal with users exchanging messages between each other.

This repo is organized as follow

* chatty-rest-api
* chatty-config-server
* chatty-service-discovery

You can choice to run only chatty-rest-api or start up all the solutions together in the microservice environment. For the tests purpose you might be interested in look into the chatty-rest-api, if so just jump into the chatty-rest-api section

## Prerequisites

You need the following things properly installed on your own machine.

* [Docker]()
* [Gradle]() 

``` console
$ docker-compose up
```

```console
$ docker-compose up --build
`````

```console
$ docker-compose -f docker-compose-microservices.yml up --build
``````

## chatty-rest-api

### Documentation

Publish HTML version ([docker](https://www.docker.com/community-edition) required):

```console
$ make publish-documentation
```


## chatty-config-server

The chatty-config-server is an solution to provide a centralized configuration, so this way we have only one place to keep all the apps configuration and can 

## chatty-service-discovery

This is the Chatty service discovery solution, you can reed about this pattern [here](wwww.put.some.martin.flower.com). It uses [Netflix Eureka](https://www.docker.com/community-edition).






