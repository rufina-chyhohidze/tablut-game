CREATE TABLE IF NOT EXISTS INT_player_scores (
     INT_id SERIAL primary key,
     INT_player_name varchar(20),
     INT_score numeric(10) default 0,
     INT_game_date timestamp
);

CREATE TABLE IF NOT EXISTS INT_game_states (
   INT_id SERIAL PRIMARY KEY,
   INT_white_username varchar(255),
   INT_black_username varchar(255),
   INT_turn varchar(255) not null,
   INT_seconds_played int not null default 0
);

CREATE TABLE IF NOT EXISTS INT_game_boards (
   INT_id SERIAL PRIMARY KEY,
   INT_game_state_id int not null
       constraint fk_game_boards_game_state_id
           references INT_game_states on delete cascade
);

CREATE TABLE IF NOT EXISTS INT_board_figures (
     INT_board_id INT NOT NULL
         constraint fk_board_figure_board_id
             references INT_game_boards on delete cascade,
     INT_board_row INT NOT NULL,
     INT_board_col INT NOT NULL,
     INT_figure varchar(10) NOT NULL,
     PRIMARY KEY (INT_board_id, INT_board_row, INT_board_col)
);