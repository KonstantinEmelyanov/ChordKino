package ru.emelyanovkonstantin.chordkino.dto;

/**
 * Created by EmelyanovKonstantin on 25.07.2018.
 */
public class RemindDTO {
    private String title;
    private String year;

    public RemindDTO(String title){
        this.title =title;
      //  this.year =year;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public  String getTitle(){
        return title;
    }
}
