package com.example.parcegram;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private Context context;
    private List<Post> posts;
    private List<String> likedBy;
    private SwipeRefreshLayout swipeContainer;


    public void clear(){
        posts.clear();
        notifyDataSetChanged();
    }
    public void addAll(List<Post> post){
        posts.addAll(post);
        notifyDataSetChanged();
    }
    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUsername;
        private ImageView ivImage;
        private TextView tvDescription;
        private TextView btPostD;
        private ImageButton iBLike;
        private TextView tvLikeCnt;
        private TextView tvUserN;
        private ImageView ivProfile;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            btPostD = itemView.findViewById(R.id.tvTime);
            iBLike = itemView.findViewById(R.id.ibLike);
            tvLikeCnt = itemView.findViewById(R.id.tvLikeCount);
            tvUserN = itemView.findViewById(R.id.tvUserN);
            ivProfile = itemView.findViewById(R.id.ivProfile);
        }

        public void bind(Post post) {
            // Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            btPostD.setText(post.getCreatedAt().toString());
            tvLikeCnt.setText(post.likeCountDisplayText());
            tvUserN.setText(post.getUser().getUsername());


            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PostDetailsActivity.class);
                    intent.putExtra(PostDetailsActivity.EXTRA_CONTACT, post);
                    context.startActivity(intent);
                }
            });
            iBLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    likedBy = post.getLikedBy();
                    //user has not liked the post
                    if(!likedBy.contains(ParseUser.getCurrentUser().getObjectId())){
                        likedBy.add(ParseUser.getCurrentUser().getObjectId());
                        post.setLikedBy(likedBy);
                        iBLike.setColorFilter(Color.RED);
                    //the post has been liked already
                    }else{
                        likedBy.remove(ParseUser.getCurrentUser().getObjectId());
                        post.setLikedBy(likedBy);
                        iBLike.setColorFilter(Color.WHITE);
                    }
                    post.saveInBackground();
                    tvLikeCnt.setText(post.likeCountDisplayText());
                }
            });
            ivProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity)context;
                    activity.goToProfileTab((User) post.getUser());
                }
            });
        }
    }
}