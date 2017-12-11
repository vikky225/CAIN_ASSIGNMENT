# GCDRestFullWebService
This is a Restful service for inserting GCD values in RabbitMQ and to DB and fetching details as well

Two services being used or exposed are below 


PreRequisuite 
Rabbit MQS in windows is installed 
Once service is up and running. 

Message in Queue which got published could be seen as below
http://localhost:15672/#/queues
use default username password i.e. guest guest for login 

Configuration is given in Application.properties to be used for Rabbit MQ 
for exchange (need to create exchange, Queues and respective bindings)


H2 in memory database is being used 
to see database go to below url
http://localhost:8080/console
Configuration is given in Application.properties to be used for DataBase



Another better approch could have been connected with production DB hosted over cloud (Azure/Aws) or locally set mysql or sqlserver

Basic security prompt is provisioned
username vikas
password password


Hypermedia 

HAL Browser for (Spring Data Rest ) for convenincince has been provisioned to see the details go in below link
http://localhost:8080/
All the properties, link, explorer request rensponse option can be explored in provisioned UI. 

For testing URL

To create Database entry and publishing to Rabbit MQ

Poat request with JSON Body : 

http://localhost:8080/gcds/

{
firstOperand : 34
secondOpernad : 55
}

To see in DB just go to table GCD and run below
Select * from GCD

To Fetch the list (Get Request)
http://localhost:8080/gcds/gcdList



