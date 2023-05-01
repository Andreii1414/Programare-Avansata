package org.example.Optional;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);

        Reader reader = new BufferedReader(new FileReader("src/script/create.sql"));

        scriptRunner.runScript(reader);

        /**
         *Albums
         */
        Album album = new Album("1", 2023, "A", "Artist1");
        Album album2 = new Album("2", 2010, "B", "Artist2");

        AlbumDao albumDao = new AlbumDao();
        albumDao.createAlbum(album);
        albumDao.createAlbum(album2);
        List<Album> albums = albumDao.selectAll();

        Album a1 = albumDao.getById("1");
        System.out.println("Albums: ");
        System.out.println(a1.getAlbumId() + " " + a1.getReleaseYear() + " " + a1.getTitle() + " " + a1.getArtist());
        System.out.println();

        for(Album album1 : albums){
            System.out.println(album1.getAlbumId() + " " + album1.getReleaseYear() + " " + album1.getTitle() + " " + album1.getArtist());
        }

        /**
         * Artists
         */
        Artist artist1 = new Artist("Artist1", "1");
        Artist artist2 = new Artist("Artist2", "2");
        ArtistDao artistDao = new ArtistDao();
        artistDao.createArtist(artist1);
        artistDao.createArtist(artist2);
        List<Artist> artists = artistDao.selectAll();
        Artist art = artistDao.getByName("Artist1");
        System.out.println("Artists: ");
        System.out.println(art.getArtistId() + " " + art.getArtistName());
        System.out.println();

        for(Artist artist : artists)
        {
            System.out.println(artist.getArtistId() + " " + artist.getArtistName());
        }

        /**
         * Genres
         */
        Genre genre1 = new Genre("1", "Genre1");
        Genre genre2 = new Genre("2", "Genre2");
        GenreDao genreDao = new GenreDao();
        genreDao.createGenre(genre1);
        genreDao.createGenre(genre2);
        List<Genre> genres = genreDao.selectAll();
        Genre genre = genreDao.getById("1");
        System.out.println("Genres: ");
        System.out.println(genre.getGenreId() + " " + genre.getGenreName());
        System.out.println();

        for(Genre g : genres)
        {
            System.out.println(g.getGenreId() + " " + g.getGenreName());
        }

        /**
         * Associative table
         */
        AssociativeTable at1 = new AssociativeTable(album.getAlbumId(), genre2.getGenreId());
        AssociativeTable at2 = new AssociativeTable(album2.getAlbumId(), genre1.getGenreId());
        AssociativeTableDao atDao = new AssociativeTableDao();
        atDao.createAssociativeTable(at1);
        atDao.createAssociativeTable(at2);
        List<AssociativeTable> ats = atDao.selectAll();
        AssociativeTable at = atDao.getByGenreId("2");
        System.out.println("Associative table: ");
        System.out.println("Album id: " + at.getAlbumId() + " Genre id: " + at.getGenreId());
        System.out.println();

        for(AssociativeTable associativeTable : ats)
        {
            System.out.println("Album id: " + associativeTable.getAlbumId() + " Genre id: " + associativeTable.getGenreId());
        }

        List<Album> albumList = albumDao.tool("src\\main\\java\\org\\example\\Optional\\albumlist.csv");

        String RED = "\033[0;31m";
        String RESET = "\033[0m";

        for(Album album1 : albumList)
        {
            System.out.println(RED + "Id: " + RESET + album1.getAlbumId() + RED + " Release year: " + RESET + album1.getReleaseYear()
                    + RED + " Title: " + RESET + album1.getTitle()
                    + RED + " Artist: " + RESET + album1.getArtist() + RED + " Genres: " + RESET + album1.getGenreList());
        }

        System.out.println();
        List<Artist> artistList = artistDao.tool("src\\main\\java\\org\\example\\Optional\\albumlist.csv");
        for(Artist artist : artistList)
        {
            System.out.println(RED + "Id: " + RESET + artist.getArtistId() + RED + " Name: " + RESET + artist.getArtistName());
        }

        System.out.println();
        List<Genre> genreList = genreDao.tool("src\\main\\java\\org\\example\\Optional\\albumlist.csv");
        for(Genre genre3 : genreList)
        {
            System.out.println(RED + "Id: " + RESET + genre3.getGenreId() + RED + " Name: " + RESET + genre3.getGenreName());
        }
        connection.close();
    }
}