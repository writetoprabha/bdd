<h2>Behavior Driven Development - Cucumber Automation Framework using Selenium </h2>

<h4>Jars Used: </h4>
<li>cucumber-java - For BDD Cucumber basic features</li>
<li>cucumber-core - For BDD Cucumber basic features</li>
<li>cucumber-picocontainer - For sharing state between steps in Cucumber - JVM </li>
<li>extentreports - For reporting</li>
<li>assertj-core - For Assertions</li>
<li>commons-io - For File streaming - when generating  & when reading properties</li>

<h4>ExtentManager.java:</h4> 
Path: src/main/java/com/seleniumcucumber/reports

<h4>WebConnector.java: </h4>
Path: src/main/java/com/seleniumcucumber/webdriver
<li>The WebConnector.java class contains all the common & core functions that can be accessed across different classes in the framework</li>
<li>Its constructor creates the driver object and can be accessed by StepDefinitions using PICO container (Sharing states)</li>
<li>It reads the property files (project.properties and runTest.properties) and stores the values in the public objects projectProperties and  runTestProperties</li>
<li>project.properties contains contains the webelement specifications (xpath/css)</li>
<li>runTest.properties file contains test configurations like  environment, browser etc</li>
<li>It also has the basic re-usable functions that can be shared across all the StepDefinitions</li>

<h4>GenericSteps.java </h4>
Path: src/test/java/com/seleniumcucumber/steps

<li>The GenericSteps.java class contains all the generic step definition functions for basic operations like clicking, entering text etc.,</li>
<li>It uses the @Before annotation of Cucumber api for calling the WebConnector class's initializeReports method so that report will be initialized before the start of test execution</li>
<li>It uses the @After annotation of Cucumber api to quit the driver, flushing logs after the test execution is complete</li>
<li>The below code in this class implements the PICO container</li>

    WebConnector connector;    //Uses Pico container. For every scenario, the pico container object gets created and the created object is assigned to connector object.
    public GenericSteps(WebConnector connector){
        this.connector = connector;
    }

<li>We can add any number of project specific step definition classes like this by implementing pico container in similar way</li>
<h4>MyRunner.java</h4>
Path: src/test/java/com/seleniumcucumber/
<li>it is the runner class of cucumber which defines the cucumber options</li>

<h4>Future Enhancements</h4>
<li>Use page object model - page factory to define the objects</li>
<li>Add build.xml (Ant) file to implement Continuous Integration</li>
<li>Add functions and step defenitions to support REST API validations</li>
<li>Collect all the run time properties from command prompt to run the framework</li>