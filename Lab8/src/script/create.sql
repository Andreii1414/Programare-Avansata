DROP TABLE album_genres;
DROP TABLE albums;
DROP TABLE artists;
DROP TABLE genres;

CREATE TABLE albums (
  id VARCHAR(10) PRIMARY KEY NOT NULL,
  releaseYear INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  artist VARCHAR(255) NOT NULL,
  genre VARCHAR(255) NOT NULL
);

CREATE TABLE artists (
  id VARCHAR(10) PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE genres (
  id VARCHAR(10) PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE album_genres (
  album_id VARCHAR(10) NOT NULL,
  genre_id VARCHAR(10) NOT NULL,
  PRIMARY KEY (album_id, genre_id),
  FOREIGN KEY (album_id) REFERENCES albums(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id)
);
