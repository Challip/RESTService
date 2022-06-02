# RESTService

Service Oriented Architecture principles in software applications integration


utilize web services to create a distributed serviceoriented system for advertising and searching for travel opportunities. 
The Service Orchestrator connects to two external REST services for generating a unique user ID and for getting the weather forecast for a specified location. 
It also connects to a message queuing system to publish and consume messages from other users.

The service orchestrator is implemented as a REST service running on the local Tomcat/Glassfish server.
The service allow clients to perform a series of actions like: generate unique user IDs, query for new messages, and to submit messages (for new trip
proposals and for trip interest). 
These is exposed as REST methods for external clients to consume.

The service connectes to the messaging system (RabbitMQ) to relay user actions as messages.
The messages sent as REST calls by clients will be published/consumed by the REST service to/from the message queues. 
All communication is done in JSON.

Web service composition -  Integrate external REST services
