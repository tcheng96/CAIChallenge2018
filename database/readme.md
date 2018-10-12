# IBM CAI Challenge 2018 - Database Migration Starter
This is the starter app to help you manage your Postgres database migrations using Flyway.

Database migrations are the series of scripts that create, modify, delete, and otherwise affect objects in your database.

This starter gives you easy to use tools to get started managing your database for the challenge and a 'Hello, World!' example.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Code Structure
* `flyway.conf` contains the Flyway configuration settings
* `sql` contains the sql-based database migration scripts. The convention is that they are versioned such that V1_5_name_of_the_script.sql would be Version 1.5. Flyway parses these filenames very strictly. 

### Prerequisites
You will need Flyway for this starter. Download it from https://flywaydb.org/. 

### Creating a database
First, you need to create a database for your application. 

Make sure you have the IBM Cloud CLI installed. If you need to install it check here: https://console.bluemix.net/docs/cli/index.html#overview

Run this command to check you have the tools installed. If you saw a version number then you are ready to proceed!
```
ibmcloud --version
```

Log in to the IBM Cloud CLI
```
ibmcloud login -a https://api.ng.bluemix.net
```

Target your CLI session for cloud foundry and resource groups
```
ibmcloud target --cf
ibmcloud target -g cai-challenge
```

Before proceeding, here is how to find help
```
ibmcloud help
```

Create a database. Use your first initial + lastname-pgsql for YOUR_DATABASE_NAME ie jdoe-pgsql
```
ibmcloud resource service-instance-create *YOUR_DATABASE_NAME* databases-for-postgresql standard us-south
```

Check your database creation process. Once state = 'active' then proceed. This can take a while, so start thinking about your user stories and code. Check back on this periodically. 
```
ibmcloud resource service-instances
```

Create a service alias so your database can be used in cloud foundry
```
ibmcloud resource service-alias-create *YOUR_DATABASE_NAME* --instance-name *YOUR_DATABASE_NAME*
```

Verify your database is available in cloud foundry
```
ibmcloud cf services
```

Bind your database service to your application. This creates credentials and connection information for you to use. 
```
ibmcloud cf bind-service cai-challenge *YOUR_DATABASE_NAME*
```

You'll need to restage (aka restart) your application to pick up the new database credentials provided as environment variables. 
```
ibmcloud cf restage cai-challenge
```

Find out your app's database connection information. It is stored in the VCAP_SERVICES environment variable for your app. 
```
ibmcloud cf env cai-challenge
```
### Using Flyway
You should first have set up your database in IBM Cloud with the preceeding commands and make sure you have flyway installed.

Check if flyway is installed. If you get version number then flyway is ready.
```
flyway -v
```

Get your database host name, port number, database name, username, and password from the VCAP_SERVICES environment variable. You'll use these in the next step.
```
ibmcloud cf env cai-challenge
```

Edit flyway.conf and replace these variables with your actual values from the previous step. `flyway.conf` now has your secret password in it - make sure you don't check that into GitHub!
```
flyway.url=jdbc:postgresql://$HOSTNAME:$PORT/$DBNAME?sslmode=require
flyway.user=$USERNAME
flyway.password=$PASSWORD
```

Flyway should now be configured. Lets test it. 

Change directory to the database folder. This is where flyway commands should be executed from.
```
cd database
```

Let flyway report its status.
```
flyway info
```

You should see something like





```
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