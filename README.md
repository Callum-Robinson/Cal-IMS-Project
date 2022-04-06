### Jira Roadmap of the Completed Sprint
https://callumjrobinson.atlassian.net/jira/software/projects/IP/boards/2/roadmap


# IMS Project

In this project a functional inventory management system was created with CRUD functionality for customers, items and orders. This used all technologies and modules covered to this point in the software specialist course. The documentation folder contains the ERD diagram of the database tables, the UML class diagram of the application, the risk assessment matrix for the project and the pdf presentation for this project.

## Getting the Application Running and Tested

### Prerequisites

What you will need beforehand

```
- MySQL instance and the connection information and login like shown:
```
![image](https://user-images.githubusercontent.com/100779521/161999773-fc4cde20-217d-490a-8378-f3d50c98f9db.png)

```
- Java Runtime Environment will be needed to run the .jar file
```

```
- A bash terminal
```

### Installing

To run the application you need to:

```
- Clone a copy of this project 
```

```
- Update the src/main/resources/db.properties with the local MySQL instance you created
```

```
- From where the fat.jar is saved use the following in a bash terminal: java -jar ims-0.0.1-jar-with-dependencies.jar
```

## Running the tests

```
- Simply use Maven with 'mvn test' to run all unit tests in the application
```

```
- Coverage: 62.4%
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Callum Robinson** - [Callum-Robinson](https://github.com/Callum-Robinson)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* The template for this project: [IMS-Starter](https://github.com/JHarry444/IMS-Starter)
* Morgan Walsh for the support during the project
* Jamie-lee MacAskill for her constant support
