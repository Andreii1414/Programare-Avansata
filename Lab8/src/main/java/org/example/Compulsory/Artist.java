package org.example.Compulsory;

public class Artist {
    private String artistId, artistName;

    public Artist(String artistName, String artistId) {
        this.artistName = artistName;
        this.artistId = artistId;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
