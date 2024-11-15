INSERT INTO app_user (id, email, first_name, last_name, user_role)
VALUES (1, 'jurereljanovic99@gmail.com', 'Jure', 'Reljanovic', 0),
       (2, 'jurereljanovic987654321@gmail.com', 'Jure', 'Reljanovic', 1),
       (3, 'asdfasdf@gmail.com', 'Jure', 'Reljanovic', 1),
       (4, 'ivoivic@gmail.com', 'Ivo', 'Ivic', 1);

INSERT INTO apartment_building (id, address, city, number_of_individual_apartments, zip_code)
VALUES (1, 'Odranska 8', 'Zagreb', 23, 10000),
       (2, 'Splitska 4', 'Split', 5, '21000'),
       (3, 'Stjepana radica 42', 'Sibenik', 3, 22000);

INSERT INTO user_apartment_building (id, is_representative, apartment_building_id, user_id)
VALUES (2, true, 1, 2),
       (3, false, 2, 3),
       (1, false, 3, 4),
       (4, false, 1, 1),
       (5, false, 1, 6);