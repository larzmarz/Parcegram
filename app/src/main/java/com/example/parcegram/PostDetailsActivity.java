package com.example.parcegram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.parse.ParseFile;

public class PostDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";
    TextView tvUsernameDetails;
    ImageView ivPostDetail;
    TextView tvDescriptionDetails;
    TextView tvDate;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        tvDate = findViewById(R.id.tvDate);
        tvDescriptionDetails = findViewById(R.id.tvDecriptionDetails);
        ivPostDetail = findViewById(R.id.ivPostDetail);
        tvUsernameDetails = findViewById(R.id.tvUsernameDetails);

        post = (Post) getIntent().getParcelableExtra(EXTRA_CONTACT);


        // Bind the post data to the view elements
        tvDescriptionDetails.setText(post.getDescription());
        tvUsernameDetails.setText(post.getUser().getUsername());
        tvDate.setText(post.getCreatedAt().toString());
        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(this).load(post.getImage().getUrl()).into(ivPostDetail);
        }
    }
}
