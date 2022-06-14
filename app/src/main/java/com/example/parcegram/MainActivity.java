package com.example.parcegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.btLogout);
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
    private void goLoginActivity(){
        Intent i = new Intent(MainActivity.this, loginActivity.class);
        startActivity(i);
        finish();
    }
}