package ru.emelyanovkonstantin.chordkino.dto;

/**
 * Created by EmelyanovKonstantin on 25.07.2018.
 */
public class RemindDTO {
    private int id;
    private String name;
    private int year;
    private String descrition;
    //private  img

    public RemindDTO(int id,String title,int year){
        this.id = id;
        this.name =title;
        this.year = year;
      //  this.year =year;
    }
    public void setName(String title){
        this.name=title;
    }
    public  String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
