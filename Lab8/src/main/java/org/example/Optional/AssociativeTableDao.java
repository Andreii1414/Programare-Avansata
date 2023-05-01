package org.example.Optional;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssociativeTableDao {
    public void createAssociativeTable(AssociativeTable at) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into album_genres(album_id, genre_id)  VALUES(?,?)");
        statement.setString(1, at.getAlbumId());
        statement.setString(2, at.getGenreId());
        statement.executeUpdate();
        //connection.commit();
    }

    public List<AssociativeTable> selectAll() throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from album_genres");
        List<AssociativeTable> ats = new ArrayList<>();

        while(resultSet.next())
        {
            AssociativeTable at = new AssociativeTable(resultSet.getString("album_id"), resultSet.getString("genre_id"));

            ats.add(at);
        }
        return ats;
    }

    public AssociativeTable getByAlbumId(String id) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from album_genres where album_id= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        AssociativeTable at = new AssociativeTable();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            at.setAlbumId(resultSet.getString("album_id"));
            at.setGenreId(resultSet.getString("genre_id"));
        }
        if(check)
            return at;
        else return null;
    }

    public AssociativeTable getByGenreId(String id) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from album_genres where genre_id= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        AssociativeTable at = new AssociativeTable();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            at.setAlbumId(resultSet.getString("album_id"));
            at.setGenreId(resultSet.getString("genre_id"));
        }
        if(check)
            return at;
        else return null;
    }

}
