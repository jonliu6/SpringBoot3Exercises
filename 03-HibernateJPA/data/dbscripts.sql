USE DemoDB;
--DROP TABLE t_genre;
CREATE TABLE t_genre (
  GenreName VARCHAR(50) NOT NULL PRIMARY KEY
);

--DROP TABLE t_album;
CREATE TABLE t_album (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  AlbumName VARCHAR(50) NOT NULL,
  Artist VARCHAR(50) NOT NULL,
  Genre VARCHAR(50),
  PublishDate DATE,
  AlbumFormat VARCHAR(20)
);

--DROP TABLE t_song;
CREATE TABLE t_song (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  AlbumId INT NOT NULL,
  SongTitle VARCHAR(100) NOT NULL
);

INSERT INTO t_genre (GenreName) VALUES ('Hard Rock');
INSERT INTO t_genre (GenreName) VALUES ('Heave Metal');
INSERT INTO t_genre (GenreName) VALUES ('Thrash Metal');

INSERT INTO t_album
  (AlbumName, Artist, Genre, PublishDate, AlbumFormat)
  VALUES ('Skid Row', 'Skid Row', 'Heave Metal', STR_TO_DATE('1989-01-24', '%Y-%m-%d'), 'CD');

INSERT INTO t_album
  (AlbumName, Artist, Genre, PublishDate, AlbumFormat)
  VALUES ('Slave to the Grind', 'Skid Row', 'Heave Metal', STR_TO_DATE('1991-06-11', '%Y-%m-%d'), 'CD');

INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Big Guns');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Sweet Little Sister');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Can''t Stand the Heartache');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Piece of Me');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, '18 and Life');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Rattlesnake Shake');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Youth Gone Wild');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Here I Am');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Makin'' a Mess');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'I Remember You');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (1, 'Midnight/Tornado');

INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Monkey Business');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Slave to the Grind');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'The Threat');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Quicksand Jesus');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Psycho Love');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Get the Fuck Out');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Livin'' on a Chain Gang');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Creepshow');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'In a Darkened Room');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Riot Act');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Mudkicker');
INSERT INTO t_song (AlbumId, SongTitle) VALUES (2, 'Wasted Time');
