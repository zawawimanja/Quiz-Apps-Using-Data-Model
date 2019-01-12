package com.razormist.simplequizapp;

/**
 * Created by Arvin on 2/21/2018.
 */

public class Question {

    String question,choice,explanation,answer;
    private int id;



    public String questions[] = {
            "Which is a Programming Language?",
            "In COMAL language program, after name of procedure parameters must be in?",
            "Programming language COBOL works best for use in?"
    };

    public String choices[][] = {
            {"HTML", "CSS", "Vala", "PHP"},
            {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
            {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}
    };

    public String correctAnswer[] = {
        "PHP",
        "Brackets",
        "Commercial Applications"
    };

    public String explanations[] = {
            "PHP the best",
            "Brackets the bes",
            "Commercial Applications  the best"
    };

    //array
    public String getQuestion(int a){
        this.question = questions[a];
        return question;
    }

    //array 2 d column
    public String getchoice1(int a){
      this.choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        this.choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        this.choice  = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        this.choice = choices[a][3];
        return choice;
    }


    public String getExplanation(int a){
        this.explanation = explanations[a];
        return explanation;
    }


    public String getCorrectAnswer(int a){
       this.answer = correctAnswer[a];
        return answer;
    }

    public int getId() {
        return id;
    }
}
