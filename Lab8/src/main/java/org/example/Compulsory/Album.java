package org.example.Compulsory;

import java.util.List;

public class Album {
    private String albumId;
    private int releaseYear;
    private String title;
    private String artist;
    private List<Genre> genreList;

    public Album() {
    }

    public Album(String albumId, int releaseYear, String title, String artist) {
        this.albumId = albumId;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
