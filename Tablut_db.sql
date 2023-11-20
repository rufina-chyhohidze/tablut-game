DROP TABLE IF EXISTS Leaderboard;
create table Leaderboard(
    player_name varchar(15) CONSTRAINT pk_employees Primary Key,
    total_score numeric (6),
    total_wins_of_player numeric (3),
    total_games_of_player numeric (3),
    total_win_rate decimal (5,2),
    wins_as_w numeric (3),
    wins_as_b numeric (3)
);

insert into Leaderboard (player_name, total_score, total_wins_of_player,total_games_of_player, total_win_rate, wins_as_w, wins_as_b)
values ('Guy',550, 2,2,50.55,2,0);
insert into Leaderboard (player_name, total_score, total_wins_of_player,total_games_of_player, total_win_rate, wins_as_w, wins_as_b)
values ('Man',1100, 4,4,100.00,2,2);
insert into Leaderboard (player_name, total_score, total_wins_of_player,total_games_of_player, total_win_rate, wins_as_w, wins_as_b)
values ('Gamer Girl',0, 0,4,100.00,2,2);


UPDATE Leaderboard
SET total_win_rate = 0, wins_as_b = 0, wins_as_w = 0
WHERE player_name = 'Gamer Girl';


select *
from Leaderboard;