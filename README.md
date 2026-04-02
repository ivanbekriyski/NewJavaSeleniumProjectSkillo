# Skillo Test Automation Project
Java + Selenium WebDriver + TestNG + Page Object Model + PageFactory

## Overview
This project contains automated UI tests for the Skillo training website:  
http://training.skillo-bg.com:4300/posts/all

The goal of the project is to validate core functionalities of the platform such as user login, searching for users, liking posts, creating posts, and navigating user profiles.

The framework follows the *Page Object Model (POM)* design pattern and uses *PageFactory* for element initialization.


## Technologies Used
- Java 24
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager
- Page Object Model (POM)
- PageFactory
- TestNG Listeners (screenshots on failure)


## Project Structure

src
├── main
│    └── java
│         └── org.ivan
│              ├── core          # DriverFactory, TestListener
│              ├── pages         # Page Object Model classes 
└── test
└── java
└── org.ivan.tests     # Test classes


## Page Object Model (POM)

Each Page class includes:

- Web elements defined using *@FindBy*
- Methods that describe user actions on the page
- No assertions inside Page classes (assertions belong in the test classes)
- All waits are centralized in *BasePage*


## Automated Test Scenarios

The project includes **five or more automated test scenarios**, such as:

# ✔ Login Tests
- Successful login
- Unsuccessful login with invalid credentials

# ✔ Logout Tests
- Successful logout

# ✔ Post Tests
- Check posts on home page
- Failed test with open post details
- Like a post and check likes increases
- Add a comment and check if it is added

# ✔ Profile Tests
- Opening a user profile


## Screenshots on Failure

A TestNG Listener automatically captures screenshots on test failure.

- Screenshots are saved in the directory:  
`screenshots/`

Listener class:  
`org.ivan.core.ScreenshotListener`


## How to Run the Tests

# 1. Using IntelliJ IDEA
- Open `testng.xml`
- Click *Run*

# 2. Using Maven
mvn clean test


## testng.xml

The TestNG suite file includes:

- All test classes
- The screenshot listener
- Suite configuration


## GitHub Repository

This project is publicly available on GitHub and includes:

- Full source code
- README documentation
- testng.xml
- Page Object Model structure
- Screenshot listener