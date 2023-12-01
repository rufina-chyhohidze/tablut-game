DROP TABLE IF EXISTS INT_Leaderboard;
create table INT_Leaderboard(
INT_player_name varchar(225),
INT_score numeric (999) default 0,
INT_date_of_last_game timestamp
);


insert into int_leaderboard (int_player_name, int_score, int_date_of_last_game)
values ('Dora', 10, CURRENT_TIMESTAMP),
       ('Dora', 15, CURRENT_TIMESTAMP),
       ('Dora', 45, CURRENT_TIMESTAMP),
       ('Dora', 30, CURRENT_TIMESTAMP),
       ('Dora', 40, CURRENT_TIMESTAMP),
       ('Dora', 35, CURRENT_TIMESTAMP),
       ('<Max>', 45, CURRENT_TIMESTAMP),
       ('<Max>', 40, CURRENT_TIMESTAMP),
       ('<Max>', 20, CURRENT_TIMESTAMP),
       ('<Max>', 70, CURRENT_TIMESTAMP),
       ('<Max>', 40, CURRENT_TIMESTAMP),
       ('<Max>', 30, CURRENT_TIMESTAMP),
       ('VI',50, CURRENT_TIMESTAMP),
       ('Silverhand', 25, CURRENT_TIMESTAMP);


SELECT INT_player_name, INT_score
FROM INT_Leaderboard
WHERE lower(INT_player_name) = lower('dora')
ORDER BY INT_score DESC
LIMIT 5;
