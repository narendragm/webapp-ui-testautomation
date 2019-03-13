"# webapp-ui-testautomation"

Automation Project Name: webapp-ui-testautomation
GitHubLocation: https://github.com/narendragm

Development Environment Used:
1) IDE- IntelliJ IDE
2) Operating System- OS Windows 7
3) Coding Language & Support- JDK Java Version 1.8.0_202

Please read README.md file carefully to clone and run the project to local computer
To clone project on local computer from command line:
1) Open command line terminal
2) Move to desired directory where you want to clone project
3) Run command -
https://github.com/narendragm/webapp-ui-testautomation.git
(this should clone project on local computer)

This automation project showcase:
1) Web UI  Test Automation Framework
2) How to maintain various project files like Java Test, Util, Config, Properties, Reporting, Listener, etc.
(Not the only way but one of the to maintain project)
3) How we can write tests and test support utilities

About tests and test artifacts:
1) POM includes dependency
(I) Selenium  - 3.141.59
(II)Chrome Browser - Version 72.0.3626.121 (Official Build) (64-bit)
(III) TestNG - 6.10
1) Automation tests written for test shopping site
2) Test performs Login to site, Product Selection And Adding selected products to Cart
3) All the tests performs Page Specific Actions, Page specific WebElement verification, Page specific assertions
4) wherever possible for all tests and support file comments are added to provide more clarity on purpose, what the test, utils, etc.. are doing
5) Test report generated for the test run at -
.. \Webapp-UI-TestAutomation\src\test\resources\testreports\ExtentReportResults.html (Please check this beutiful report)

Instructions to run the project:
1) Open the cloned project in IDE like IntelliJ/Eclipse IDE (I am using IntelliJ)
2) Let the project download all the dependencies, perform other project building tasks
3) Once project in IDE, Right click on “testng.xml” file located as follows and run tests
..\ Webapp-UI-TestAutomation\src\test\resources\testng.xml
By default test will run on Chrome browser
4) Alternatively you can open test classes located as follows and run individual test inside the test class
.. \Webapp-UI-TestAutomation\src\test\java\com\test\automation\testcases\loginpage\LoginPageTests.java
.. \Webapp-UI-TestAutomation\src\test\java\com\test\automation\testcases\productpage\ProductPageTests.java
….\ Webapp-UI-TestAutomation\src\test\java\com\test\automation\testcases\cartpage\CartPageTests.java
5) Open terminal and navigate to project folder for this project and run command
mvn clean install (you should have Maven set up on your machine)
Check TestNG emailable report at
..Webapp-UI-TestAutomation\target\surefire-reports\emailable-report.html

Note: In case on Mac OS if you face issue with Chromedriver, please download Chromedriver for Mac,
And add driver to following location and try to run tests again
..\Webapp-UI-TestAutomation\drivers
