package com.codepath.apps.restclienttemplate;

<<<<<<< HEAD
import androidx.annotation.Nullable;
=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.widget.Toolbar;

<<<<<<< HEAD
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.TweetDao;
import com.codepath.apps.restclienttemplate.models.TweetWithUser;
import com.codepath.apps.restclienttemplate.models.User;
=======
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.RelativeLayout;

import com.codepath.apps.restclienttemplate.models.Tweet;
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
<<<<<<< HEAD
import org.parceler.Parcel;
import org.parceler.Parcels;
=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class TimelineActivity extends AppCompatActivity {

<<<<<<< HEAD
    public final int REQUEST_CODE = 1;
    public static final String TAG = "TIME_LINE_ACTIVITY";
    public TwitterClient client;
    List<Tweet> tweets;
    TweetDao tweetDao;
=======
    public static final String TAG = "TIME_LINE_ACTIVITY";
    public TwitterClient client;
    List<Tweet> tweets;
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
    Toolbar toolbar;
    RecyclerView rvTweets;
    TweetsAdapter adapter;
    SwipeRefreshLayout swipeContainer;
<<<<<<< HEAD
    ImageButton ivBtnReply;
=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
    EndlessRecyclerViewScrollListener scrollListener;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        rvTweets = findViewById(R.id.rvTweets);
        tweets = new ArrayList<>();
        client =  TwitterApp.getRestClient(this);
<<<<<<< HEAD
        ivBtnReply = findViewById(R.id.ibReply);
        tweetDao = ((TwitterApp) getApplicationContext()).getMyDatabase().tweetDao();
=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_twitter);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);





        adapter = new TweetsAdapter(this,tweets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvTweets.setLayoutManager(linearLayoutManager);
        rvTweets.setAdapter(adapter);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        rvTweets.addItemDecoration(new DividerItemDecoration(rvTweets.getContext(), DividerItemDecoration.VERTICAL));
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.i(TAG, "fetching new data");
                populateHomeTimeline();

            }
        });







<<<<<<< HEAD



=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                    Log.i(TAG, "OnLoadMore" + page);
                    loadMoreData();
            }
        };
        rvTweets.addOnScrollListener(scrollListener);
<<<<<<< HEAD
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "Showing database");
                List<TweetWithUser> tweetWithUsers = tweetDao.recentItems();
                List<Tweet> tweetsFromDB = TweetWithUser.getTweetList(tweetWithUsers);
                adapter.clear();
                adapter.addAll(tweetsFromDB);
            }
        });
=======

>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
        populateHomeTimeline();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_bar, menu);
        return true;
    }

<<<<<<< HEAD
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.composeicon) {
            Intent intent = new Intent(this, ComposeActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Tweet tweet = Parcels.unwrap(data.getParcelableExtra("tweet"));
            tweets.add(0,tweet);
            adapter.notifyItemInserted(0);
            rvTweets.smoothScrollToPosition(0);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
    private void loadMoreData() {
        client.getNextPageOfTweets(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                    Log.i(TAG, "onSuccess load more data" + json.toString());
                    JSONArray jsonArray = json.jsonArray;
                    try {
                        List<Tweet> tweets = Tweet.fromJsonArray(jsonArray);
                        adapter.addAll(tweets);
                    } catch (JSONException e) {
                        e.getMessage();
                    }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.i(TAG, "onFailure load more data", throwable);
            }
        }, tweets.get(tweets.size()-1).id);
    }

    private void populateHomeTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                    JSONArray jsonArray = json.jsonArray;
                try {
<<<<<<< HEAD
                    List<Tweet> tweetsFromNetWork = Tweet.fromJsonArray(jsonArray);
                    adapter.clear();
                    adapter.addAll(tweetsFromNetWork);
                    //Tells the container to stop refreshing
                    swipeContainer.setRefreshing(false);
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG, "Saving data into database");
                            List<User> userFromNetWork = User.fromJsonTweetArray(tweetsFromNetWork);
                            tweetDao.insertModel(userFromNetWork.toArray(new User[0]));
                            tweetDao.insertModel(tweetsFromNetWork.toArray(new Tweet[0]));
                        }
                    });
=======
                    adapter.clear();
                    adapter.addAll(Tweet.fromJsonArray(jsonArray));
                    //Tells the container to stop refreshing
                    swipeContainer.setRefreshing(false);
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
                } catch (JSONException e) {
                    Log.e(TAG, "Json exception", e);
                    e.printStackTrace();
                }
            }

<<<<<<< HEAD


=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.i(TAG, "On Failure", throwable);
            }
        });
    }
}