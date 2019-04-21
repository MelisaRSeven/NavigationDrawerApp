package com.example.navigationdrawerapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationdrawerapp.Model.Post;
import com.example.navigationdrawerapp.R;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Post> postlist;

    public PostAdapter(LayoutInflater layoutInflater, List<Post> postList) {
        this.layoutInflater= layoutInflater;
        this.postlist = postList;
    }

    @Override
    public int getCount() {                                                     //size of postList
        return postlist.size();
    }

    @Override
    public Object getItem(int position) {                                       //returns first item on list
        return postlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {             //our view
        view = layoutInflater.inflate(R.layout.list_item_view, null);

        Post post = postlist.get(position);

        ImageView postImage = view.findViewById(R.id.post_image);
        postImage.setImageResource(post.getPictureID());

        TextView postTitle = view.findViewById(R.id.post_title);
        postTitle.setText(post.getTitle());

        TextView postDate = view.findViewById(R.id.post_time);
        postDate.setText(post.getTime());

        TextView postContent = view.findViewById(R.id.post_content);
        postContent.setText(post.getContent());

        TextView postUserMail = view.findViewById((R.id.post_user_mail));
        postUserMail.setText(post.getMail());

        return view;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public List<Post> getPostlist() {
        return postlist;
    }

    public void setPostlist(List<Post> postlist) {
        this.postlist = postlist;
    }
}
