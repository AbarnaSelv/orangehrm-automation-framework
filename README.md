# OrangeHRM Advanced Automation Framework

## Project Overview

This project is an **advanced data-driven automation testing framework** built for the **OrangeHRM open-source demo application**.

It focuses on automating **end-to-end HRMS workflows**, including **login** and **employee management (PIM module)**, based on real-world scenarios commonly handled in enterprise automation projects.

The framework is implemented using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, and **TestNG**, and follows the **Page Object Model (POM)** to ensure clean structure, maintainability, and scalability.  
It also supports **cross-browser execution**, **Excel-based data-driven testing**, and **CI/CD integration using Jenkins** for continuous automation execution.

---

## Features

- Login automation using valid and invalid credentials  
- Add Employee automation under the PIM module with dynamic Employee ID validation  
- Data-driven testing using Excel and Cucumber Scenario Outlines  
- BDD implementation with Cucumber for readable test scenarios  
- Cross-browser execution on Chrome, Edge, and Firefox  
- Advanced reporting using Cucumber HTML reports and TestNG reports  
- Hooks for pre and post conditions, including screenshot capture on failure  
- Jenkins CI/CD integration for automated build and test execution  

---

## Tech Stack

- **Language**: Java 17  
- **Build Tool**: Maven  
- **Test Runner**: TestNG  
- **Automation Tool**: Selenium WebDriver  
- **BDD Tool**: Cucumber  
- **Design Pattern**: Page Object Model (POM)  
- **Data Handling**: Excel using Apache POI  
- **CI/CD**: Jenkins  
- **Reports**: Cucumber HTML Reports, TestNG Reports  

---

## 📂 Project Structure
- src/main/java/com/automation/framework
  - drivers → DriverFactory (browser initialization)
  - pages → Page Objects (LoginPage, PIMPage, etc.)
  - utils → ConfigReader, ExcelReader, etc.

- src/main/resources
  - config.properties → project configuration

- src/test/java/com/automation/framework
  - steps → Step Definitions
  - hooks → Cucumber Hooks
  - runners → TestNG/Cucumber Runner classes

- src/test/resources/features
  - login.feature
  - add_employee.feature
  - add_employees_from_excel.feature

- pom.xml → Maven dependencies
- README.md → Project documentation

---

## Jenkins Integration

The project has been integrated with Jenkins for Continuous Integration. The latest build ran successfully:


![Jenkins Build Status](https://drive.google.com/uc?export=view&id=1F6NbiGVfiu_uK3zuK4KOVpgMN2SRVY8M)

You can also view the Jenkins job here:  
[Jenkins Job Link](http://localhost:8080/job/Selenium-Maven-CI-CD/)

---

## Execution Video  
[Click here to watch the execution video](https://drive.google.com/file/d/16kH-SRCMYlqkKMYVl-wklua5_0RjrSjK/view?usp=sharing )  

---

## Execution Screenshots  
Execution screenshots are included inside the repository under the `Project_Demo/` folder.  

---

## Summary

This framework represents a **professional-level Selenium automation setup** suitable for enterprise applications.  
It combines **BDD**, **data-driven testing**, **cross-browser support**, and **CI/CD integration**, making it a strong example of scalable and maintainable automation design.

The project is structured to closely reflect real-time automation practices used in modern QA teams.

---

## Setup & Execution

### Prerequisites
- Install Java 17+
- Install Maven 3.9+
- Install Git
- Install Chrome/Edge/Firefox browsers

### Run Tests (Locally)
mvn clean test

### Run Specific Tags
mvn test -Dcucumber.filter.tags="@Login"
mvn test -Dcucumber.filter.tags="@PIM"

---

## Reports
- Cucumber Reports → target/cucumber-reports/index.html
- TestNG Reports → target/surefire-reports/index.html

---

## Jenkins Integration
1. Install Jenkins and configure:
   - JDK
   - Maven
   - Git

2. Create a Jenkins Job → Pull code from GitHub

3. Add Build Step:
   mvn clean test

4. Configure HTML Publisher Plugin to show Cucumber reports.

5. Run job → View results inside Jenkins.

---

