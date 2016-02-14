# Weather Report

##About
The job of this weather report tool is to get the weather status at a scheduled interval or on demand from the WUndergroung API in order to display it on the Miorror Display project.  

##Compiling from Source
This project depends on Java as well as Maven for compiling, once you have those installed and configured it is extremely easy.

1. Clone the repository.
2. In a console window cd into the WeatherReport directory.
3. run the command `mvn clean install`.
4. Copy the lib directory from WeatherReport/target as well as the WeatherReport-<VERSION>.jar to where ever you want to run it.
5. Copy the sample.properties to the same location and modify it to fit your network.

##Running

1. Either download a binary from the releases or follow the compiling instructions
2. Using the provided sample.properties make your own properties file to fit your use case.
3. To start up (assuming java is in your PATH environment variable) run `java -jar WeatherReport-<VERSION>.jar myProperties.properties` where myProperties.properties is the name of the properties file you created in step 2.

##Plans
* Add severe weather alerts when they exist.
* Create automation for installation in either Ansible or Puppet.
* Expose more config options around where the messages go in RabbitMQ?