package com.razormist.simplequizapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.razormist.simplequizapp.MainActivity.result;
import static com.razormist.simplequizapp.MainActivity.score1;

public class ResultActivity extends AppCompatActivity {

    TextView txtScore, txtResult, txtGreetings;
    SharedPreferences  mPreferences2;
   static int zero=0;
    public static String reset="reset";

    static  String shared =
            "reset";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        txtScore = (TextView)findViewById(R.id.txtScore);
        txtResult = (TextView)findViewById(R.id.txtResult);
        txtGreetings = (TextView)findViewById(R.id.txtGreetings);


        SharedPreferences sharedPreferences = getSharedPreferences("Result", Context.MODE_PRIVATE);
        int score2 = sharedPreferences.getInt(result, score1);
        txtScore.setText(Integer.toString(score2));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

//        mPreferences2 = getSharedPreferences(shared, Context.MODE_PRIVATE);
//        final SharedPreferences.Editor editor = mPreferences2 .edit();
//        editor.putInt(reset,zero);
//        editor.commit();

        Intent dash = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(dash);



    }
}
