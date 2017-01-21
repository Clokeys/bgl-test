## 1. Framework and Setup
* IDE - I used IntelliJ to script these automation tests
* Installed Maven to build, compile and run test scripts
* Ran following Maven command from command line to create directory.

>mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## 2. Dependencies

* Junit
* Selenium Driver
* FireFox Driver
* Internet Expolorer Driver
* Chrome Dirver

## 3. Test Coverage

| Test Name  | Test Description |
| ------------- | ------------- |
| VerifyPageObjects  | Ensure that all page objects exist in Login page.  |
| VerifyLoginPageTexts  | Ensure correct texts are displayed  |
| VerifyMissingMandatoryErrMsg | Ensure correct warning message is displayed for each missing mandatory field |
| CheckDataBoundary | Verify minimum and maximum number of characters that user can enter for each field |
| CheckSpecialCharacters | Verify user can enter special characters, such as European characters and hyphen.This test also verify that user can enter double  barrel names. (European language not supported?)|
| VerifyHappyPath | Ensure page will move to next page after entering all mandatory fields |
| VerifySessionEnd | Verify that session will end after certeain period of time|


## 4. Directory
#### _ConfigData_

-List of static data such as location of web drivers and URL.

#### _UtilMethods_

-Collections of reusable functions

#### _LoginPageObjects_

-List of all page objects in Login Page

#### _LoginTestClasses_

-Collections of tests that can be executed

#### _pom.xml_

-Collection of dependencies.

![alt text](https://cloud.githubusercontent.com/assets/25242489/22154969/969c257e-df25-11e6-83fd-f799d7944147.png)
