CREATE TABLE IF NOT EXISTS INT_player_scores (
     INT_id SERIAL primary key,
     INT_player_name varchar(20),
     INT_score numeric(10) default 0,
     INT_game_date timestamp
);
drop table if exists INT_player_scores;