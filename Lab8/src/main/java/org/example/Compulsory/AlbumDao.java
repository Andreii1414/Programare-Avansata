package org.example.Compulsory;

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
        Connection connection = Singleton.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into albums(id, releaseYear, title, artist, genre)  VALUES(?,?,?,?,?)");
        statement.setString(1, album.getAlbumId());
        statement.setString(2, String.valueOf(album.getReleaseYear()));
        statement.setString(3, String.valueOf(album.getTitle()));
        statement.setString(4, String.valueOf(album.getArtist()));
        statement.setString(5, String.valueOf(album.getGenreList()));
        statement.executeUpdate();
        connection.commit();
    }

    /**
     * @return album table
     * @throws SQLException
     */
    public List<Album> selectAll() throws SQLException {
        Connection connection = Singleton.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from albums");
        List<Album> albums = new ArrayList<>();

        while(resultSet.next())
        {
            Album album = new Album(resultSet.getString("id"), resultSet.getInt("releaseYear"),
                    resultSet.getString("title"), resultSet.getString("artist"));


            List<Genre> genreList = new ArrayList<>();
            String[] genres = resultSet.getString("genre").split(" ");
            for (String genre : genres) {
                genreList.add(new Genre(genre.trim()));
            }
            album.setGenreList(genreList);

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
        Connection connection = Singleton.getConnection();
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

            List<Genre> objectList2 = new ArrayList<>();
            while(resultSet.next()) {
                Object obj = resultSet.getObject("artist");
                objectList2.add((Genre) obj);
            }
            album.setGenreList(objectList2);
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
        Connection connection = Singleton.getConnection();
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

            List<Genre> objectList2 = new ArrayList<>();
            while(resultSet.next()) {
                Object obj = resultSet.getObject("artist");
                objectList2.add((Genre) obj);
            }
            album.setGenreList(objectList2);
        }
        if(check)
            return album;
        else return null;
    }

}
