create table games (
  id number primary key,
  name varchar2(200)
);

create table positions (
  id number primary key,
  game_id number references(games.id),
  pos number,
  name number,
  min number,
  max number
);

create table drawings (
  drawing_date date not null,
  pos_id number references (positions.id),
  value number
);