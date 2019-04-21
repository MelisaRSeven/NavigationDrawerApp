package com.example.navigationdrawerapp.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.navigationdrawerapp.Adapter.PostAdapter;
import com.example.navigationdrawerapp.Model.Post;
import com.example.navigationdrawerapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Post> postList =new ArrayList<>();
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false); //bir şey gelmezse ekrana basmasın diye null

        listView = view.findViewById(R.id.post_list_view);

        postList.add(new Post(R.drawable.landscape3, "Trabzonda", "bla bla bla bla", "20-03-1998", "melisar.seven@gmail.com"));
        postList.add(new Post(R.drawable.landscape01, "Mardinde", "lba lba lba lba","24-03-2006","blablabla@gmail.com"));
        postList.add(new Post(R.drawable.landscape4, "Lorem Iperum", "alb alb alb alb", "17-07-2002", "example@outlook.com"));

        PostAdapter postAdapter = new PostAdapter(getLayoutInflater(), postList);

        Collections.sort(postList, (d1, d2) -> d1.timeCalculator().compareTo(d2.timeCalculator()));

        Collections.reverse(postList);

        listView.setAdapter(postAdapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(postList.get(position).getTitle());
            builder.setMessage(postList.get(position).getContent());
            builder.show();
        });

        return view;
    }
}
