package com.example.joshy_000.javaquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshy on 2/10/2016.
 */
public class QuestionBank extends AppCompatActivity {
    public List<String> mQuestionList = new ArrayList<>();
    public List<String> mAnswerList = new ArrayList<>();
    //Commit test
    public void setQuestions(Context context) {
        mQuestionList.add(context.getString(R.string.question1));
        mQuestionList.add(context.getString(R.string.question2));
        mQuestionList.add(context.getString(R.string.question3));
        mQuestionList.add(context.getString(R.string.question4));
    }
    public void setAnswers(Context context) {
        mAnswerList.add(context.getString(R.string.True));
        mAnswerList.add(context.getString(R.string.False));
        mAnswerList.add(context.getString(R.string.True));
        mAnswerList.add(context.getString(R.string.True));
    }

}
