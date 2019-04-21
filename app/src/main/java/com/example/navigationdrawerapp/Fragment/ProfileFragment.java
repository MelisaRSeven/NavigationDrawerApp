package com.example.navigationdrawerapp.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.navigationdrawerapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    FirebaseUser currUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageButton profileLink = view.findViewById(R.id.profile_instagram);

        TextView profileMail = view.findViewById(R.id.profile_mail);
        profileMail.setText(currUser.getEmail());

        profileLink.setOnClickListener(v -> {
            String instagramURL = "https://www.instagram.com/melisar.seven/?hl=tr";

            Intent openLinkBrowser = new Intent(Intent.ACTION_VIEW);
            openLinkBrowser.setData(Uri.parse(instagramURL));
            startActivity(openLinkBrowser);
        });

        return view;
    }

}
