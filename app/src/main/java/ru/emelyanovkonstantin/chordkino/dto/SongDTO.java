package ru.emelyanovkonstantin.chordkino.dto;

/**
 * Created by EmelyanovKonstantin on 30.07.2018.
 */
public class SongDTO {
    private int id;
    private int album;
    private String  name;

   public SongDTO(int id,int album,String name){
        this.id=id;
        this.album=album;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
