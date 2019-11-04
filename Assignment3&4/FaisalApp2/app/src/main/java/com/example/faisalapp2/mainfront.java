package com.example.faisalapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class mainfront extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfront);

        View v = findViewById(R.id.sign_out);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_out)
        {
            Intent intent = new Intent(this,MainActivity.class);
            this.startActivity(intent);
        }
    }



}
