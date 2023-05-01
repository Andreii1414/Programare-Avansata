package org.example.Optional;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
    /**
     * Adauga un album primit ca parametru in tabelul albums
     * @param album
     * @throws SQLException
     */
    public void createAlbum(Album album) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into albums(id, releaseYear, title, artist, genre)  VALUES(?,?,?,?,?)");
        statement.setString(1, album.getAlbumId());
        statement.setString(2, String.valueOf(album.getReleaseYear()));
        statement.setString(3, String.valueOf(album.getTitle()));
        statement.setString(4, String.valueOf(album.getArtist()));
        statement.setString(5, String.valueOf(album.getGenreList()));
        statement.executeUpdate();
        //connection.commit();
    }

    /**
     * @return album table
     * @throws SQLException
     */
    public List<Album> selectAll() throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from albums");
        List<Album> albums = new ArrayList<>();

        while(resultSet.next())
        {
            Album album = new Album(resultSet.getString("id"), resultSet.getInt("releaseYear"),
                    resultSet.getString("title"), resultSet.getString("artist"));


            album.setGenreList(resultSet.getString("genre"));

            albums.add(album);
        }
        return albums;
    }

    /**
     * @param id
     * @return albumul cu id-ul primit ca parametru
     * @throws SQLException
     */
    public Album getById(String id) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from albums where id= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        Album album = new Album();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            album.setAlbumId(resultSet.getString("id"));
            album.setReleaseYear(resultSet.getInt("releaseYear"));
            album.setTitle(resultSet.getString("title"));
            album.setArtist(resultSet.getString("artist"));

            album.setGenreList(resultSet.getString("genre"));
        }
        if(check)
            return album;
        else return null;
    }

    /**
     * @param title
     * @return albumul cu titlul primit ca parametru
     * @throws SQLException
     */
    public Album getByTitle(String title) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from albums where title= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        Album album = new Album();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            album.setAlbumId(resultSet.getString("id"));
            album.setReleaseYear(resultSet.getInt("releaseYear"));
            album.setTitle(resultSet.getString("title"));
            album.setArtist(resultSet.getString("artist"));

            album.setGenreList(resultSet.getString("genre"));
        }
        if(check)
            return album;
        else return null;
    }

    public List<Album> tool(String filename)
    {
        String line;
        String delimiter = ",";
        List<Album> albums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(delimiter);
                Album album = new Album();

                album.setAlbumId(fields[0]);
                if (fields[1].matches("\\d+")) {
                    album.setReleaseYear(Integer.parseInt(fields[1]));
                }
                album.setTitle(fields[2]);
                album.setArtist(fields[3]);
                String genre = fields[4];
                for(int i = 5; i < fields.length; i++) {
                    genre += fields[i];
                }
                album.setGenreList(genre);

                albums.add(album);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return albums;
    }
}
