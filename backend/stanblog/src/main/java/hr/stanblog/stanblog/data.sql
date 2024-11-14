INSERT INTO app_user (id, email, first_name, last_name, user_role)
VALUES (6, 'jurereljanovic99@gmail.com', 'Jure', 'Reljanovic', 0),
       (7, 'jurereljanovic987654321@gmail.com', 'Jure', 'Reljanovic', 1),
       (8, 'asdfasdf@gmail.com', 'Jure', 'Reljanovic', 1),
       (9, 'ivoivic@gmail.com', 'Ivo', 'Ivic', 1);

INSERT INTO apartment_building (id, address, city, number_of_individual_apartments, zip_code)
VALUES (4, 'Odranska 8', 'Zagreb', 23, 10000),
       (5, 'Splitska 4', 'Split', 5, '21000'),
       (6, 'Stjepana radica 42', 'Sibenik', 3, 22000);

INSERT INTO user_apartment_building (id, is_representative, apartment_building_id, user_id)
VALUES (6, true, 1, 2),
       (7, false, 2, 3),xw
       (8, false, 3, 4),
       (9, false, 1, 5),
       (10, false, 1, 6);