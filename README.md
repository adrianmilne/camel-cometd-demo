camel-demo-file-and-freemarker
==============================

Simple example project that demonstrates using Camel to listen for a new file arriving, then extracting metadata from the file and using Freemarker to insert that into a template.


Setup
=====

This demo was initially set up on windows. It can run on any environment - but needs to following config setting up for your system before running (in application-camel-context.xml):

c:/data/in/
c:/data/tmp/


Running the Demo
================

1. Download project

2. Create directory structure outlined above (to use a different structure - update application-camel-context.xml)

3. In a terminal window - cd to the root directory (where pom.xml is) - type 'mvn camel:run'. This will start up an instance of camel/activemq.

4. Drop a file into 'c:/data/in' directory. What will happen is:

	- File is moved to c:/data/tmp directory
	- The filename is extracted, and merged into the Freemarker template (which produces XML)
	- A JMS Object Message is created containing this XML, and placed onto the OutputQueue
	
5. Camel tracing is enabled so you will be able to view all the properties passes around by Camel. 

6. This demo could be extended to add a Queue Listener to pick the message from the queue (see the https://github.com/corsoft/esper-demo-nuclear demo for an example of how to do this).


