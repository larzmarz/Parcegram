package com.example.parcegram;

import android.app.Application;

import com.parse.Parse;


public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ItZHEGYpGmz8Fd3OsZnbBh7Gu4MnAhm5TjoS8PiJ")
                .clientKey("UfGgq9gZOB4yFNg5jizkb8bi8NafHhFKIK0G7nYS")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
