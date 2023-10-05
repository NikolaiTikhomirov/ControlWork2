DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	types_of_animals CHAR(30)
);

DROP TABLE IF EXISTS pet;
CREATE TABLE pet (
	id INT PRIMARY KEY AUTO_INCREMENT,
    class CHAR(30),
	types_of_animals CHAR(30)
);

DROP TABLE IF EXISTS pack_animal;
CREATE TABLE pack_animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
    class CHAR(30),
	types_of_animals CHAR(30)
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

INSERT INTO animals (types_of_animals) VALUES 
	('pet'),
	('pack_animal');

INSERT INTO pet (types_of_animals, class) VALUES 
	('dog', 'animal'),
    ('cat', 'animal'),
	('hamster', 'animal');

INSERT INTO pack_animal (types_of_animals, class) VALUES 
	('horse', 'animal'),
    ('camel', 'animal'),
	('donkey', 'animal');
    
INSERT INTO dog (animal_name, class, commands, date_of_birth) VALUES 
	('jack', 'pet', 'woof', '2020-06-08'),
	('black', 'pet', 'woof', '2015-11-12'),
    ('snoopy', 'pet', 'woof', '2016-04-01');

INSERT INTO cat (animal_name, class, commands, date_of_birth) VALUES 
	('tom', 'pet', 'meow', '2023-05-03'),
	('cocos', 'pet', 'meow', '2019-11-09'),
    ('persik', 'pet', 'meow', '2022-10-04');

INSERT INTO hamster (animal_name, class, commands, date_of_birth) VALUES 
	('rodent', 'pet', 'eat', '2010-05-06'),
	('rat', 'pet', 'eat', '2011-04-03'),
    ('jarry', 'pet', 'eat', '2012-01-02');
    
INSERT INTO horse (animal_name, class, commands, date_of_birth) VALUES 
	('thunder', 'pack_animal', 'run', '2005-02-01'),
	('fire', 'pack_animal', 'run', '2006-04-11'),
    ('storm', 'pack_animal', 'run', '2007-09-04');
    
INSERT INTO camel (animal_name, class, commands, date_of_birth) VALUES 
	('ivan', 'pack_animal', 'stay', '2008-05-12'),
	('jim', 'pack_animal', 'stay', '2009-12-07'),
    ('eleanor', 'pack_animal', 'stay', '2010-02-05');
    
INSERT INTO donkey (animal_name, class, commands, date_of_birth) VALUES 
	('elen', 'pack_animal', 'laugth', '2012-05-11'),
	('mary', 'pack_animal', 'laugth', '2011-06-12'),
    ('kate', 'pack_animal', 'laugth', '2014-07-09');
    
TRUNCATE camel;
DELETE FROM pack_animal WHERE types_of_animals = 'camel';

INSERT INTO horse (animal_name, class, commands, date_of_birth)
SELECT animal_name, class, commands, date_of_birth
FROM donkey;

DROP TABLE donkey;

RENAME TABLE horse TO horse_donkey;

CREATE TABLE young_animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE,
    age TEXT
);


DELIMITER $$
CREATE FUNCTION age_animal (date_b DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, date_b, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, date_b, CURDATE()) % 12,
            ' month'
        );
	RETURN res;
END $$
DELIMITER ;

INSERT INTO young_animal (animal_name, class, commands, date_of_birth, age)
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth)
FROM dog
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth)
FROM cat
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth)
FROM hamster
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth)
FROM horse_donkey
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

CREATE TABLE final_animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    class CHAR(30),
    commands TEXT,
    date_of_birth DATE,
    age TEXT,
    animal_type ENUM('cat','dog','hamster', 'horse_donkey', 'young_animals') NOT NULL
);

INSERT INTO final_animals (animal_name, class, commands, date_of_birth, age, animal_type)
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth), 'cat'
FROM cat;

INSERT INTO final_animals (animal_name, class, commands, date_of_birth, age, animal_type)
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth), 'dog'
FROM dog;

INSERT INTO final_animals (animal_name, class, commands, date_of_birth, age, animal_type)
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth), 'hamster'
FROM hamster;

INSERT INTO final_animals (animal_name, class, commands, date_of_birth, age, animal_type)
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth), 'horse_donkey'
FROM horse_donkey;

INSERT INTO final_animals (animal_name, class, commands, date_of_birth, age, animal_type)
SELECT animal_name, class, commands, date_of_birth, age_animal(date_of_birth), 'young_animals'
FROM young_animal;