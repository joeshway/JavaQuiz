package com.example.joshy_000.javaquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Cheat extends AppCompatActivity {
    Bundle extras;
    private int inValue;
    QuestionBank qbank = new QuestionBank();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        extras= getIntent().getExtras();

        if (extras != null) {
            inValue = extras.getInt("QIndex");
        }

        setText();

        Button cButton = (Button) findViewById(R.id.cheatBtn);

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswer();
            }
        });
    }
    private void setText(){
        qbank.setQuestions(this);
        qbank.setAnswers(this);
        String finalQuestion = qbank.mQuestionList.get(inValue);
        TextView textViewToChange = (TextView) findViewById(R.id.Question);
        textViewToChange.setText(finalQuestion);
    }
    private void showAnswer(){
        String finalAnswer = qbank.mAnswerList.get(inValue);
        TextView textViewToChange = (TextView) findViewById(R.id.Answer);
        textViewToChange.setText(finalAnswer);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", inValue);
        setResult(RESULT_OK, returnIntent);

    }

}
