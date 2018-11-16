package com.example.aaron.myapplication;

import android.arch.lifecycle.ViewModelStore;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class logIn extends AppCompatActivity {
    public Button log;
    private VideoView mVideoView;
    private TextView email;
    private TextView password;
    private FirebaseAuth mAuth;

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return super.getViewModelStore();
    }

    public void init() {

        email = (TextView) findViewById(R.id.emailText);

        password = (TextView) findViewById(R.id.passwordText);

        log = (Button) findViewById(R.id.loginButton);

        mAuth = FirebaseAuth.getInstance();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                //logIn.login(email.toString().trim(), password.toString().trim());

                Intent intent = new Intent(logIn.this, MainActivity.class);
                startActivity(intent);

                logIn.this.finish();
            }

        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        init();

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


    }

    public void createAccount(){

        mAuth.createUserWithEmailAndPassword(email.toString().trim(), password.toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("TAG", "createUserWithEmail: Success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    //updateUI(user);

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(logIn.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    //updateUI(null);
                }

                // ...
            }
        });


    }

    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("TAG", "signInWithEmail : success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    //updateUI(user);
                }
                else {
                    Log.w("TAG", "signInWithEmail : failure", task.getException());
                    Toast.makeText(logIn.this,"Authentication failed.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
