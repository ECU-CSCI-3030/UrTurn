package com.example.aaron.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.content.Intent;
import android.util.Log;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mAuth=FirebaseAuth.getInstance();

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        Button b = (Button) v.findViewById(R.id.btnSignOut);
        b.setOnClickListener(this);
        return v;

       // return inflater.inflate(R.layout.fragment_profile, container, false);
    }



    public void onClickBtn(View v)
    {
        switch (v.getId()) {

        case R.id.btnSignOut:
            mAuth=FirebaseAuth.getInstance();

            mAuth.signOut();
            Intent intent = new Intent( getActivity(), logIn.class);
            startActivity(intent);


            getActivity().finish();
            break;
        }

    }

    private void signUserOut() {
        mAuth.signOut();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnSignOut:
                mAuth=FirebaseAuth.getInstance();

                mAuth.signOut();
                Intent intent = new Intent( getActivity(), logIn.class);
                startActivity(intent);


                getActivity().finish();
                break;
        }
    }
}

