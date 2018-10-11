package com.team11.urturn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    /**
     * Variables, Constants, Buttons, Text
     */
    private EditText UserName;
    private EditText Password;
    //private TextView Attempts;
    private Button LoginB;
    private int counter = 5;

    /**
     * This method is called whenever the app is started
     * @param savedInstanceState This is the starting State when the app is launched
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        UserName = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        //Attempts = (TextView) findViewById(R.id.Attempts);
        LoginB = (Button) findViewById(R.id.LogInButton);

        LoginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(UserName.getText().toString(), Password.getText().toString());
            }
        });

    }

    /**
     * This method is used to Validate the users credentials
     * @param userName The user must enter a String userName to be validated
     * @param userPassword The user must enter a String password to be validated
     */
    private void validate(String userName, String userPassword){
        if ((userName.equals("Admin") && (userPassword.equals("12345")))) {
            Intent intent = new Intent(LogIn.this, MainActivity.class);
            startActivity(intent);
        }else{

            counter --;

           // Attempts.setText(String.valueOf(counter));

            if (counter ==0);{
                LoginB.setEnabled(false);
            }
        }
        }
    }
