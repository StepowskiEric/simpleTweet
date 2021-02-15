package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReplyActivity extends AppCompatActivity {
    TextView tvFullName;
    TextView  tvUsername;
    TextView tvReplyUsername;
    TextView inReplyToUsername;
    ImageView ivAvatar;
    Button replyTweetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        tvFullName = findViewById(R.id.tvFullName);
        tvUsername = findViewById(R.id.tvUserName);
        inReplyToUsername = findViewById(R.id.tvInReplyTo);
        tvReplyUsername = findViewById(R.id.tvReplyUserName);
        ivAvatar = findViewById(R.id.replyAvatar);
        replyTweetButton = findViewById(R.id.btnReplyTweet);
    }
}