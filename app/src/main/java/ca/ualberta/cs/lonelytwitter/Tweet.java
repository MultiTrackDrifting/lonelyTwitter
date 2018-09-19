package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
//Can't edit actual tweets as stored in the program to use these without rewritting save/load
//And thats next lab, so this can stay here for now.
//figure out how to actually pick a mood afterwards as well.

//I'm also not doing all that stuff we saw in lab, I assume its just examples because its not overly useful.
public class Tweet {
    private ArrayList<Mood> Moods = new ArrayList<Mood>();
    private String message;
    private Date curtime;
    private static final Integer MAX_CHARS= 140;

    public Tweet(String text){
        this.message = text;
        curtime = new Date();
    }
    public Tweet(){
        this.message = "Default message!";
        curtime = new Date();
    }
    public void AddMood(Mood x){
        Moods.add(x);
    }
    public Date getDate(){
        return curtime;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String newmessage) throws TweetTooLongException {
        if(message.length() > Tweet.MAX_CHARS){
            throw new TweetTooLongException();
        }
        message = newmessage;
    }
}
