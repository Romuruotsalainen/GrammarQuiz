package com.example.android.grammarquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This variable keeps track of the total score
    private int points = 0;

    public void openQuestion() {
        EditText text = findViewById(R.id.open_question);
        String text_as_string = text.getText().toString();
        if (text_as_string.equalsIgnoreCase("diglossia")) {
            points += 3;
        }
    }

    public void fetchNoun() {
        /*This adds poits if correct words (nouns) are ticked, no minus points are checked at this
        moment*/
        CheckBox egg = findViewById(R.id.egg);
        CheckBox banana = findViewById(R.id.banana);
        CheckBox leaflet = findViewById(R.id.leaflet);

        if (egg.isChecked() && banana.isChecked() && leaflet.isChecked()) {
            points += 3;
        }
    }

    //This function checks if correct answer is given
    public void fetchPronoun() {
        RadioButton pronoun = findViewById(R.id.she);

        if (pronoun.isChecked()) {
            points += 1;
        }

    }

    //This function displays the score in a Toast
    public void postScore(View view) {

        //Theses updates the points
        fetchNoun();
        fetchPronoun();
        openQuestion();

        //This creates the Toast and shows it

        String cheer = "";
        if (points <= 1) {
            cheer = "You can do a lot better!";
        } else if (points <= 3) {
            cheer = "Come on, try harder!";
        } else if (points <= 6) {
            cheer = "Not to bad!";
        } else {
            cheer = "Perfect";
        }

        String points_total = points + "/7 points. " + cheer;
        Context context = getApplicationContext();
        CharSequence text = points_total;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //This resets the points variable
        points = 0;
    }

}
