# FlitzeTrucks

___An app to help trucks send their current geo location to server and view all the trucks.___

## Features
- Get all the trucks.
- Filter trucks by their status.
- Send current geo location for the truck to server.


## Demo
![app-demo](truck.gif)

## Setup

Below instructions will help you get started with the application and run in local system.

1. Install following on your local machine
  -[Git](https://git-scm.com)
  -[Node.js](https://nodejs.org/en/download/) (which comes with [npm](http://npmjs.com))
  -[Java](https://www.oracle.com/java/technologies/downloads/)
  -[Maven](https://maven.apache.org/download.cgi)
2. Clone the repository by running this following command
	```bash
	git clone https://github.com/hamzicio/FlitzeTrucks 
	```
  
3. Start backend  by running following commands
	```bash
	cd FlitzeTrucks/backend
   mvn org.springframework.boot:spring-boot-maven-plugin:run
 
		
	# This will install dependencies and start backend server at port 8080 , in case your port is already allocated please change port inside application.properties file.
	```
  
4. Start frontend  by running following commands
	```bash
	cd FlitzeTrucks/frontend/
	npm install
		
	# once node_modules gets install, run next command
	npm start
	```
5. Once your app is running, you can access it on the following address in your browser
	[http://localhost:3000](http://localhost:3000)

## Versions
Following versions are being used while creating this guide. 
```
java@17.0.x or higher
git@2.x.x or higher
node@v18.x.x or higher
npm@10.x.x or higher
maven@3.6.x or higher
```

## Branches
Current branches and their purposes are as follow.
```
main -> contains latest changes
```

## Assumptions
```
By default when backend is started , 5 trucks are seeded using sql file.
I have assumed that we already have a list of trucks and the truck drivers just need to select the particular truck and update the status/location.
```

## Futher enhancements
```
1) Due to limited time , authentication mechanism could have been added
2) The truck entries could have been saved into db and this would allow creation of new entries
3) Better test cases for Backend as well as new cases for frontend could have been written
4) Project could have been dockerized for single point of startup
5) Better design for the frontend could have been achieved
```
