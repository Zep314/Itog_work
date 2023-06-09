/*
Создать структуру данных, в которой есть класс - родительский класс, домашние
животные и вьючные животные, в составы которых, в случае домашних
животных, войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

Создать класс с Инкапсуляцией методов и наследованием.

Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:

- Завести новое животное
- Определять животное в правильный класс
- Увидеть список команд, которое выполняет животное
- Обучить животное новым командам
- Реализовать навигацию по меню
- Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
  значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое
  животное” Сделайте так, чтобы с объектом такого типа можно было работать в
  блоке try-with-resources. Нужно бросить исключение, если работа с объектом
  типа счетчик была не в ресурсном try, и/или ресурс остался открыт. Значение
  считать в ресурсе try, если при заведении животного заполнены все поля.
*/

package com.my;

import controller.Controller;

public class Main {  // Точка входа в программу
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}

/* Результат работы:

[2023-04-21 10:44:04] [INFO   ] Начало работы!
[2023-04-21 10:44:04] [INFO   ] Введите команду (h - для вывода помощи):
h
[2023-04-21 10:44:08] [INFO   ] Программа имитирующая работу реестра домашних животных
[2023-04-21 10:44:08] [INFO   ] Список комманд:
[2023-04-21 10:44:08] [INFO   ] q - выход из программы
[2023-04-21 10:44:08] [INFO   ] h - вывод этой помощи
[2023-04-21 10:44:08] [INFO   ] a - добавить новое животное
[2023-04-21 10:44:08] [INFO   ] l - посмотреть весь список животных
[2023-04-21 10:44:08] [INFO   ] v - посмотреть список команд одного животного
[2023-04-21 10:44:08] [INFO   ] t - научить новым командам одно животное
[2023-04-21 10:44:08] [INFO   ] Введите команду (h - для вывода помощи):
a
[2023-04-21 10:44:18] [INFO   ] Добавление животного в базу
[2023-04-21 10:44:18] [INFO   ] Добавление животного
[2023-04-21 10:44:18] [INFO   ] Какое животное хотите добавить? (1-домашнее; 2-вьючное):
1
[2023-04-21 10:44:22] [INFO   ] Какое животное хотите добавить? (1-кот; 2-собака; 3-хомяк):
1
[2023-04-21 10:44:28] [INFO   ] Введите кличку Вашего животного:
Барсик
[2023-04-21 10:44:33] [INFO   ] Введите дату рождения животного:
22-01-2022
[2023-04-21 10:44:41] [INFO   ] Введите команды, которые знает Ваше животное:
спать
[2023-04-21 10:44:47] [INFO   ] Животное добавлено в базу.
[2023-04-21 10:44:47] [INFO   ] Всего в базе 1 животных.
[2023-04-21 10:44:47] [INFO   ] Введите команду (h - для вывода помощи):
a
[2023-04-21 10:44:56] [INFO   ] Добавление животного в базу
[2023-04-21 10:44:56] [INFO   ] Добавление животного
[2023-04-21 10:44:56] [INFO   ] Какое животное хотите добавить? (1-домашнее; 2-вьючное):

[2023-04-21 10:44:56] [WARNING] Ошибка ввода.
[2023-04-21 10:44:56] [INFO   ] Введите команду (h - для вывода помощи):
a
[2023-04-21 10:45:00] [INFO   ] Добавление животного в базу
[2023-04-21 10:45:00] [INFO   ] Добавление животного
[2023-04-21 10:45:00] [INFO   ] Какое животное хотите добавить? (1-домашнее; 2-вьючное):
1
[2023-04-21 10:45:05] [INFO   ] Какое животное хотите добавить? (1-кот; 2-собака; 3-хомяк):
2
[2023-04-21 10:45:06] [INFO   ] Введите кличку Вашего животного:
Макс
[2023-04-21 10:45:14] [INFO   ] Введите дату рождения животного:
11-10-2019
[2023-04-21 10:45:19] [INFO   ] Введите команды, которые знает Ваше животное:
гулять
[2023-04-21 10:45:23] [INFO   ] Животное добавлено в базу.
[2023-04-21 10:45:23] [INFO   ] Всего в базе 2 животных.
[2023-04-21 10:45:23] [INFO   ] Введите команду (h - для вывода помощи):
a
[2023-04-21 10:45:33] [INFO   ] Добавление животного в базу
[2023-04-21 10:45:33] [INFO   ] Добавление животного
[2023-04-21 10:45:33] [INFO   ] Какое животное хотите добавить? (1-домашнее; 2-вьючное):
2
[2023-04-21 10:45:36] [INFO   ] Какое животное хотите добавить? (1-конь; 2-верблюд; 3-осел):
3
[2023-04-21 10:45:43] [INFO   ] Введите кличку Вашего животного:
Яша
[2023-04-21 10:45:47] [INFO   ] Введите дату рождения животного:
01-06-2015
[2023-04-21 10:45:52] [INFO   ] Введите команды, которые знает Ваше животное:
стой
[2023-04-21 10:45:57] [INFO   ] Животное добавлено в базу.
[2023-04-21 10:45:57] [INFO   ] Всего в базе 3 животных.
[2023-04-21 10:45:57] [INFO   ] Введите команду (h - для вывода помощи):
a
[2023-04-21 10:46:00] [INFO   ] Добавление животного в базу
[2023-04-21 10:46:00] [INFO   ] Добавление животного
[2023-04-21 10:46:00] [INFO   ] Какое животное хотите добавить? (1-домашнее; 2-вьючное):
1
[2023-04-21 10:46:04] [INFO   ] Какое животное хотите добавить? (1-кот; 2-собака; 3-хомяк):
3
[2023-04-21 10:46:06] [INFO   ] Введите кличку Вашего животного:
Моня
[2023-04-21 10:46:33] [INFO   ] Введите дату рождения животного:

[2023-04-21 10:46:40] [INFO   ] Введите команды, которые знает Ваше животное:
тихо
[2023-04-21 10:46:48] [WARNING] Ошибка добавления! Заполнены не все поля!
[2023-04-21 10:46:48] [INFO   ] Введите команду (h - для вывода помощи):
a
[2023-04-21 10:46:52] [INFO   ] Добавление животного в базу
[2023-04-21 10:46:52] [INFO   ] Добавление животного
[2023-04-21 10:46:52] [INFO   ] Какое животное хотите добавить? (1-домашнее; 2-вьючное):
2
[2023-04-21 10:46:58] [INFO   ] Какое животное хотите добавить? (1-конь; 2-верблюд; 3-осел):
1
[2023-04-21 10:47:02] [INFO   ] Введите кличку Вашего животного:
Боливар
[2023-04-21 10:47:06] [INFO   ] Введите дату рождения животного:
21-08-2013
[2023-04-21 10:47:11] [INFO   ] Введите команды, которые знает Ваше животное:
вперед
[2023-04-21 10:47:16] [INFO   ] Животное добавлено в базу.
[2023-04-21 10:47:16] [INFO   ] Всего в базе 4 животных.
[2023-04-21 10:47:16] [INFO   ] Введите команду (h - для вывода помощи):
l
[2023-04-21 10:47:21] [INFO   ] Печать списка животных
[2023-04-21 10:47:21] [INFO   ] +--+--------+---------------+----------+----------+----------+------------------------------+
[2023-04-21 10:47:21] [INFO   ] | #|Животное| Принадлежность|       Тип|    Кличка|Дата рожд.|                       Команды|
[2023-04-21 10:47:21] [INFO   ] +--+--------+---------------+----------+----------+----------+------------------------------+
[2023-04-21 10:47:21] [INFO   ] | 1|     Cat|   Мои животные|  Домашние|    Барсик|22-01-2022|                         спать|
[2023-04-21 10:47:21] [INFO   ] | 2|     Dog|   Мои животные|  Домашние|      Макс|11-10-2019|                        гулять|
[2023-04-21 10:47:21] [INFO   ] | 3|  Donkey|   Мои животные|   Вьючные|       Яша|01-06-2015|                          стой|
[2023-04-21 10:47:21] [INFO   ] | 4|   Horse|   Мои животные|   Вьючные|   Боливар|21-08-2013|                        вперед|
[2023-04-21 10:47:21] [INFO   ] +--+--------+---------------+----------+----------+----------+------------------------------+
[2023-04-21 10:47:21] [INFO   ] Введите команду (h - для вывода помощи):
v
[2023-04-21 10:47:35] [INFO   ] Печать команд, которые умеет выполнять животное
[2023-04-21 10:47:35] [INFO   ] Введите номер животного в списке:
3
[2023-04-21 10:47:39] [INFO   ] Животное: Donkey
[2023-04-21 10:47:39] [INFO   ] Кличка: Яша
[2023-04-21 10:47:39] [INFO   ] Команды: стой
[2023-04-21 10:47:39] [INFO   ] Введите команду (h - для вывода помощи):
t
[2023-04-21 10:47:57] [INFO   ] Обучение животного новым командам.
[2023-04-21 10:47:57] [INFO   ] Введите номер животного в списке:
5
[2023-04-21 10:47:59] [WARNING] Животного с таким номером нет!
[2023-04-21 10:47:59] [INFO   ] Введите команду (h - для вывода помощи):
t
[2023-04-21 10:48:02] [INFO   ] Обучение животного новым командам.
[2023-04-21 10:48:02] [INFO   ] Введите номер животного в списке:
4
[2023-04-21 10:48:04] [INFO   ] Животное: Horse
[2023-04-21 10:48:04] [INFO   ] Введите новый список команд, которые знает Боливар:
вправо влево
[2023-04-21 10:48:14] [INFO   ] Новые команды записаны!
[2023-04-21 10:48:14] [INFO   ] Введите команду (h - для вывода помощи):
v
[2023-04-21 10:48:20] [INFO   ] Печать команд, которые умеет выполнять животное
[2023-04-21 10:48:20] [INFO   ] Введите номер животного в списке:
4
[2023-04-21 10:48:22] [INFO   ] Животное: Horse
[2023-04-21 10:48:22] [INFO   ] Кличка: Боливар
[2023-04-21 10:48:22] [INFO   ] Команды: вправо влево
[2023-04-21 10:48:22] [INFO   ] Введите команду (h - для вывода помощи):
q
[2023-04-21 10:48:26] [INFO   ] Работа завершена.

Process finished with exit code 0


 */