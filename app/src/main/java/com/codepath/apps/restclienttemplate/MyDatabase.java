package com.codepath.apps.restclienttemplate;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.codepath.apps.restclienttemplate.models.SampleModel;
import com.codepath.apps.restclienttemplate.models.SampleModelDao;
<<<<<<< HEAD
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.TweetDao;
import com.codepath.apps.restclienttemplate.models.User;

@Database(entities={SampleModel.class, Tweet.class, User.class}, version=2)
public abstract class MyDatabase extends RoomDatabase {
    public abstract SampleModelDao sampleModelDao();
    public abstract TweetDao tweetDao();
=======

@Database(entities={SampleModel.class}, version=1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract SampleModelDao sampleModelDao();
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96

    // Database name to be used
    public static final String NAME = "MyDataBase";
}
