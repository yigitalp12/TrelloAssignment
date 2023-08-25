# Trello.com UI and API Testing Assignment

## Introduction

This repository showcases the implementation of UI and API tests for Trello.com for set of features including CRUD operations mainly for Board functionalities. The testing strategies include utilizing Behavior-Driven Development (BDD) principles, Selenium framework in Java, Rest-Assured framework and appropriate design patterns like the Page Object Pattern for UI testing.

## Table of Contents

- [Setup](#setup)
- [UI Testing](#ui-testing)
    - [Page Object Pattern](#page-object-pattern)
    - [BDD with Cucumber](#bdd-with-cucumber)
- [API Testing](#api-testing)
    - [BDD with Cucumber](#bdd-with-cucumber-for-api)
    - [Testing Framework](#testing-framework)
- [Reporting](#reporting)


## Setup

1. Clone this repository to your local machine.
2. Utilize Maven for dependency management. Run `mvn install` to fetch the required dependencies.
3. For running the both API and UI suites, `mvn test` can be executed via Terminal under the root folder of the project.
   3.1. For running separately,  `mvn test -Dtest=TestRunnerForAPITests` and `mvn test -Dtest=TestRunnerForUITests` commands can be executed. 

5. If any issue exists with ChromeDriver while executing the tests, under the folder of Drivers, executing following command `xattr -d com.apple.quarantine chromedriver` will fix it.


## UI Testing

### Page Object Pattern

The UI tests are organized using the Page Object Pattern. This pattern promotes the separation of concerns by creating dedicated classes (Page Objects) for each page of the application. Each Page Object contains methods to interact with the elements on its corresponding page. This approach offers several benefits:

- **Modularity**: Page Objects encapsulate the interactions with UI elements. Changes to the UI can be managed within the relevant Page Object, minimizing the impact on test code.
- **Readability**: Tests become more readable and maintainable as the test code deals primarily with high-level methods from Page Objects, abstracting away the low-level details of UI elements.
- **Reusability**: Page Objects can be reused across multiple tests, avoiding code duplication and promoting a consistent interaction model.
- **Easy Updates**: When UI changes occur, modifications are localized to the affected Page Object, reducing the effort needed to update tests.

### BDD with Cucumber

The `src/test/resources/featuresUI` directory contains Gherkin feature files. These files define the test scenarios in a human-readable format. The corresponding step definitions are implemented in Java classes within the `stepdefinitions` package.

To execute UI tests, run the Cucumber tests using a specified runner class, e.g., `TestRunnerForUITests.java`, which integrates Cucumber with the test framework.

### BDD with Cucumber for API

API tests are also implemented using the BDD approach. Gherkin feature files in the `src/test/resources/featuresAPI` directory outline the API test scenarios. The corresponding step definitions are implemented in Java classes within the `api.stepdefinitions` package.

### Testing Framework

API tests are written using a suitable testing framework along with libraries like RestAssured for making API requests. The tests validate endpoint functionality, response codes, and data returned by the Trello API.

To execute UI tests, run the Cucumber tests using a specified runner class, e.g., `TestRunnerForAPITests.java`, which integrates Cucumber with the test framework.

## Test Reporting

After running the tests, the test reports are generated. These reports offer insights into the test execution results, including passed and failed scenarios. The reports are located in the `target` directory, under `cucumber-reports` after test execution.

## Test Plan

A detailed test plan can be found in the root project which explains the purpose, scope, test environment, UI and API Test Scenarios for selected functionalities, Test Execution. 




