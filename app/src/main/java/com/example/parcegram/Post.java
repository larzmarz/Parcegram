package com.example.parcegram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_LIKEDBY_BY = "LikedBy";
    public static final String KEY_PHOTO_PFP = "profilePhoto";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }
    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }
    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }
    public String getCreated(){
        return getString(KEY_CREATED_KEY);
    }
    public void setCreated(ParseFile date){
        put(KEY_CREATED_KEY, date);
    }
    public String likeCountDisplayText(){
        String likesText = String.valueOf(getLikedBy().size());
        likesText += getLikedBy().size() == 1? " like" : " likes";
        return likesText;
    }
    public List<String> getLikedBy(){
        List<String> likedBy = getList(KEY_LIKEDBY_BY);
        if(likedBy == null){
            likedBy = new ArrayList();
        }
        return likedBy;
    }
    public void setLikedBy(List<String> likedBy){
        put(KEY_LIKEDBY_BY, likedBy);
    }
    public ParseFile getProfilePhoto(){
        return getParseFile(KEY_PHOTO_PFP);
    }
    public void setProfilePicture(ParseFile parseFile){
        put(KEY_PHOTO_PFP, parseFile);
    }
}
