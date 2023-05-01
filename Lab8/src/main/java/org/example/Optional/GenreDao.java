package org.example.Optional;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    public void createGenre(Genre genre) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into genres(id, name)  VALUES(?,?)");
        statement.setString(1, genre.getGenreId());
        statement.setString(2, genre.getGenreName());
        statement.executeUpdate();
        //connection.commit();
    }

    public List<Genre> selectAll() throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from genres");
        List<Genre> genres = new ArrayList<>();

        while(resultSet.next())
        {
            Genre genre = new Genre(resultSet.getString("id"), resultSet.getString("name"));

            genres.add(genre);
        }
        return genres;
    }

    public Genre getById(String id) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from genres where id= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        Genre genre = new Genre();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            genre.setGenreId(resultSet.getString("id"));
            genre.setGenreName(resultSet.getString("name"));
        }
        if(check)
            return genre;
        else return null;
    }

    public Genre getByName(String name) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from genres where name= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        Genre genre = new Genre();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            genre.setGenreId(resultSet.getString("id"));
            genre.setGenreName(resultSet.getString("name"));
        }
        if(check)
            return genre;
        else return null;
    }

    public List<Genre> tool(String filename)
    {
        String line;
        int id = 1;
        String delimiter = ",";
        List<Genre> genres = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(delimiter);
                Genre genre = new Genre();
                genre.setGenreId(String.valueOf(id));
                genre.setGenreName(fields[5]);

                boolean x = true;
                for(Genre genre1 : genres)
                {
                    if(genre1.getGenreName().equals(genre.getGenreName()))
                    {
                        x = false;
                        break;
                    }
                }

                if(x)
                {
                    genres.add(genre);
                    id++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return genres;
    }
}
