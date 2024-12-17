INSERT INTO postgress_72f6.public.app_user (id, email, first_name, last_name, user_role)
VALUES (1, 'jurereljanovic99@gmail.com', 'Jure', 'Reljanovic', 0),
       (2, 'jurereljanovic987654321@gmail.com', 'Jure', 'Reljanovic', 1),
       (3, 'asdfasdf@gmail.com', 'Jure', 'Reljanovic', 1),
       (5, 'leon.hegedic1@gmail.com', 'Leon', 'Hegedić', 0),
       (4, 'ivoivic@gmail.com', 'Ivo', 'Ivic', 1);

INSERT INTO postgress_72f6.public.apartment_building (id, address, city, number_of_individual_apartments, zip_code)
VALUES (1, 'Odranska 8', 'Zagreb', 23, 10000),
       (2, 'Splitska 4', 'Split', 5, '21000'),
       (3, 'Stjepana radica 42', 'Sibenik', 3, 22000);

INSERT INTO postgress_72f6.public.user_apartment_building (id, is_representative, apartment_building_id, user_id)
VALUES (2, true, 1, 2),
       (3, false, 2, 3),
       (1, false, 3, 4),
       (4, false, 1, 1),
       (5, false, 1, 6);

INSERT INTO postgress_72f6.public.discussion (id, description, title, apartment_building_id, voting_id, creator_user_id)
VALUES (2, true, 1, 2, 1, 1),
       (3, false, 2, 3, 1, 2),
       (1, false, 3, 4, 1, 1),
       (4, false, 1, 1, 2, 4),
       (5, false, 1, 6, 2,4);

INSERT INTO postgress_72f6.public.discussion_comments (comments_id, discussion_id)
VALUES (2, 1),
       (3, 2),
       (1, 3),
       (4, 1),
       (5, 1);

INSERT INTO postgress_72f6.public.comment (id, parent_id, text)
VALUES (2, 1, 'Ovo je komentar'),
       (1, null, 'Ovo je jos jedan komentar'),
       (3, 1, 'Ovo je jes jedan, ali jos jedan komentar'),
       (4, 3, 'Ovo je isto komentar'),
       (5, 1, 'Ovo je jos jos jos jos ojsj kometar');

INSERT INTO postgress_72f6.public.comment_children (comment_id, children_id)
VALUES (1, 3),
       (1, 5),
       (1, 2),
       (3, 4);

INSERT INTO postgress_72f6.public.voting (discussion_id, id, negative_answer_label, pozitive_answer_label, title)
VALUES (1, 3, 'Ne slazem se', 'Slazem se', 'Slažete li se s ovim'),
       (2, 3, 'Ne slazem se', 'Slazem se', 'Slažete li se s ovim'),
        (3, 3, 'Ne slazem se', 'Slazem se', 'Slažete li se s ovim'),
         (4, 3, 'Ne slazem se', 'Slazem se', 'Slažete li se s ovim');

INSERT INTO postgress_72f6.public.user_voting (answer_pozitive, id, user_id)
VALUES (true, 1, 1),
       (true, 2, 2),
       (true, 3, 3),
       (true, 4, 4);

INSERT INTO postgress_72f6.public.voting_user_votes (user_votes_id, voting_id)
VALUES (true, 1, 1),
       (true, 2, 2),
       (true, 3, 3),
       (true, 4, 4);