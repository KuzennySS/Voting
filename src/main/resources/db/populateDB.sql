DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM voting;
DELETE FROM result;
DELETE FROM menu;
DELETE FROM restaurants;


INSERT INTO users (name, email, password) VALUES
('User', 'user@yandex.ru', 'password'),
('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 0),
('ROLE_ADMIN', 1),
('ROLE_USER',1);

INSERT INTO restaurants (id, restaurant_name) VALUES
(1, 'BAKU'),
(2, 'PRAGA'),
(3, 'MAKDONALS');

INSERT INTO menu (restaurant_id, dish_name, price) VALUES
(1, 'пити', 180.02),
(1, 'борщ', 160),
(1, 'боз-баш', 160),
(2, 'чахохбили', 300.52),
(2, 'запеченая свиная рулька', 480),
(2, 'сочная свиная корейка на кости', 390),
(3, 'Биг Мак МакКомбо', 215.8),
(3, 'Гамбургер', 48),
(3, 'пирожок по итальянски', 49);

INSERT INTO voting (user_id, voting_date, restaurant_id) VALUES
(0, '2019-09-30', 1),
(0, '2019-09-29', 2),
(1, '2019-09-30', 3),
(1, '2019-09-29', 1);
