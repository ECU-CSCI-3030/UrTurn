package com.example.aaron.myapplication;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelStore;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.content.Intent;



/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class logIn extends AppCompatActivity {
    public Button log;
    private VideoView mVideoView;

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return super.getViewModelStore();
    }

    public void init() {
        log = (Button) findViewById(R.id.googleLogin);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

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
            //Most methods in this class will be firebase oriented

}
