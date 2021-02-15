package com.codepath.apps.restclienttemplate.models;

<<<<<<< HEAD
import android.provider.ContactsContract;
import android.util.JsonReader;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

=======
import android.util.JsonReader;

>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
<<<<<<< HEAD
import org.parceler.Parcel;
=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
@Parcel
@Entity(foreignKeys = @ForeignKey(entity= User.class, parentColumns = "id", childColumns = "userId"))
public class Tweet {
    @PrimaryKey
    @ColumnInfo
    public long id;

    @ColumnInfo
    public String body;

    @ColumnInfo
    public String createdAt;

    @ColumnInfo
    public long userId;

    @Ignore
    public User user;


    public Tweet() {}

=======

public class Tweet {

    public String body;
    public String createdAt;
    public long id;
    TimeFormatter timeFormatter;
    public User user;


>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.id = jsonObject.getLong("id");
<<<<<<< HEAD
        User user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.user = user;
        tweet.userId = user.id;
=======
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets  = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

    public static String getFormattedTimeStamp(String createdAt) {
        String formattedTime = TimeFormatter.getTimeDifference(createdAt);
        return formattedTime;

    }
}
