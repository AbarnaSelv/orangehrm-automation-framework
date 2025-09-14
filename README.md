# OrangeHRM Advanced Automation Framework 🚀

## 📌 Project Overview
This project is an **advanced data-driven automation testing framework** built for **OrangeHRM** (opensource demo site).  
It demonstrates **end-to-end automation** of core HRMS features such as **login** and **employee management (PIM module)**, covering **real-world test scenarios** that align with enterprise-level test automation practices.  

The framework is implemented using **Java, Selenium WebDriver, Cucumber (BDD), and TestNG**, following the **Page Object Model (POM)** for maintainability and scalability.  
It also supports **cross-browser execution**, **data-driven testing using Excel**, and **integration with Jenkins CI/CD pipelines** for continuous testing.  

---

## 🎯 Features
- 🔹 Login Automation with valid/invalid credentials
- 🔹 Add Employee Module Automation (PIM) with dynamic Employee ID validation
- 🔹 Data-Driven Testing using Excel/Scenario Outlines
- 🔹 BDD with Cucumber – human-readable scenarios mapped to step definitions
- 🔹 Cross-Browser Execution (Chrome, Edge, Firefox)
- 🔹 Advanced Reporting with Cucumber HTML and TestNG Reports
- 🔹 Hooks for Pre/Post Conditions (screenshot on failure, driver setup/teardown)
- 🔹 CI/CD Integration with Jenkins (auto-triggered builds)

---

## 🛠️ Tech Stack
- Language: Java 17
- Build Tool: Maven
- Test Runner: TestNG
- Automation Tool: Selenium WebDriver
- BDD Tool: Cucumber
- Design Pattern: Page Object Model (POM)
- Data Handling: Excel (Apache POI)
- CI/CD: Jenkins
- Reports: Cucumber HTML Reports, TestNG Reports

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

## 🎥 Demo Video  
▶️ [Click here to watch the execution video](https://drive.google.com/file/d/16kH-SRCMYlqkKMYVl-wklua5_0RjrSjK/view?usp=sharing )  

---

## 📸 Screenshots  
Execution screenshots are included inside the repository under the `Project_Demo/` folder.  

---

## ⚙️ Setup & Execution

### 🔹 Prerequisites
- Install Java 17+
- Install Maven 3.9+
- Install Git
- Install Chrome/Edge/Firefox browsers

### 🔹 Run Tests (Locally)
mvn clean test

### 🔹 Run Specific Tags
mvn test -Dcucumber.filter.tags="@Login"
mvn test -Dcucumber.filter.tags="@PIM"

---

## 📊 Reports
- Cucumber Reports → target/cucumber-reports/index.html
- TestNG Reports → target/surefire-reports/index.html

---

## 🚀 Jenkins CI/CD Integration
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

## 🧑‍💻 Authors
- Abarna – Automation Test Engineer (Java + Selenium + Cucumber)
