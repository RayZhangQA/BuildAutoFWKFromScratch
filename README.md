Udemy - Selenium WebDriver with Java - Basic to Advanced + Frameworks

Section: Framework Building from Scratch - Real Time Project

# Building Framework From Scratch

##### 1. Creating of Maven Project

##### 2. Creating Base and Utility Functions

##### 3. Organize Page Objects

##### 4. Adding Tests
	
##### 5. Data Driving and Parameterizing Tests

##### 6. Converting into TestNG Framework

##### 7. TestNG Listeners

##### 8. Screenshot on Test Failures

##### 9. Creating Excellent HTML reports for Test Results
	
##### 10. Jenkins - Continuous Integration



# Creation of Maven Project

##### 1. Create a Maven Project

		>cd <eclipse-workspace>
		>mvn archetype:generate -DgroupId=Academy -DartifactId=E2EProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

##### 2. Compatible with Eclipse

		>cd <root directory of the new project>
		>mvn eclipse:eclipse

##### 3. Import the project to Eclipse

* Open Eclipse
* Files ==> Import... 
* Select ==> Maven//Existing Maven Project ==> Next
* Maven Projects ==> Browse ==> Project Root Folder ==> Select Folder ==> Finish
* The project will be imported into Eclipse shortly.

>* src/test/java - All the test cases created here
>* src/main/java - All the utilities, base objects, data and etc.
>* pom.xml - the maven configure file

##### 4. Add All Dependencies and Plugins to pom.xml

* Selenium Dependency ==> search "Selenium Maven Information"

		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>
	
* TestNG Dependency ==> search "TestNG Maven Dependency"

		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.8</version>
			<scope>test</scope>
		</dependency>

* Save "pom.xml" will get all the dependencies added to the project local repository.
	

# Creating Base and Utility Functions

##### 1. Create base java class in src/main/java

##### 2. Create public void initializeDriver() method

##### 3. java.lang.NullPointerException
if (browserName == "chrome") - wrong. shouldn't use "==".

extract the value from property file, need use browserName.equalsTo("String");

* == is a reference comparison, i.e. both objects point to the same memory location
* .equals() evaluates to the comparison of values in the objects

##### 4. data.properties
* each line ended without semicolon otherwise will cause the problem.

# Creation page objects

##### 1. Create base java class in src/main/java

##### 2. Create public void initializeDriver() method

##### 3. java.lang.NullPointerException
if (browserName == "chrome") - wrong. shouldn't use "==".

extract the value from property file, need use browserName.equalsTo("String");

* == is a reference comparison, i.e. both objects point to the same memory location
* .equals() evaluates to the comparison of values in the objects
* 
* need give the live of driver in LandingPage class

		public WebDriver driver;
		public LandingPage(WebDriver driver) {
			this.driver = driver;
		}
	

##### 4. data.properties
* each line ended without semicolon otherwise will cause the problem.

##### 5. TestNG maven integration
* Right click the Project-Name ==> TestNG ==> Convert to TestNG
* "testng.xml" file will be created.
* Right click "testng.xml" ==> Run As ==> TestNG Suite
* Running as mvn project from command line

		>cd <project root directory>
		>mvn compile
		>mvn test

##### 6. Integrate Log4j to Maven build
* Search log4j maven dependency
* Append the dependency to pom.xml
* Check if Project//Build Automatically is selected.
* Add resource folder of "log4j.xml" to "pom.xml" file

	<resources>
			<resource>
				<directory>src/main/recources</directory>
				<filtering>true</filtering>
		</resource>
	<resources>
	
* Add the source file to java build path - otherwise the system does not know where to find the log4j2.xml configuration file.2
* right click project ==> Build Path ==> Configure Build Path... ==> Java Build Path//Source Folde

##### 7. Fix the framework issues by tweaking TestNG configuration file.
* The 1st and 2nd windows are not closed before the 3rd window opens. They all closed after the tests are completed.
* This is because the TestNG configured the 3 classes inside 1 test. 
* Define each class under 1 set of the test to avoid the windows closing issue. 
* put "driver = null;" after driver.close(); -- release the memory.
* Change the driver initialize to static that has more advantages. 

##### 8. Screenshot on Failure - TestNG Listeners
* Add Apache commons-io maven dependency to pom.xml
* Add getScreenshot() method in base class
* Create a listener class and implements ITestListener
* Invoke getScreenshot() in Failed Listener.
* Configure testng.xml - adding the listener.

			<listeners>
				<listener class-name="Academy.Listeners"/>
			</listeners> 

##### 9. Excellent HTML Reports on Test Execution - Extent - Report API & Dashboard
* Get the dependency of "extentreports" and add it to pom.xml
* Get the ExtentReporterNG.java class to be added to the project
* Add ExtentReporterNG as a listener.

##### 10. Integrate the project to Jenkins CI tool
* Jenkins installation
* http://localhost:8080/ - Jenkins console
* Jenkins ==> Manage Jenkins ==> Global Tool Configuration

>* JDK setup
>* GIT setup
>* Maven setup

* New Item ==> Enter"E2EProject" ==> General ==> Advanced ==> Use custom workspace
* Build ==> Add build step ==> Invoke top-level Maven targets ==> put the mvn command to the Goals
* Optional - Build Triggers ==> Build periodically

##### 11. Parameterize Jenkins Build with different browsers execution

##### 12. Coding Standards - Private locators & Public methods to achieving Encapsulation 
* OOPS Principle Framework

##### 13. Remove hard coded Paths from everywhere in the Project

##### 14. Achieve Chrome Headless Execution Mechanism

##### 15. How Inheritance is achieved in Framework

##### 16. Where are Interfaces used in the framework

##### 17. Can there be multiple @Test methods in one single class? What changes needed in Testng.xml file to club multiple @Test methods into one single Test Tag.

##### 18. Can driver be static without initializing it form every Test?



##### 19. Enhancement
* Add the timestamp to the screenshot file.
* Add the webdrivers to resources folder and change the path to dynamic path

* 
