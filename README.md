# JavaSeleniumProjectSkillo

Automated test project on the site:
http://training.skillo-bg.com:4300/posts/all

## Technologies
- Java 24
- Maven
- Selenium WebDriver
- TestNG
- Page Object Model + PageFactory
- WebDriverManager

## Structure
- core – base classes (DriverFactory, BaseTest)
- pages – Page Object models
- listeners – TestNG listener for screenshots when fail
- tests – TestNG tests
- testng.xml – TestNG suite
- screenshots – images when test failed

## Test scenarios

1. Successful login
2. Unsuccessful login → error
3. Checking for posts
4. Open post details
5. Like increase 
6. Open profile
7. Successful logout


## Start
Run → testng.xml