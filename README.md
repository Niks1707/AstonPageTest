
<h1 align="center">Домашняя работа по автоматизации тестирования для сайта комапнаии <a href="https://astondevs.ru/ "> ASTON </a></h1>


##  **Содержание:**

---

* [Технологии и инструменты](#технологии-и-инструменты)
* [Список проверок](#список-проверок)
* [Запуск тестов - сборка в Jenkins](#img-height25-srcmedialogojenkinssvg-width25a-запуск-тестов---сборка-в-jenkins)
* [Allure Report](#img-height25-srcmedialogoallure_reportsvg-width25a-a-nameallureaallure-report-a)
* [Уведомление в Telegram о результатах тестов](#img-altallure-height25-srcmedialogotelegramsvg-width25a-уведомление-в-telegram-о-результатах-тестов)
* [Видео прохождение тестов на Selenoid](#img-altselenoid-height25-srcmedialogoselenoidsvg-width25a-видео-прохождение-тестов-на-selenoid)

## Технологии и инструменты:

---


| Java                                                                                                                                                        | IntelliJ  <br>  Idea                                                                                                 | GitHub                                                                                                           | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         | Jenkins                                                                                                          | Telegram                                                                                                            |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"> <img src="media\logo\Java.svg" height="50" width="50"/></a>                                                                | <a href="https://www.jetbrains.com/idea/"><img height="50" src="media\logo\Intelij_IDEA.svg" width="50"/></a> | <a href="https://github.com/"><img alt="Github" height="50" src="media\logo\GitHub.svg" width="50"/></a> | <a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="media\logo\JUnit5.svg" width="50"/></a> | <a href="https://gradle.org/"><img alt="Gradle" height="50" src="media\logo\Gradle.svg" width="50"/></a> | <a href="https://selenide.org/"><img alt="Selenide" height="50" src="media\logo\Selenide.svg" width="50"/></a> | <a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="media\logo\Selenoid.svg" width="50"/></a> | <a href="https://github.com/allure-framework"><img alt="Allure" height="50" src="media\logo\Allure_Report.svg" width="50"/></a> | <a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="media\logo\Jenkins.svg" width="50"/></a> | <a href="https://web.telegram.org/"><img alt="Telegram" height="50" src="media\logo\Telegram.svg" width="50"/></a> |

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание [Allure-отчета](https://jenkins.autotests.cloud/job/AstonPageTest/12/allure/#suites):
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.


## Список проверок:

---

- ✓ *[Проверка названия меню на странице компании Aston](https://jenkins.autotests.cloud/job/AstonPageTest/13/allure/#suites/637e600a64fda069eeddeea2267330f7/986092c0657c7105/)*
- ✓ *[Проверка вкладки меню "О нас"](https://jenkins.autotests.cloud/job/AstonPageTest/13/allure/#suites/637e600a64fda069eeddeea2267330f7/69277f4ae74644a6/)*
- ✓ *[Проверка вкладки меню "Услуги"](https://jenkins.autotests.cloud/job/AstonPageTest/13/allure/#suites/637e600a64fda069eeddeea2267330f7/e018bd85f7c69731/)*
- ✓ *[Проверка вкладки меню "Проекты"](https://jenkins.autotests.cloud/job/AstonPageTest/13/allure/#suites/637e600a64fda069eeddeea2267330f7/94f7069490210569/)*
- ✓ *[Проверка вкладки меню "Работа в Aston"](https://jenkins.autotests.cloud/job/AstonPageTest/13/allure/#suites/637e600a64fda069eeddeea2267330f7/cad7692b06b1fa38/)*
- ✓ *[Проверка отправки пустой формы](https://jenkins.autotests.cloud/job/AstonPageTest/13/allure/#suites/637e600a64fda069eeddeea2267330f7/47efc8229d6cc10d/)*

## <img height="25" src="media\logo\Jenkins.svg" width="25"/></a> Запуск тестов - сборка в Jenkins:

---

**Сборка в [Jenkins](https://jenkins.autotests.cloud/job/AstonPageTest/)**
- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, использовалась 121.0)*
- *browserSize (размер окна браузера, использовалось 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*

## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean simpletest
```

***Удалённый запуск через Jenkins:***
```bash  
clean
simpletest
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${BROWSER_VERSION}
-Dremote=${REMOTE_URL}
-Dlogin=${REMOTE_LOGIN}
-DremoteVideoURL=${REMOTE_VIDEO_URL}
```

## <img height="25" src="media\logo\Allure_Report.svg" width="25"/></a>  <a name="Allure"></a>Allure Report	</a>

---

## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media\pic\img.png" width="850">  
</p>  

## Тест-кейсы

<p align="center">  
<img title="Allure Graphics" src="media\pic\img_2.png" width="850">  
<img title="Allure Tests" src="media\pic\img_1.png" width="850">
</p>



## <img alt="Allure" height="25" src="media\logo\Telegram.svg" width="25"/></a> Уведомление в Telegram о результатах тестов
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media\pic\img_3.png" width="550">  
</p>

____

## <img alt="Selenoid" height="25" src="media\logo\Selenoid.svg" width="25"/></a> Видео прохождение тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="media\pic\12.gif" width="550" height="350"  alt="video">   
</p>

