package ca.ualberta.cs.lonelytwitter;

class TweetTooLongException extends Exception {
    TweetTooLongException(){
        super("The message is too long! Please keep your tweets within 140 charcters.");
    }
}
