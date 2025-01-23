INSERT INTO nova_progi_baza.public.app_user ( email, first_name, last_name, user_role)
VALUES ( 'jurereljanovic99@gmail.com', 'Jure', 'Reljanovic', 0),
       ( 'jurereljanovic987654321@gmail.com', 'Jure', 'Reljanovic', 1),
       ( 'asdfasdf@gmail.com', 'Jure', 'Reljanovic', 1),
       ( 'leon.hegedic1@gmail.com', 'Leon', 'Hegedić', 0),
       ( 'ivoivic@gmail.com', 'Ivo', 'Ivic', 1);

INSERT INTO nova_progi_baza.public.apartment_building ( address, city, number_of_individual_apartments, zip_code)
VALUES ( 'Odranska 8', 'Zagreb', 23, 10000),
       ( 'Splitska 4', 'Split', 5, '21000'),
       ( 'Stjepana radica 42', 'Sibenik', 3, 22000);

INSERT INTO nova_progi_baza.public.user_apartment_building ( is_representative, apartment_building_id, user_id)
VALUES ( true, 1, 2),
       ( false, 2, 3),
       ( false, 3, 4),
       ( false, 1, 1),
       ( false, 1, 5);

INSERT INTO nova_progi_baza.public.discussion ( description, title, apartment_building_id, creator_user_id)
VALUES ( 'Ovo je sadrzaj diskusije 1', 'Ovo je naslov diskusije 1', 2, 1),
       ( 'Ovo je sadrzaj diskusije 2', 'Ovo je naslov diskusije 2', 1, 2),
       ( 'Ovo je sadrzaj diskusije 3', 'Ovo je naslov diskusije 3', 3, 1),
       ( 'Ovo je sadrzaj diskusije 4', 'Ovo je naslov diskusije 4', 1,  4),
       ( 'Ovo je sadrzaj diskusije 5', 'Ovo je naslov diskusije 5', 2,  4);

-- INSERT INTO postgress_72f6.public.discussion (id, description, title, apartment_building_id, voting_id, creator_user_id)
-- VALUES (2, 'Ovo je sadrzaj diskusije 1', 'Ovo je naslov diskusije 1', 2, null, 1),
--        (3, 'Ovo je sadrzaj diskusije 2', 'Ovo je naslov diskusije 2', 1, null, 2),
--        (1, 'Ovo je sadrzaj diskusije 3', 'Ovo je naslov diskusije 3', 3, null, 1),
--        (4, 'Ovo je sadrzaj diskusije 4', 'Ovo je naslov diskusije 4', 1, null, 4),
--        (5, 'Ovo je sadrzaj diskusije 5', 'Ovo je naslov diskusije 5', 2, null, 4);
--

-- INSERT INTO postgress_72f6.public.user_discussion(can_user_participate_in_discussion, can_user_see_discussion, discussion_id, id)
-- VALUES (true, true,1, 1),
--        (false, true, 1, 2),
--        (false, false, 1, 3);
--
-- INSERT INTO postgress_72f6.public.discussion_user_discussions(discussion_id, user_discussions_id)
-- VALUES (1, 1),
--        (1, 2),
--        (1, 3);

INSERT INTO nova_progi_baza.public.comment ( author_id, discussion_id, content)
VALUES ( 1, 1, 'Ovo je komentar'),
       ( 3, 2, 'Ovo je jos jedan komentar'),
       ( 1, 1, 'Ovo je jes jedan, ali jos jedan komentar'),
       ( 3, 2, 'Ovo je isto komentar'),
       ( 1, 3, 'Ovo je jos jos jos jos ojsj kometar');

-- INSERT INTO postgress_72f6.public.discussion_comments (comments_id, discussion_id)
-- VALUES (2, 1),
--        (3, 2),
--        (1, 3),
--        (4, 1),
--        (5, 1);

INSERT INTO nova_progi_baza.public.voting (discussion_id,  negative_answer_label, pozitive_answer_label, title)
VALUES (1,  'Ne slazem se', 'Slazem se', 'Slažete li se s ovim'),
       (2,  'Ne slazem se', 'Slazem se', 'Slažete li se s ovim'),
        (3, 'Ne slazem se', 'Slazem se', 'Slažete li se s ovim'),
         (4, 'Ne slazem se', 'Slazem se', 'Slažete li se s ovim');

INSERT INTO nova_progi_baza.public.user_voting (answer_pozitive, user_id, voting_id)
VALUES (true, 1, 1),
       (true, 2, 1),
       (true, 3, 1),
       (true, 4, 1);

INSERT INTO nova_progi_baza.public.voting_user_votings(user_votings_id, voting_id)
VALUES (1, 1),
       (2, 1),
        (3, 1),
        (4,1);

-- UPDATE postgress_72f6.public.discussion
-- SET voting_id = 1
-- WHERE  id = 1;
--
-- UPDATE postgress_72f6.public.discussion
-- SET voting_id = 2
-- WHERE  id = 2;
--
-- UPDATE postgress_72f6.public.discussion
-- SET voting_id = 3
-- WHERE  id = 3;
--
-- UPDATE postgress_72f6.public.discussion
-- SET voting_id = 4
-- WHERE  id = 4;
