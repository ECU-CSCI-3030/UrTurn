package com.example.aaron.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private boolean create= false;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //click handlers
        findViewById(R.id.btnContinue).setOnClickListener(this);
        Switch s = (Switch) findViewById(R.id.swCreate);

        if (s != null) {
            s.setOnCheckedChangeListener(this);
        }
        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                if(isChecked){
                    create=true;

                }
                else{
                    create=false;
                }

            }
        });




    }

    private void addUser(){
        FirebaseUser user = mAuth.getCurrentUser();

        EditText nametxt = (EditText)findViewById(R.id.txtName);
        String name      =  nametxt.getText().toString();


        if (user!= null){
            mDatabase.child("User").child(user.getUid()).child("Name").setValue(name);
        }
        else{
            Intent intent = new Intent(Register.this, logIn.class);
            startActivity(intent);
            Register.this.finish();
        }
    }

    private void createRoom(){
        FirebaseUser user = mAuth.getCurrentUser();

        EditText roomtxt = (EditText)findViewById(R.id.txtRoom);
        EditText nametxt = (EditText)findViewById(R.id.txtName);
        String name      =  nametxt.getText().toString();
        String roomName= roomtxt.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String key = database.getReference("Room").push().getKey();
        mDatabase.child("Room").child(key).child("Name").setValue(roomName);
        mDatabase.child("Roommates").child(key).child("Users").child(user.getUid()).setValue(name);
        mDatabase.child("User").child(user.getUid()).child("RoomID").setValue(roomName);

        Toast.makeText(Register.this, "You have Created Room: "+ roomName, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);

        Register.this.finish();

    }

    private void joinRoom(){
        EditText roomtxt = (EditText)findViewById(R.id.txtRoom);
        final String roomName= roomtxt.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();




        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                FirebaseUser user = mAuth.getCurrentUser();
                EditText nametxt = (EditText)findViewById(R.id.txtName);
                String name      =  nametxt.getText().toString();
                if (snapshot.child("Room").hasChild(roomName)) {
                    Toast.makeText(Register.this, "You have Joined: "+ mDatabase.child("Room").child(roomName).child("Name").getKey(), Toast.LENGTH_SHORT).show();
                    mDatabase.child("Roommates").child(roomName).child("Users").child(user.getUid()).setValue(name);
                    mDatabase.child("User").child(user.getUid()).child("RoomID").setValue(roomName);

                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);

                    Register.this.finish();
                }
                else{
                    Toast.makeText(Register.this, "Room Does not Exist", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Register.this, "Error Connecting to Server", Toast.LENGTH_SHORT).show();

            }
        });

/* ---
        Query query= mDatabase.child("Room").equalTo(roomName);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FirebaseUser user = mAuth.getCurrentUser();
                EditText nametxt = (EditText)findViewById(R.id.txtName);
                String name      =  nametxt.getText().toString();
                if(dataSnapshot.exists()){
                    mDatabase.child("Roommates").child(roomName).child("Users").child(user.getUid()).setValue(name);

                }
                else{
                    Toast.makeText(Register.this, "Room Does not Exist", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Register.this, "Error Connecting to Server", Toast.LENGTH_SHORT).show();

            }
        });
---- */



    }


        public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnContinue:

                if(create){
                    addUser();
                    createRoom();
                }
                else{
                    addUser();
                    joinRoom();

                }

                break;



        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
