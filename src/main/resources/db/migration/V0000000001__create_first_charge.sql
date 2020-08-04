CREATE TABLE IF NOT EXISTS `user`
(
    `id`        int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`      varchar,
    `created_at` timestamp
);
INSERT INTO user (name, created_at) VALUES ('UserTest', now());

CREATE TABLE IF NOT EXISTS `invoice`
(
    `id`        int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number`      varchar,
    `value`      double,
    `user_id`      int,
    `created_at` timestamp
);
INSERT INTO invoice (number, value, user_id, created_at) VALUES ('06661JKLO5678900TYURE', 205.00,  1, now());
INSERT INTO invoice (number, value, user_id, created_at) VALUES ('066615JGPG678900JAJAJ', 95.00,  1, now()+1);

CREATE TABLE IF NOT EXISTS `ticket`
(
    `id`        int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`      int,
    `created_at` timestamp
);
INSERT INTO ticket (id, user_id, created_at) VALUES (1, 1, now());

CREATE TABLE IF NOT EXISTS `user_balance`
(
    `id`        int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `balance`      double,
    `user_id`      int,
    `updated_at` timestamp
);
INSERT INTO user_balance (balance, user_id, updated_at) VALUES (300.00, 1, now());

CREATE TABLE IF NOT EXISTS `user_check_in`
(
    `id`        int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`      int,
    `created_at` timestamp
);
INSERT INTO user_check_in (user_id, created_at) VALUES (1, now());
INSERT INTO user_check_in (user_id, created_at) VALUES (1, now()+1);
