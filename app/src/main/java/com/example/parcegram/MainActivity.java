package com.example.parcegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public Button logout;
    public Button btSubmit;
    public EditText etDescription;
    public Button btTakePicture;
    public ImageView ivPostImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSubmit = findViewById(R.id.btSubmit);
        btTakePicture = findViewById(R.id.btTakePicture);
        etDescription = findViewById(R.id.etDescription);
        ivPostImage = findViewById(R.id.ivPostImage);
        logout = findViewById(R.id.btLogout);

        queryPosts();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                Toast.makeText(MainActivity.this, "LogOut Successful!", Toast.LENGTH_SHORT).show();
                goLoginActivity();
            }
        });

    }
    private void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                 if(e != null){
                     Log.e(TAG, "Issue with getting posts", e);
                     return;
                 }
                 for(Post post : posts){
                     Log.i(TAG, "Post:" + post.getDescription() + ", username: " + post.getUser().getUsername());
                 }
            }
        });
    }

    private void goLoginActivity(){
        Intent i = new Intent(MainActivity.this, loginActivity.class);
        startActivity(i);
        finish();
    }
}