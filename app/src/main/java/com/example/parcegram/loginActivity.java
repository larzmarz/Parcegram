package com.example.parcegram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class loginActivity extends AppCompatActivity {
        public static final String TAG = "LogActivity";
        public TextView tvUsername;
        public TextView tvPassword;
        public Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        btLogin = findViewById(R.id.btLogin);
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
        Log.i(TAG, "Attempting to login user" + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {

            }
        });

    }

}
