
package com.example.intercontinental;


/**
 * code written by moses ouma wangira
 **/

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ArrayList<String> about = new ArrayList<>();

        about.add("TABLE TENNIS APP");
        about.add("\n");
        about.add("This is a table tennis app that helps table tennis ampires count scores as they occur in the game");
        about.add("It has different features in it");
        about.add("1. It counts the scores");
        about.add("2. It enables one visit the ITTF website using the three dots on top and selection ITTF option");
        about.add("3. One can choose mode of play whether best of 1 or 3 or 7");
        about.add("4. It enables elongation of match by increasing the number of best of keeping in mind 7 is the maximum and 1 is the minimum");
        about.add("5. On completion of match one can reset a match using the new match button");
        about.add("6. In case of fault score one can reduce the score using the fault button");
        about.add("7. It also displays number of sets won by each of the competitor");

        about.add("\n");
        about.add("\n");

        about.add("********************************************");
        about.add("Future improvements");
        about.add("player who is serving display");
        about.add("Scores scored per set for each player");




        LinearLayout rootView = findViewById(R.id.about_table_tennis);
        for (int i=0 ; i<about.size() ; i++)
        {
            TextView listView = new TextView(this);
            listView.setTextColor(Color.BLACK);
            listView.setGravity(Gravity.LEFT);
            listView.setText(about.get(i));
            rootView.addView(listView);
        }

    }
}
