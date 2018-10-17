package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }
    // JUnit test method for adding tweets into list
    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));

    }

    // method for checking whether a tweet is in the tweetlist
    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweets(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("get tweet check");

        tweetList.add(tweet);
        Tweet gettweet = tweetList.getTweet(0);

        assertEquals(gettweet.getMessage(),tweet.getMessage());
        assertEquals(gettweet.getDate(),tweet.getDate());
    }
    public void testDelete(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("this is stupid");

        tweetList.add(tweet);
        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));

    }

    public void testCount(){
        TweetList tweetList = new TweetList();

        for(Integer x = 1;x<100;x++){
            tweetList.add(new NormalTweet(x.toString()));
            assertTrue(tweetList.getCount()==x);
        }
    }

    public void testGet(){
        TweetList tweetList = new TweetList();
        Tweet rando;
        Date date = new Date();
        for(Integer x = 1;x<50;x++){
            rando = new NormalTweet(x.toString());
            date.setYear(2018-x);
            rando.setDate(date);
            tweetList.add(rando);
            assertTrue(tweetList.getCount()==x);
        }
        ArrayList<Tweet> trash = tweetList.getTweets();
        date = trash.get(0).getDate();
        for(Tweet x : trash){
            assert(x.getDate().compareTo(date)>=0);
            date = x.getDate();
        }
    }

    public void testDupes(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("this is stupid");

        tweetList.add(tweet);

        try{
            tweetList.add(tweet);
        }
        catch(IllegalArgumentException x){
            return;//this is a pass
        }

        assertEquals("This is a fail",2+2,5);
    }

}
