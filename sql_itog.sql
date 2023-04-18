-- Задание 7. Создаем базу данных

DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

-- Задание 8:
-- Создать таблицы с иерархией из диаграммы в БД

-- Создаем таблицы
DROP TABLE IF EXISTS cat;
CREATE TABLE cat
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(30) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  id_home Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(30) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  id_home Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(30) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  id_home Int,
  PRIMARY KEY (id)
);


DROP TABLE IF EXISTS camel;
CREATE TABLE camel
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(30) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  id_pack Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(30) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  id_pack Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(30) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  id_pack Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS home_animal;
CREATE TABLE home_animal
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(20) NOT NULL,
  id_animal Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS pack_animal;
CREATE TABLE pack_animal
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(20) NOT NULL,
  id_animal Int,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS animal;
CREATE TABLE animal
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(20) NOT NULL,
  PRIMARY KEY (id)
);

-- Создаем связи между таблицами
ALTER TABLE home_animal ADD CONSTRAINT animal_to_home FOREIGN KEY (id_animal) REFERENCES animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE cat ADD CONSTRAINT home_to_cat FOREIGN KEY (id_home) REFERENCES home_animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE dog ADD CONSTRAINT home_to_dog FOREIGN KEY (id_home) REFERENCES home_animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE hamster ADD CONSTRAINT home_to_hamster FOREIGN KEY (id_home) REFERENCES home_animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE camel ADD CONSTRAINT pack_to_camel FOREIGN KEY (id_pack) REFERENCES pack_animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE horse ADD CONSTRAINT pack_to_horse FOREIGN KEY (id_pack) REFERENCES pack_animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE donkey ADD CONSTRAINT pack_to_donkey FOREIGN KEY (id_pack) REFERENCES pack_animal (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

SHOW TABLES;

-- Задание 9:
-- Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения

INSERT INTO animal (name) VALUES('Мои животные');
INSERT INTO home_animal (name, id_animal) VALUES ('Комнатные',1),('Уличные',1);
INSERT INTO pack_animal (name, id_animal) VALUES ('Домашние',1),('Вольные',1);
INSERT INTO cat (name, birthdate, commands, id_home) VALUES
	('Мурзик','2020-01-21','кушать спать',1),
	('Васька','2017-12-01','кыш брысь',2);
INSERT INTO dog (name, birthdate, commands, id_home) VALUES
	('Макс','2015-02-11','сидеть лежать',2),
	('Жужа','2016-04-21','охраняй фас',2);
INSERT INTO hamster (name, birthdate, commands, id_home) VALUES
	('Иннокентий','2022-11-11','кушать',1),
	('Славик','2023-01-27','спать',1);
INSERT INTO horse (name, birthdate, commands, id_pack) VALUES
	('Боливар','2010-09-05','вперед стой',1),
	('Звездочка','2012-10-12','рысью галопом',1);
INSERT INTO donkey (name, birthdate, commands, id_pack) VALUES
	('Дон','2020-10-17','иди жди',1),
	('Иа','2019-04-07','грусти радуйся',1);
INSERT INTO camel (name, birthdate, commands, id_pack) VALUES
	('Лила','2017-06-01','иди стой',2),
	('Танк','2016-05-28','тяни отдыхай',2);

-- Проверка заполнения таблиц данными
SELECT * FROM animal;
SELECT * FROM home_animal;
SELECT * FROM pack_animal;
SELECT * FROM cat;
SELECT * FROM dog;
SELECT * FROM hamster;
SELECT * FROM horse;
SELECT * FROM camel;
SELECT * FROM donkey;

-- Задание 10:
-- Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

DELETE FROM camel;

SELECT name, birthdate, commands, id_pack FROM horse
UNION ALL
SELECT name, birthdate, commands, id_pack FROM donkey
;

-- Задание 11:
-- Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

-- Создаем новую таблицу
DROP TABLE IF EXISTS young_animal;
CREATE TABLE young_animal
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(20) NOT NULL,
  birthdate Date NOT NULL,
  commands Varchar(200),
  age_in_months Int,
  PRIMARY KEY (id)
);

-- Вставляем данные в новую таблицу
INSERT INTO young_animal (name, birthdate, commands, age_in_months)
SELECT a.name, a.birthdate, a.commands, TIMESTAMPDIFF(MONTH, a.birthdate, SYSDATE()) as age_in_months FROM (
	SELECT name, birthdate, commands FROM cat
	UNION ALL
	SELECT name, birthdate, commands FROM dog
	UNION ALL
	SELECT name, birthdate, commands FROM hamster
	UNION ALL
	SELECT name, birthdate, commands FROM horse
	UNION ALL
	SELECT name, birthdate, commands FROM donkey
	UNION ALL
	SELECT name, birthdate, commands FROM camel
) a
WHERE TIMESTAMPDIFF(MONTH, a.birthdate, SYSDATE()) BETWEEN 1*12 AND 3*12
;

-- Проверка содержимого таблицы
SELECT * FROM young_animal;

-- Задание 12:
-- Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

SELECT c.name, c.birthdate, c.commands, h.name as 'type', a.name as animal FROM cat c
JOIN home_animal h ON h.id = c.id_home
JOIN animal a ON h.id_animal = a.id
UNION
SELECT d.name, d.birthdate, d.commands, h.name as 'type', a.name as animal FROM dog d
JOIN home_animal h ON h.id = d.id_home
JOIN animal a ON h.id_animal = a.id
UNION
SELECT h1.name, h1.birthdate, h1.commands, h.name as 'type', a.name as animal FROM hamster h1
JOIN home_animal h ON h.id = h1.id_home
JOIN animal a ON h.id_animal = a.id
UNION
SELECT h2.name, h2.birthdate, h2.commands, h.name as 'type', a.name as animal FROM horse h2
JOIN pack_animal h ON h.id = h2.id_pack
JOIN animal a ON h.id_animal = a.id
UNION
SELECT c1.name, c1.birthdate, c1.commands, h.name as 'type', a.name as animal FROM camel c1
JOIN pack_animal h ON h.id = c1.id_pack
JOIN animal a ON h.id_animal = a.id
UNION
SELECT d1.name, d1.birthdate, d1.commands, h.name as 'type', a.name as animal FROM donkey d1
JOIN pack_animal h ON h.id = d1.id_pack
JOIN animal a ON h.id_animal = a.id
;
