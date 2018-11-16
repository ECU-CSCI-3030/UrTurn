package com.example.aaron.myapplication;

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
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class logIn extends AppCompatActivity implements View.OnClickListener{
    private final String TAG="FB_SIGNIN";

    public Button log;
    private VideoView mVideoView;

    //auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    private EditText etPass;
    private EditText etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //click handlers
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener((View.OnClickListener) this);

        etEmail= (EditText)findViewById(R.id.txtLogin);
        etPass= (EditText)findViewById(R.id.txtPass);

        mAuth=FirebaseAuth.getInstance();

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();
                if (user !=null){
                    Log.d(TAG, "Signed in: " + user.getUid());
                }
                else{
                    Log.d(TAG, "Currently Signed Out" );                }
            }
        };



        //init();

        mVideoView = (VideoView) findViewById(R.id.bgVideoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bg_video);

        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        updateStatus();

    }



    @Override
    public void onStart(){
        super.onStart();
        //add auth lisn
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        //remove auth lisn
        if (mAuthListener !=null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                signUserIn();
                break;

            case R.id.btnRegister:
                createUserAccount();
                break;

            // case R.id.btnSignOut:
            // signUserOut();
            // break;
        }
    }
    private boolean checkFormFields() {
        String email, password;

        email = etEmail.getText().toString();
        password = etPass.getText().toString();

        if (email.isEmpty()) {
            etEmail.setError("Email Required");
            return false;
        }
        if (password.isEmpty()){
            etPass.setError("Password Required");
            return false;
        }

        return true;
    }

    private void updateStatus() {
        TextView tvStat = (TextView)findViewById(R.id.tvSignInStatus);
        // TODO: get the current user
        FirebaseUser user = mAuth.getCurrentUser();


        if (user != null) {
            tvStat.setText("Signed in: " + user.getEmail());
            init();

        }
        else {
            tvStat.setText("Signed Out");
        }

    }

    private void updateStatus(String stat) {
        TextView tvStat = (TextView)findViewById(R.id.tvSignInStatus);
        tvStat.setText(stat);
    }

    private void signUserIn() {
        if (!checkFormFields())
            return;

        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        // TODO: sign the user in with email and password credentials
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(logIn.this, "Signed In", Toast.LENGTH_SHORT).show();
                    init();
                }
                else{
                    Toast.makeText(logIn.this, "Sign in Failed", Toast.LENGTH_SHORT).show();
                }
                updateStatus();
            }
        });

    }

    private void signUserOut() {
        // TODO: sign the user out
        mAuth.signOut();
        updateStatus();
    }

    private void createUserAccount(){
        if (!checkFormFields())
            return;

        String email= etEmail.getText().toString();
        String password= etPass.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(logIn.this, "User was created", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(logIn.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void init() {


                Intent intent = new Intent(logIn.this, MainActivity.class);
                startActivity(intent);

                logIn.this.finish();



    }


}
