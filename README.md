# Using Maven within the Eclipse IDE - Tutorial
The practice of creating a Maven Java Project

### 1. Using Maven with the Eclipse IDE
The Eclipse IDE provides excellent support for the Maven. This tooling is developed in the M2Eclipse project.

This tooling manages the project dependencies and updates the classpath of the project dependencies in the Eclipse IDE. It ensures that the Maven experience in Eclipse is as smooth as possible. The tooling also provides different kind of wizards import andto create new Maven based projects.

It also provides an editor for the pom.xml Maven configuration file via a structured interface. You can select the tab labeled pom.xml to edit the XML data directly.

### 2. Installation and configuration of Maven for Eclipse
#### 2.1. Install the Maven support for Eclipse (m2e)
Most Eclipse downloads include the Maven tooling already. If it is missing in your installation, you can install it via the main update of your release via Help  Install New Software. The following listing contains the update site for the Neon release and an update site maintained by the m2e project.

For the usage of Maven for Java projects, you only need the m2e component. For Java web development you also want the m2e-wtp entry.

#### 2.2. Download the Maven index
By default, the Maven tooling does not download the Maven index for the Eclipse IDE. Via the Maven index you can search for dependencies, select them and add them to your pom file. To download the index, select Windows  Preferences  Maven and enable the Download repository index updates on startup option.

After changing this setting, restart Eclipse. This triggers the download of the Maven index. You may want to remove this flag after restarting to avoid network traffic at every start of Eclipse.

### 3. Exercise: Create a new Maven enabled project via Eclipse
This exercise demonstrates the creation of a new Maven enabled project in Eclipse.

#### 3.1. Create Maven project
Create a new Maven project via File  New  Other…​  Maven  Maven Project.

On the first wizard page you can select if you want to create a simple project. In this case you skip the archetype selection. In this exercise we want to use an archetype as template for our project creation.

Press next, filter for the "quickstart" archetype and select the maven-archetype-quickstart entry. This is the classical Maven example archetype for project creation.

On the last tab enter the GAV of your project similar to the following screenshot.

#### 3.2. Run the build
Validate that the generate setup works correctly by running the build. For this right-click the pom.xml file and select Run As  Maven build.

This opens a dialog which allows to define the parameters for the start. Enter clean verify in the Goals: field and press the Run button.

#### 3.3. Adding dependencies to your project
The Eclipse Maven tooling makes adding dependencies to the classpath of your project simple. In can directly add it to your pom file, or use the Dependencies tab of the pom editor.

Switch to the Dependencies tab and press the Add button.

In this example we add Gson as dependency. For this we use the GAV which we found via the http://search.maven.org website. If the Maven index was downloaded (See [maven_eclipseinstallation_index] you can also search directly this dependency via the dialog.

#### 3.4. Use library
Change or create the App.java class in your src/main/java folder. This classes uses Gson. As Maven added it to your classpath, it should compile and you should be able to start the class via Eclipse.

### 4. Exercise: Add Maven support to a Java project in Eclipse
This exercise demonstrates how to convert a Java project to a Maven project.

#### 4.1. Create Java project
Create a new Java project called com.vogella.build.maven.simple in Eclipse.

Add one class called Main. This class should have a main method, which write "Hello Maven!" to the command line.

#### 4.2. Convert to Maven project
Select your project, right-click on it and select Configure  Convert to Maven project…​.

#### 4.3. Execute the Maven build
Right-click the pom.xml file and select Run As  Maven build.

### 5. Exercise: Create a Java web project in Eclipse using Maven
This exercise demonstrates how to create a web application in Eclipse which uses Maven. It assumes that you have already configured Eclipse for the creation of web applications.

#### 5.1. Create Maven web project project
Create a new Maven project called com.vogella.javaweb.maven.first via the File  New  Other  Maven  Maven Project entry. On the archetype selection, select the maven-archetype-webapp entry and click the Next button.

#### 5.2. Build your project
Similar to [example_eclipsemavenproject_runningthebuild] run your mvn clean verify build command from Eclipse. Validate that there are no issues with the build.

#### 5.3. Run on the server
Right-click your project and select the Run As  Run on Server menu entry.

### 6. References for Webdevelopment with Eclipse
To use Maven in Eclipse for Java web development, you should also install an configure the Eclipse web development tools (WTP). See Eclipse Web Development Tools for a tutorial.

### 7. Eclipse Maven (m2e) resources
m2e book - http://books.sonatype.com/m2eclipse-book/reference

New Maven 3.3.1 Features: Core Extensions - 
http://takari.io/2015/03/19/core-extensions.html