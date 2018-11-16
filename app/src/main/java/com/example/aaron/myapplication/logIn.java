package com.example.aaron.myapplication;

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

    //Buttons
    public Button login_button;
    public Button register_button;

    //Video
    private VideoView mVideoView;

    //TextViews
    private TextView email;
    private TextView password;

    //Database Reference
    private static FirebaseAuth mAuth;


    public void init() {

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bg_video);

        //background video starting

        mVideoView.setVideoURI(uri);
        mVideoView.start();

        //Views and Buttons
        email = (TextView) findViewById(R.id.emailText);
        password = (TextView) findViewById(R.id.passwordText);
        login_button = (Button) findViewById(R.id.loginButton);
        register_button = (Button) findViewById(R.id.registerButton);
        mAuth = FirebaseAuth.getInstance();

        //Firebase initialization
        mVideoView = (VideoView) findViewById(R.id.bgVideoView);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                login(email.toString().trim(), password.toString().trim());

                Intent intent = new Intent(logIn.this, MainActivity.class);
                startActivity(intent);

                logIn.this.finish();
            }

        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(User.validate(mAuth.getCurrentUser()) == true){
                    createAccount(email.toString().trim(), password.toString().trim());

                    Intent intent = new Intent (logIn.this, MainActivity.class);

                }

                else{
                    updateUI(mAuth.getCurrentUser());
                }

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        init();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });


    }

    public void createAccount(String email, String password){

        mAuth.createUserWithEmailAndPassword(email.trim(), password.trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.e("Account Create Success", "createUserWithEmail: Success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Account Create Fail", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(logIn.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }

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
                    updateUI(user);
                }
                else {
                    Log.w("TAG", "signInWithEmail : failure", task.getException());
                    Toast.makeText(logIn.this,"Authentication failed.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    public void updateUI(FirebaseUser user) {

        if (user != null) {

            Intent intent = new Intent(logIn.this, MainActivity.class);
            startActivity(intent);

        } else {
            Intent intent = new Intent(logIn.this, logIn.class);
        }
    }

}
