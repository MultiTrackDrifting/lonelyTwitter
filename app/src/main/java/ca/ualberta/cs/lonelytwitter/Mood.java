package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date timestamp;

    public abstract String get_mood();

    public Mood(){
        timestamp = new Date();
    }
    public Mood(Date Init_date){
        timestamp = Init_date;
    }

}

