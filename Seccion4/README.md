# Maven
A build automation and project management tool used primarily for Java projects. It simplifies the process fo managing a project's build lifecycle, dependencies, and other aspects of the project though a consistent structure and configuration.

Maven operates using a Project Object Model (POM) file, typically named pom.xml, which contains all the configuration details for the project.

Maven is used to:
* Simplifies project setup with a consistent directory structure.
* Handles dependency management automatically.
* Provides plugins for common tasks (e.g., testing, packaging, code analysis).
* Ensures reproducible builds across teams and environments.
* Integrates with popular IDEs like IntelliJ IDEA, Eclipse, and NetBeans.

## Project Structure
When we create a Maven project, it follows a standard directory layout:

```
my-app
│
├── src
│   ├── main
│   │   ├── java          # Application source code
│   │   └── resources     # Configuration files (e.g., application.properties)
│   └── test
│       ├── java          # Test source code
│       └── resources     # Test configuration files
│
├── pom.xml               # Maven configuration file
└── target                # Compiled output (e.g., JAR, WAR)
```

## pom.xml
The pom.xml file is the configuration file for our Maven project, where we can find an example as follows:

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>   <!-- Project group -->
    <artifactId>my-app</artifactId> <!-- Project name -->
    <version>1.0-SNAPSHOT</version> <!-- Version -->

    <dependencies>
        <!-- Example dependency: JUnit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```
Some important concepts are: 

* **groupId**: Identifies the organization or project group.
* **artifactId**: Name of the specific project or module.
* **version**: Project version.

### Effective POM
The Effective POM is the result of combining your project's `pom.xml` file with the inherited settings from parent POMs, default settings, and active profiles. It represents the complete configuration Maven uses when building our project.

## Maven Archetype
A Maven Archetype is a *template* for creating new Maven projects. It provides a predefined structure, configuration, and boilerplate code to help developers quickly set up a project without having to start from scratch.

## Maven Commands
| Command  | Description |
|----------|:-----------:|
| clean |  Cleans the project by deleting the target directory  |
| compile |  Compiles the source code  |
| test |  Runs unit tests  |
| package |  Package the compiled code into a JAR or WAR file  |
| install |  Installs the package into the local repository  |
| deploy |  Deploys the package to a remote repository  |
| dependency:tree |  Displays the dependency hierarchy  |

## Benefits
1. Dependency Management:
* Automatically downloads and resolves dependencies, saving time and effort.
2. Standardization:
* Promotes a uniform project structure, making it easier to onboard new developers.
3. Integration:
* Works with tools like Jenkins for CI/CD and popular IDEs for better development workflows.
4. Extensibility:
* Wide range of plugins for additional functionality.
5. Reproducibility:
* Ensures consistent builds across different environments.