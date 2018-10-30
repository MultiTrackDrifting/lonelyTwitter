package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {
    private String message;//should be private
    private Date date; //should be private

    Tweet(String message){ //can be package private
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString(){
        return message;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}
