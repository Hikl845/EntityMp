INSERT INTO Client(name)
VALUES ("Іванов Артем"),
       ("Кисіль Максим"),
       ("Гончаренко Віктор"),
       ("Остапчук Ірина"),
       ("Борисов Григорій"),
       ("Антонова Світлана"),
       ("Тесла Анастасія"),
       ("Бабенко Антон"),
       ("Удонова Анастасія"),
       ("Драгунова Софія");
INSERT INTO Planet(id, name)
VALUES ("VEN", "Venus"),
       ("MERC", "Mercury"),
       ("MARS","Mars"),
       ("EART","Earth"),
       ("JUPT","Jupiter");
INSERT INTO Ticket(client_id, from_planet_id, to_planet_id)
VALUES (1,"MARS","EART"),
       (2,"MERC","VEN"),
       (3,"JUPT","MERC"),
       (4,"MERC","EART"),
       (5,"EART","JUPT"),
       (6,"MARS","JUPT"),
       (7,"VEN","MARS"),
       (8,"MARS","EART"),
       (9,"EART","MERC"),
       (10,"VEN","EART");
