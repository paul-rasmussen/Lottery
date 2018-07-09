insert into lotto.games(name) values ('Powerball');
insert into lotto.games(name) values ('Megamillions');

insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),1,'',1,69);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),2,'',1,69);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),3,'',1,69);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),4,'',1,69);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),5,'',1,69);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),6,'',1,26);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Powerball'),7,'Powerplay',2,5);

insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),1,'',1,75);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),2,'',1,75);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),3,'',1,75);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),4,'',1,75);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),5,'',1,75);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),6,'',1,15);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Megamillions'),7,'Megaplier',2,5);

insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Lotto'),1,'',1,42);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Lotto'),2,'',1,42);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Lotto'),3,'',1,42);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Lotto'),4,'',1,42);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Lotto'),5,'',1,42);
insert into lotto.positions(game_id, pos, name, min, max) values ((select id from lotto.games where name='Lotto'),6,'',1,42);

insert into lotto.characteristics(name) values ('Probability');
insert into lotto.characteristics(name) values ('Gap Below');
insert into lotto.characteristics(name) values ('Gap Above');
insert into lotto.characteristics(name) values ('Time Idle');
insert into lotto.characteristics(name) values ('Gap Below Idle');
insert into lotto.characteristics(name) values ('Gap Above Idle');

