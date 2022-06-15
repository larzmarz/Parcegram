package com.example.parcegram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ItZHEGYpGmz8Fd3OsZnbBh7Gu4MnAhm5TjoS8PiJ")
                .clientKey("UfGgq9gZOB4yFNg5jizkb8bi8NafHhFKIK0G7nYS")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
