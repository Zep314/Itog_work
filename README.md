# Итоговая контрольная работа по блоку специализация

## Урок 2. Практическое задание

### Задания для работы можно посмотреть [тут](Итоговая аттестация.pdf)

---

#### Задание 1:
Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

#### Решение:

    user@server:~$ cat > pets.txt
    dog
    cat
    hamster
    dima@docker2:~$ cat > pack.txt
    horse
    camel
    donkey
    dima@server:~$ cat pets.txt pack.txt > human_friends.txt
    dima@server:~$ cat human_friends.txt
    dog
    cat
    hamster
    horse
    camel
    donkey
    user@server:~$

#### Задание 2: Создать директорию, переместить файл туда.

#### Решение:

    user@server:~$ mkdir work
    user@server:~$ mv ./human_friends.txt ./work/

#### Задание 3: Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

#### Решение:

