package com.codepath.apps.restclienttemplate.models;



<<<<<<< HEAD
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Parcel
@Entity
public class User {

    @ColumnInfo
    @PrimaryKey
    public long id;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String screenName;

    @ColumnInfo
    public String imageUrl;


    public User() {}


    public static User fromJSON(JSONObject jsonObject ) throws JSONException {
        User user = new User();
        user.id = jsonObject.getLong("id");
=======
import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public String name;
    public String screenName;
    public String imageUrl;



    public static User fromJSON(JSONObject jsonObject ) throws JSONException {
        User user = new User();
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.imageUrl = jsonObject.getString("profile_image_url_https");
        return user;

    }
<<<<<<< HEAD

    public static List<User> fromJsonTweetArray(List<Tweet> tweetsFromNetWork) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < tweetsFromNetWork.size(); i++) {
            users.add(tweetsFromNetWork.get(i).user);
        }
        return users;
    }
=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
}
