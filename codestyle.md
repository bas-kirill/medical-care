# Настройка Code Style

## Автоформатирование
1. Переходим в ```Intelij IDEA => Preferences => Code style```
2. Импортируем из корня проекта ```google_codestyle.xml```
   ![google_codestyle.xml](https://github.com/bas-kirill/special-computing-workshop-template/blob/main/images/img_1.png?raw=true)
3. Также важно не забывать запускать автоформатирование. Его можно настроить на определенные клавиши (например, option + command + L):
   ![auto-formatting](https://github.com/bas-kirill/special-computing-workshop-template/raw/main/images/img_2.png)

## Настройка Checkstyle
Установите ```Preferences => Plugins => "CheckStyle-IDEA"```

Выставите настройки как на скрине:
![img_4.png](https://github.com/bas-kirill/special-computing-workshop-template/raw/main/images/img_3.png)

## Настройка SonarLint
Установите ```Preferences => Plugins => "SonarLint"```

## Настройка SonarQube
Переходим в ```Preferences => Tools => SonarLint => Project Settings```
<img width="1012" alt="image" src="https://user-images.githubusercontent.com/39113667/190925153-de58462b-1adb-4da5-9c21-577366d2c234.png">

Переходим в ```Configure the connection...``` и добавляем ```SonarQube / SonarCloud connections```:
<img width="1071" alt="image" src="https://user-images.githubusercontent.com/39113667/190925593-f2a2785b-7ffa-4f2a-a5e0-3979ebc672d4.png">

Нажимаем на ```Connect to the online service``` и регистрируемся под GitHub профилем.

В результате должна открыться страница с проверкой кода:
<img width="1445" alt="image" src="https://user-images.githubusercontent.com/39113667/190925502-2863a888-cd47-4de5-9ce0-ef1b1be09f43.png">

После этого переходим ```Next``` во вкладке нового подключения и генерируем токен:
<img width="1184" alt="image" src="https://user-images.githubusercontent.com/39113667/190925630-15292fe7-75ff-45f4-b0ac-89b3ec6cdfaa.png">

Прокликиваем ```Next```. в результате должно быть установлено соединение в ```Tools => SonarLint```:
<img width="1094" alt="image" src="https://user-images.githubusercontent.com/39113667/190925709-38bd468e-58e7-4a7c-9ba6-572348bdb26c.png">

Добавляем соединение:
<img width="1094" alt="image" src="https://user-images.githubusercontent.com/39113667/190925815-775ff008-4010-4342-a18a-a5765eeffe09.png">

## Запуск JoCoCo
При запуске проверьте, что в конфигурации запуска указаны следующие настройки в ```code coverage```:
![img.png](https://github.com/bas-kirill/special-computing-workshop-template/raw/main/images/img_4.png)

Ожидаемый результат:
![img.png](https://github.com/bas-kirill/special-computing-workshop-template/raw/main/images/img_5.png)