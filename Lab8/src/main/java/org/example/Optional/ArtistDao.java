package org.example.Optional;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {
    public void createArtist(Artist artist) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into artists(id, name)  VALUES(?,?)");
        statement.setString(1, artist.getArtistId());
        statement.setString(2, artist.getArtistName());
        statement.executeUpdate();
        //connection.commit();
    }

    public List<Artist> selectAll() throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from artists");
        List<Artist> artists = new ArrayList<>();

        while(resultSet.next())
        {
            Artist artist = new Artist(resultSet.getString("name"), resultSet.getString("id"));

            artists.add(artist);
        }
        return artists;
    }

    public Artist getById(String id) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from artists where id= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        Artist artist = new Artist();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            artist.setArtistId(resultSet.getString("id"));
            artist.setArtistName(resultSet.getString("name"));
        }
        if(check)
            return artist;
        else return null;
    }

    public Artist getByName(String name) throws SQLException {
        HikariConfig config = new HikariConfig("src\\main\\java\\org\\example\\Optional\\hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        String query = "select * from artists where name= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        Artist artist = new Artist();
        ResultSet resultSet = statement.executeQuery();
        boolean check = false;

        while(resultSet.next()){
            check = true;
            artist.setArtistId(resultSet.getString("id"));
            artist.setArtistName(resultSet.getString("name"));
        }
        if(check)
            return artist;
        else return null;
    }

    public List<Artist> tool(String filename)
    {
        String line;
        int id = 1;
        String delimiter = ",";
        List<Artist> artists = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(delimiter);
                Artist artist = new Artist();
                artist.setArtistId(String.valueOf(id));
                artist.setArtistName(fields[3]);

                boolean x = true;
                for(Artist artist1 : artists)
                {
                    if(artist1.getArtistName().equals(artist.getArtistName()))
                    {
                        x = false;
                        break;
                    }
                }

                if(x)
                {
                    artists.add(artist);
                    id++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return artists;
    }
}
