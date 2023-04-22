package org.example.Compulsory;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        Connection connection = Singleton.createConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);

        Reader reader = new BufferedReader(new FileReader("src/script/create.sql"));

        scriptRunner.runScript(reader);

        Album album = new Album("1", 2023, "A", "Artist1");
        Album album2 = new Album("2", 2010, "B", "Artist2");

        AlbumDao albumDao = new AlbumDao();
        albumDao.createAlbum(album);
        albumDao.createAlbum(album2);
        List<Album> albums = albumDao.selectAll();

        Album a1 = albumDao.getById("1");
        System.out.println(a1.getAlbumId() + " " + a1.getReleaseYear() + " " + a1.getTitle() + " " + a1.getArtist());
        System.out.println();

        for(Album album1 : albums){
            System.out.println(album1.getAlbumId() + " " + album1.getReleaseYear() + " " + album1.getTitle() + " " + album1.getArtist());
        }
    }
}