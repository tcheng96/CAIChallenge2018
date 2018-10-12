# IBM CAI Challenge 2018 - Node.js Starter Application
This is the starter app based on Node.js and Express.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Code Structure
* Views are based on the pug view engine. Located in the `views` folder
* Routes are control what view will be used to render a page or otherwise respond to a request. Located in the `routes` folder. 
* Static assets like css, client side javascript, and images are in the `public` folder
* `bin/www` is the webserver script and is the entry point to the application
* `app.js` is the Express configuration script which loads routes into the server

### Prerequisites
You will need node.js and npm for this starter. Download it from https://nodejs.org/en/download/current/. 

### Running Locally
From the node-starter directory in a terminal, run these commands. 

Install dependencies
```
npm install
```
Run the application
```
npm start
```
You can access the application in your browser at
```
localhost:3000
```

Typically you should develop a bit of code locally, test it, and then push it to the cloud, and repeat. 

## Deploying to IBM Cloud
Deployments to IBM Cloud are defined by the manifest.yml file. You can modify it if you want but it will work out of the box. See https://docs.cloudfoundry.org/devguide/deploy-apps/manifest.html.

Run this from the node-starter directory to deploy your app. Use the same command to redeploy your app as you make changes and want to push them to the cloud. 
```
ibmcloud cf push
```

The manifest creates a random route for you which will be shown in your terminal. YOu can access your app running in the cloud at that route. 

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