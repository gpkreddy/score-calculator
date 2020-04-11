# Score Calculator

This is a utility Program which calculates scores for the file name that has been passed. If no file is specified at runtime, program defaults to a sample file to run the execution.

## Instructions to dev

* Install Java8 or later
* Install latest maven (recommended 3.6 or later)
* choice of your IDE (Eclipse/STS, Intellij, code) or a terminal to run the program

### Command Line instructions to run the program
* Navige to the code directory where it was cloned in your favourite terminal
* run the below commands to get the clean executable/jar and run the program
  * mvn clean
  * mvn package
  * java -jar .\target\score-calculator-0.0.1-SNAPSHOT.jar <supply the file path or leave empty to use the sample file>
* Alternativey, you could use your favourite IDE to run the application


## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
