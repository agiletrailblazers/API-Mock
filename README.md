#  PoC Mock API
This is a mock API built for use by PoCs

## Core Application Technologies
* Java 8.x.x
* Spring 4.x.x
* Apache Tomcat 8.x.x
* Apache Maven 3.x.x

## Installation
1. Download and install Maven
2. Clone the remote repository to your local development directory
3. Change directories to the root application directory: `cd {your-dev-dir}/{project-dir}`

## Apache Tomcat Configuration
Required configuration to specify which environment configuration should be used
    * Dev:  `-DpropertiesLoc=/properties/dev`
    * Test: `-DpropertiesLoc=/properties/test`

## Building the Application
The application is built using Maven.  

`mvn clean install`
