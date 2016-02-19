package com.example.joshy_000.javaquiz;

/**
 * Created by joshy on 2/10/2016.
 */
public class Question {
    public int index = 0;
    //Commit test
    public int prevNext(String btnPress, int forceChange){
        index = forceChange;
        if(btnPress == "next"){
            index++;
        }else if(btnPress == "prev"){
            index--;
        }
        if(index > 3){
            index = 0;
        }else if(index < 0) {
            index = 3;
        }
        return index;
    }
}
