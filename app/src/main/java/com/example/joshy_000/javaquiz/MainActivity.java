package com.example.joshy_000.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Commit test
    QuestionBank qbank = new QuestionBank();
    Question question = new Question();
    String finalQuestion;
    String answer;
    TextView textViewToChange;
    String display;
    private static final String tag = "Main";
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null){
            index = savedInstanceState.getInt("index");
            Log.d(tag,String.valueOf(index));
        }




        setContentView(R.layout.activity_main);

        qbank.setQuestions(this);
        qbank.setAnswers(this);
        getRelInfo("null", index);
        textViewToChange = (TextView) findViewById(R.id.textView);
        Button tButton = (Button) findViewById(R.id.TrueBtn);
        Button fButton = (Button) findViewById(R.id.FalseBtn);
        Button pButton = (Button) findViewById(R.id.PrevBtn);
        Button nButton = (Button) findViewById(R.id.NextBtn);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(getString(R.string.True));
                Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT).show();
            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(getString(R.string.False));
                Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT).show();
            }
        });



        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRelInfo("prev", question.index);
            }
        });
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRelInfo("next", question.index);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart ran!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy ran!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume ran!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause ran!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop ran!");

    }
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("index", index);
    }
    public Boolean getRelInfo(String btnPress, int initIndex){
        int currIndex = question.prevNext(btnPress, initIndex);
        index = currIndex;
        Log.d(tag,String.valueOf(index));
        finalQuestion = qbank.mQuestionList.get(currIndex);
        textViewToChange = (TextView) findViewById(R.id.textView);
        textViewToChange.setText(finalQuestion);
        answer = qbank.mAnswerList.get(currIndex);
        boolean bAnswer;
        if(answer == "True"){
            bAnswer = true;
        }else{
            bAnswer = false;
        }

        return bAnswer;
    }
    private void checkAnswer(String btnPress){
        if(answer == btnPress){
            display = "CORRECT!!!!";
        }else{
            display = "Incorrect!";
        }

    }





}
