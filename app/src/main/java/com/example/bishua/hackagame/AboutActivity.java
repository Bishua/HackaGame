package com.example.bishua.hackagame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Illia on 13.09.2014.
 */
public class AboutActivity extends ActionBarActivity implements View.OnClickListener{

    Button btnReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
