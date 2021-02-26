package se.iths.springproject.entities;

import javax.persistence.*;

@Entity

@Table(name="music.songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String album;
    private String artist;
    private int length;                         //Length in seconds

    public Song(){

    }
    public Song(String title, String album,String artist , int length) {
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.length = length;
    }

    public Song(int id, String title, String album, String artist, int length) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", length=" + length +
                '}';
    }
}
