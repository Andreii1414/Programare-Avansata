package org.example.Compulsory;

public class AssociativeTable {
    private String albumId, genreId;

    public AssociativeTable(String albumId, String genreId) {
        this.albumId = albumId;
        this.genreId = genreId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }
}
