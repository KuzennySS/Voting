DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS voting;
DROP TABLE IF EXISTS result;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name       VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    enabled    BOOLEAN   DEFAULT TRUE  NOT NULL,
    CONSTRAINT users_unique_email_idx UNIQUE (email)
);

CREATE TABLE restaurants
(
    id              INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    restaurant_name VARCHAR(50) NOT NULL,
    CONSTRAINT restaurants_unique_id_restaurant_name_idx UNIQUE (id, restaurant_name)
);
-- CREATE UNIQUE INDEX restaurants_unique_id_restaurant_name_idx
--     ON restaurants (id, restaurant_name);

CREATE TABLE result
(
    id              INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    restaurant_id INTEGER NOT NULL,
    count_vote    INTEGER NOT NULL,
    CONSTRAINT result_idx UNIQUE (restaurant_id, count_vote),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE voting
(
    id            INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    user_id       INTEGER   NOT NULL,
    voting_date   timestamp NOT NULL,
    restaurant_id bigint    NOT NULL,
    CONSTRAINT voting_idx UNIQUE (user_id, voting_date, restaurant_id),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE menu
(
    id            INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    restaurant_id INTEGER       NOT NULL,
    dish_name     varchar(100)  NOT NULL,
    price         decimal(7, 2) NOT NULL,
    date_menu     timestamp     NOT NULL,
    CONSTRAINT menu_unique_idx UNIQUE (restaurant_id, dish_name),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
-- https://dbdiffo.com