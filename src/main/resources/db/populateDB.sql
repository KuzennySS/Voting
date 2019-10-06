DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM voting;
DELETE FROM result;
DELETE FROM menu;
DELETE FROM restaurants;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;


INSERT INTO users (name, email, password) VALUES
('User', 'user@yandex.ru', 'password'),
('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_ADMIN', 100001),
('ROLE_USER',100001);

INSERT INTO restaurants (restaurant_name) VALUES
('BAKU'),
('PRAGA'),
('MAKDONALS');

INSERT INTO menu (restaurant_id, dish_name, price, date_menu) VALUES
(100002, 'пити', 180.02, '2019-09-29'),
(100002, 'борщ', 160, '2019-09-28'),
(100002, 'боз-баш', 160, '2019-09-27'),
(100003, 'чахохбили', 300.52, '2019-09-26'),
(100003, 'запеченая свиная рулька', 480, '2019-09-25'),
(100003, 'сочная свиная корейка на кости', 390, '2019-09-24'),
(100004, 'Биг Мак МакКомбо', 215.8, '2019-09-23'),
(100004, 'Гамбургер', 48, '2019-09-22'),
(100004, 'пирожок по итальянски', 49, '2019-09-21');

INSERT INTO voting (user_id, voting_date, restaurant_id) VALUES
(100000, '2019-09-30', 100002),
(100000, '2019-09-29', 100003),
(100001, '2019-09-30', 100004),
(100001, '2019-09-29', 100002);

INSERT INTO result (restaurant_id, count_vote) VALUES
(100002, 0),
(100003, 1),
(100004, 2);
