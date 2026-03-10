Feature: my web feature

  Scenario: my scenario
    Given Я открываю браузер
    When Я захожу на google.com
    When Ввожу в поиск "gherkin scenario"
    When Нажимаю "мне повезет"
    Then Открывается сайт "https://cucumber.io/docs/gherkin/reference/"

  Scenario: my scenario
    Given Я открываю браузер
    When Я захожу на google.com
    When Ввожу в поиск "star wars"
    When Нажимаю "мне повезет"
    Then Открывается сайт "https://en.wikipedia.org/wiki/Star_Wars"