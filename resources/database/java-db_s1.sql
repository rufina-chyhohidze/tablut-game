CREATE TABLE IF NOT EXISTS player_scores (
     player_name varchar(255),
     score numeric(999) default 0,
     game_date timestamp
);