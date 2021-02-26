package se.iths.springproject.dtos;

//Dto = data transfer object
//Används för att skicka information mellan olika lager av applikationen
public class SongDto {
    private int id;
    private String title;
    private String album;
    private String artist;
    private int length;

    public SongDto(){

    }

    public SongDto(int id, String title, String album, String artist, int length) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
