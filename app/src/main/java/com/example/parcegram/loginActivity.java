package com.example.parcegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class loginActivity extends AppCompatActivity {
        public static final String TAG = "LogActivity";
        public EditText tvUsername;
        public EditText tvPassword;
        public Button btLogin;
        public Button btSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

       if(ParseUser.getCurrentUser() !=null ) {
            goMainActivity();
        }

        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        btLogin = findViewById(R.id.btLogin);
        btSignup = findViewById(R.id.btSignup);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = tvUsername.getText().toString();
                String password = tvPassword.getText().toString();
                loginUser(username, password);

            }
        });
    }

    public void loginUser(String username, String password){
        Log.i(TAG, "Attempting to login user" + username + " " + password);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(loginActivity.this, "Issues with login!", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(loginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void goMainActivity(){
        Intent i = new Intent(loginActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    private void goFeedActivity(){
        Intent i = new Intent(loginActivity.this, FeedActivity.class);
        startActivity(i);
        finish();
    }

}
