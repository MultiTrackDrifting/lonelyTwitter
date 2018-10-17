package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }
    public Tweet getTweet(int x){
        return tweets.get(x);
    }
    public void delete(Tweet x){
        tweets.remove(x);
    }
    public int getCount(){
        return tweets.size();
    }
    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> ret = new ArrayList<Tweet>(tweets);
        Collections.sort(ret,new Comparator<Tweet>(){
            public int compare(Tweet o1, Tweet o2){
                if(o1.getDate() == o2.getDate())
                    return 0;
                return o1.getDate().compareTo(o2.getDate());
            }});
        return ret;

    }
}
