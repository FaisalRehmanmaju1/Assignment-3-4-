package com.example.faisalapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{

    EditText et_email, et_password;
    TextView tv_register;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText)findViewById(R.id.et_password);
        tv_register = (TextView) findViewById(R.id.tv_register);
        sign_in = (Button) findViewById(R.id.sign_in);


        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(MainActivity.this,signup_form.class);
                startActivity(r);
            }
        });


        sign_in.setOnClickListener(new View.OnClickListener()
        {
            int i=0;

            @Override
            public void onClick(View v)
            {
                while (i < 3) {
                    String validemail =

                            "^" +
                                    "(?=.*[0-9])" +         //at least 1 digit
                                    "(?=.*[a-z])" +         //at least 1 lower case letter
                                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                                    "(?=.*[a-zA-Z])" +      //any letter
                                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                                    "(?=\\S+$)" +           //no white spaces
                                    ".{4,}" +               //at least 4 characters
                                    "$";


                    String email = et_email.getText().toString();

                    Matcher matcher = Pattern.compile(validemail).matcher(email);



                    if (matcher.matches()) {
                        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();

                        Intent si = new Intent(MainActivity.this, mainfront.class);
                        startActivity(si);

                    } else {
                        Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
                    }
                }


                et_password.setError("Enter Password");


            }



        });



    }





}




