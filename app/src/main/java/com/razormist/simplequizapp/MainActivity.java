package com.razormist.simplequizapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.razormist.simplequizapp.ResultActivity.reset;
import static com.razormist.simplequizapp.ResultActivity.shared;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    String explain;
    private String answer;
    static int score1=0;
    Random random;
    TextView score,no,totalscore;
    String getnumber;
    public static String result="highscore";
    private int mQuestionNumber = 0;
    private Question question= new Question();
    private int questionLength = question.questions.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        no = (TextView)findViewById(R.id.no);
        score = (TextView)findViewById(R.id.score);
        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

       totalscore = (TextView)findViewById(R.id.totalscore);
        tv_question = (TextView)findViewById(R.id.tv_question);

// if you want to do random question set like this below
//        NextQuestion(random.nextInt(questionLength));
        NextQuestion(mQuestionNumber);

        //reset score to be zero when user start new game
        SharedPreferences mPreferences2 = getSharedPreferences(shared, Context.MODE_PRIVATE);
        int score2 = mPreferences2.getInt(reset,0);
        score1=score2;
        score.setText(" "+score1);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    score1++;
                    score.setText(" "+score1);
                    explain(getnumber);
                    NextQuestion(mQuestionNumber);
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    score1++;
                    score.setText(" "+score1);
                    explain(getnumber);
                    NextQuestion(mQuestionNumber);
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    score1++;
                    score.setText(" "+score1);
                    explain(getnumber);
                    NextQuestion(mQuestionNumber);
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    explain(getnumber);
                    score1++;
                    score.setText(" "+score1);
                    explain(getnumber);
                    NextQuestion(mQuestionNumber);
                }else{
                    GameOver();
                }

                break;
        }
    }

    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     finish();
                    }
                });
        alertDialogBuilder.show();

    }


    private void explain(String input){

        int a=Integer.parseInt(input);
        explain = question.getExplanation(a);
        final android.app.AlertDialog dialog2 = new android.app.AlertDialog.Builder(MainActivity.this).create();
        View promptView = getLayoutInflater().inflate(R.layout.dialog, null);
        dialog2.setView(promptView);
        dialog2.setTitle("Click FileProcess to save file or Click Main to MainActivity");
        TextView   df=(TextView)promptView.findViewById(R.id.dialog);
        Button   ok=(Button) promptView.findViewById(R.id.ok);
        ///inflate filefinal TextView df=(TextView)promptView.findViewById(R.id.df);
        df.setText(explain);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });

        dialog2.show();
    }

    private void NextQuestion(int num) {

        if(mQuestionNumber<questionLength){
            tv_question.setText(question.getQuestion(num));
            btn_one.setText(question.getchoice1(num));
            btn_two.setText(question.getchoice2(num));
            btn_three.setText(question.getchoice3(num));
            btn_four.setText(question.getchoice4(num));

            answer = question.getCorrectAnswer(num);
            getnumber = Integer.toString(num);
            mQuestionNumber++;
        }else
        {
            final SharedPreferences sharedPreferences = getSharedPreferences("Result", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(result,score1);
            editor.commit();
            Intent dash = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(dash);
        }

    }

    public void highscore(View v){
        Intent dash = new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(dash);
    }

    }







