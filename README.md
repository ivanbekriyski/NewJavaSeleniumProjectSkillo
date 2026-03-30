# JavaSeleniumProjectSkillo

Автоматизиран тестов проект върху сайта:
http://training.skillo-bg.com:4300/posts/all

## Технологии
- Java 24
- Maven
- Selenium WebDriver
- TestNG
- Page Object Model + PageFactory
- WebDriverManager

## Структура
- core – базови класове (DriverFactory, BaseTest)
- pages – Page Object модели
- listeners – TestNG listener за screenshot при fail
- tests – TestNG тестове
- testng.xml – TestNG suite
- screenshots – снимки при failed тестове

## Тестови сценарии

1. Успешен логин
2. Грешен логин → грешка
3. Проверка, че има постове
4. Отваряне на детайли на пост
5. Like увеличава броя
6. Отваряне на профил
7. Успешен логаут


## Стартиране
Run → testng.xml