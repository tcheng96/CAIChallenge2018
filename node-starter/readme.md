# IBM CAI Challenge 2018 - Node.js Starter Application
This is the starter app based on Node.js and Express w/ Pug view engine.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Code Structure
* Views are based on the Pug view engine. Located in the `views` folder
* Routes control what view will be used to render a page or otherwise respond to a request. Located in the `routes` folder.
* Static assets like css, client side javascript, and images are in the `public` folder
* `bin/www` is the webserver script and is the entry point to the application
* `app.js` is the Express configuration script which loads routes into the server

### Prerequisites
You will need node.js and npm for this starter. Download it from https://nodejs.org/en/download/current/. 

### Running Locally
From the node-starter directory in a terminal, run these commands. 
```
cd node-starter # make sure you are in this directory
```

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

### Integrated Development Environment
While the above commands will run the application for you locally, you really should use tools to be more productive. For node, you can use VS Code. Download and install VS Code and the Nodejs Development pack from https://marketplace.visualstudio.com/items?itemName=nodesource.vscode-for-node-js-development-pack.

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
Change the `node-starter` directory if you're not already there.
```
cd node-starter
```
Deploy your application. Use this same command to redeploy whenever you want. This command reads the `manifest.yml` file from the current directory to make the deployment. 
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