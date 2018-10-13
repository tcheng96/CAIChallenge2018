# IBM CAI Challenge 2018 - Java / Spring Boot Starter Application
This is the starter app based on Java and Spring Boot. 

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Code Structure
* Views are based on the Thymeleaf view engine. Located in the `src/main/resources/templates` folder
* Routes control what view will be used to render a page or otherwise respond to a request. Located in the `src/main/java/ibm.cai.challenge.controllers` folder.
* Static assets like css, client side javascript, and images are in the `src/main/resources/static/assets` folder
* `src/main/java/ibm.cai.challenge/ChallengeApplication` is the main entry point to the application. 

### Prerequisites
You will need Java and Maven for this project. 

### Running Locally
From the java-starter directory in a terminal, run these commands. 
```
cd java-starter # make sure you are in this directory
```

Build & package
```
./mvnw package
```
Run the application
```
java -jar target/challenge-0.0.1-SNAPSHOT.jar
```
You can access the application in your browser at
```
localhost:8080
```

Typically you should develop a bit of code locally, test it, and then push it to the cloud, and repeat. 

### Integrated Development Environment
While the above commands will run the application for you locally, you really should use tools to be more productive. For Spring, you can use Spring Tool Suite with Eclipse, Atom, or VS Code, whichever you prefer. Download and install STS from https://spring.io/tools.

Feel free to use other tools if you prefer them.

## Deploying to IBM Cloud
Deployments to IBM Cloud are defined by the manifest.yml file. You can modify it if you want but it will work out of the box. See https://docs.cloudfoundry.org/devguide/deploy-apps/manifest.html.

First, make sure you're logged in to the CLI.
```
ibmcloud login -a https://api.ng.bluemix.net
```
The ibmcloud CLI needs to be properly targeted.
```
ibmcloud target --cf
ibmcloud target -g cai-challenge
```
Change the `java-starter` directory if you're not already there.
```
cd java-starter
```

Build your jar file
```
./mvwn package
```

Deploy your application. Use this same command to redeploy whenever you want. This command reads the `manifest.yml` file from the current directory to make the deployment. Make sure your jar file has been built w/ your updates when redeploying.
```
ibmcloud cf push
```
If you get an error message like this:
```
The host is taken: cai-challenge-brash-bat
FAILED
```
Try running `cf push` again to get a new random route.

The manifest creates a random route for you which will be shown in your terminal. You can access your app running in the cloud at that route. 

View your app status
```
ibmcloud cf apps
```

View your recent logs
```
ibmcloud cf logs cai-challenge --recent
```

Tail your logs (shows additional log messages as they occur)
```
ibmcloud cf logs cai-challenge
```