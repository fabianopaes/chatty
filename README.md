# Chatty
[![Build Status](https://travis-ci.org/fabianopaes/chatty.svg?branch=master)](https://travis-ci.org/fabianopaes/chatty)

The chatty repository contains all projects that you need to run the chatty solution properly. It' an API which deal with users exchanging messages between each other.

This repo is organized as follow

* chatty-rest-api
* chatty-config-server
* chatty-service-discovery

You can choice to run only chatty-rest-api or start up all the solutions together in the microservice environment. For the tests purpose you might be interested in look into the chatty-rest-api, if so just jump into the chatty-rest-api section

## Prerequisites

You need the following things properly installed on your own machine.

* [Docker](https://github.com/Netflix/eureka)
* [Docker Compose](https://docs.docker.com/compose/install/)
* [Gradle](https://gradle.org/) 

## Running Chatty Application

First thing that you need to do is to build the whole project, so just execute the command bellow in the project root directory

``` console
$ gradle build
```

If you don't have gradle installed you still can choice to run using the gradle wrapper that comes with the project, so run the command

``` console
$ ./gradlew build
```

So now you are ready to start up the application.

You can choice to run only chatty-rest-api, this way you have to type as follow:


``` console
$ docker-compose up
```

The command will download the [MongoDB](https://www.mongodb.com) image and star, besides that it will compile a docker image for chatty-rest-api and will start it up on http:localhost:8080.

```console
$ docker-compose up --build
`````

On the other side you might be interested in running all the solution (a REST API, Centralize Configuration Server and a Service Discovery Server)...
```console
$ docker-compose -f docker-compose-microservices.yml up --build
``````

* chatty-config-server will be accessible on http://localhost:8888
* chatty-service-discovery will be accessible on http://localhost:8761
* chatty-rest-api will be accessible on http://localhost:8080

The project has its CI set up on [travis-ci](https://travis-ci.org/fabianopaes/chatty)

## Running tests


``` console
$ gradle test
```


``` console
$ gradle jacocoReport 
```

The jacoco report will be available at $PROJECT_PATH/chatty-rest-api/build/reports/jacoco/


## chatty-rest-api

The chatty-rest-api is the application that deals with users exchange message, it uses a [mongodb]() as database and after you run docker-compose it will be accessible on http://localhost:8080.

When the app has started it collects its settings from chatty-config-server and after it goes to chatty-service-discovery to register itself on the server.  

Since the app is up you can perform some tests to validate the solution, just execute ...

```console
$ bash users.sh
$ bash messages.sh
`````

### Chatty-rest-api Documentation

Publish HTML version ([docker](https://www.docker.com/community-edition) required):

```console
$ make publish-documentation
```

## chatty-config-server

The chatty-config-server is an solution that provide a centralized configuration, so this way we have only one place to keep all the apps configuration.

Every single time when an app is starting up it will call to chatty-config-server to retrieve its all configs.

The chatty-config-server is reading data from another github repo, you can see [here](), so when it is launched it goes to github repo to collect the all data

Since it has started the app is accessible on http://localhost:8888

## chatty-service-discovery

This is the Chatty service discovery solution, you can reed about this pattern [here](http://microservices.io/patterns/server-side-discovery.html). It uses [Netflix Eureka](https://github.com/Netflix/eureka).

When the app has started it make a call to chatty-server-config to retrieve its settings








