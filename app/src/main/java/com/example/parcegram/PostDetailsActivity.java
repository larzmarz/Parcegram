package com.example.parcegram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.parse.ParseFile;

public class PostDetailsActivity extends AppCompatActivity {

    TextView tvUsernameDetails;
    ImageView ivPostDetail;
    TextView tvDescriptionDetails;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        tvDate = findViewById(R.id.tvDate);
        tvDescriptionDetails = findViewById(R.id.tvDecriptionDetails);
        ivPostDetail = findViewById(R.id.ivPostImage);
        tvUsernameDetails = findViewById(R.id.tvUsername);

    }
}
