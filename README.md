camel-cometd-demo
=================

Simple example project that demonstrates using Apache Camel to receive JMS and then publish the messages to a CometD channel, where they are picked up by a web browser(s).

On the Web
==========

Featured on DZone Javalobby
 - http://java.dzone.com/articles/cometd-and-camel-enterprise

And on my blog
 - http://corsoftlimited.blogspot.co.uk/2013/04/apache-camel-jms-and-cometd-oh-my.html


Prerequisites
=============
 - You need Java (JDK) and Maven installed and configured
 

What it does
============

This single demo project will open 3 windows (2 terminals and a browser):
 - Terminal window - running an ActiveMQ\Camel server - with a CometD producer
 - Web page window - consumes messages from the CometD producer when they become available
 - Terminal window - running Java client app - which will fire JMS messages at the Camel server

Running the demo end to end you will see the java app sending messages to ActiveMQ, the Camel route on the ActiveMQ server will pick up the messages and push them to the CometD channel. The web page will pick them up from the CometD channel and display them as they arrive.


Running the Demo
================

1. Open a terminal window and navigate to the project root directory ${ProjectHome}.


2. Type 'mvn clean install' to check it builds ok
	- If you have any problems here - check your maven and java installations are ok
	

3. Type 'mvn camel:run'
	- This will spin up the ActiveMQ server - on localhost:61616
	- The ActiveMQ server is running Camel, which has a CometD route configured to publish on channel 'cometd://0.0.0.0:9099/broadcastMessageChannel'
	- We now need to start up a CometD consumer on this channel....


4. Open the 'comet-test.html' web page in a browser
	- this is in ${ProjectHome}/src/main/resources/html/comet-test.html
	- this is now consuming on the CometD channel
	

5. Open a second new terminal window and navigate to the project root directory ${ProjectHome}
	- Type 'mvn exec:java'
	- This will run a simulation program which will fire JMS messages at the ActiveMQ server
	- All being well - you should see them flash up on the comet-test.html page!
	

