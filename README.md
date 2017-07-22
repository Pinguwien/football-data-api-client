# Football Data API Client

[![Build Status](https://travis-ci.org/michaelruocco/football-data-api-client.svg?branch=master)](https://travis-ci.org/michaelruocco/football-data-api-client)
[![Coverage Status](https://coveralls.io/repos/github/michaelruocco/football-data-api-client/badge.svg?branch=master)](https://coveralls.io/github/michaelruocco/football-data-api-client?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8c2e0f78473547eab2ff8ea2e2abd857)](https://www.codacy.com/app/michaelruocco/football-data-api-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/football-data-api-client&amp;utm_campaign=Badge_Grade)

This library provides an abstraction layer around the Football Data API described
[here](http://www.football-data.org/index), full documentation for the API is
available [here](http://www.football-data.org/documentation). The library aims to
map to the API resource and model names as closely as possible. You can make use
of it without providing an API key, or you can register for a key and pass
that into the client either directly in your program, or by providing a Java system
property called footballDataApiKey.

## Usage

To use the library from a program you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile group: 'com.github.michaelruocco', name: 'football-data-api-client', version: '0.0.1'
}
```

## Running the tests

This project is covered by both unit tests and integration tests. The
integration tests make use of docker, so you will need to have a docker
daemon running on your machine for them to work.

The integration tests also take around 2 or 3 minutes to run, this is
why they have been split out from the unit tests so each set of tests
can be run independently.

Note - For the integration tests to run you must set an environment variable of
FOOTBALL_DATA_API_TOKEN={your-api-token}.

### Running the unit tests

To run just the unit tests you can run the command:

```
gradlew clean build -x integrationTest
```

### Running the integration tests

The integration tests make use of docker, so you will need to have a docker
daemon running on your machine for them to work.

Note - For the integration tests to run you must set an environment variable of
FOOTBALL_DATA_API_TOKEN={your-api-token}.

To run just the integration tests you can run the command:

```
gradlew clean build -x test
```

### Running all the tests

Finally to run all the integration tests you can run the command:

```
gradlew clean build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```