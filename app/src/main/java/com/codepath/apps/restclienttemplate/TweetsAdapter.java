package com.codepath.apps.restclienttemplate;

import android.content.Context;
<<<<<<< HEAD
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
=======
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {
    Context mContext;
    List<Tweet> tweets;

    public TweetsAdapter(Context mContext, List<Tweet> tweets) {
        this.mContext = mContext;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);

        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProfileImage;
        TextView tvScreenName;
        TextView tvBody;
        TextView tvName;
        TextView createdAt;

<<<<<<< HEAD

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
=======
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);

>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvName = itemView.findViewById(R.id.tvUserName);
            createdAt = itemView.findViewById(R.id.tvCreatedAt);
<<<<<<< HEAD

        }


=======
        }

>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText("@" + tweet.user.screenName);
            tvName.setText(tweet.user.name);
            String formattedTweet = Tweet.getFormattedTimeStamp(tweet.createdAt);
            createdAt.setText(formattedTweet);

            Glide.with(mContext).load(tweet.user.imageUrl).into(ivProfileImage);

        }
<<<<<<< HEAD



=======
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
    }

}
