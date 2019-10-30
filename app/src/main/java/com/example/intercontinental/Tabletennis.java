package com.example.intercontinental;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tabletennis extends AppCompatActivity {
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    int numberGames = 1;

    int set_set_win_p1 = 0;
    int set_set_win_p2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabletennis);

        Button add_best = findViewById(R.id.add_best_of);
        add_best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberGames <= 6) {
                    numberGames = numberGames + 2;
                    display_number_of_games(numberGames);
                } else {
                    Toast.makeText(Tabletennis.this, "Maximum Best of is 7", Toast.LENGTH_SHORT).show();
                    numberGames = 7;
                    display_number_of_games(numberGames);
                }
            }
        });
        Button reduce_best = findViewById(R.id.reduce_best_of);
        reduce_best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberGames < 2) {
                    Toast.makeText(Tabletennis.this, "Best of cannot be negative", Toast.LENGTH_SHORT).show();
                    numberGames = 1;
                    display_number_of_games(numberGames);
                } else {
                    numberGames = numberGames - 2;
                    display_number_of_games(numberGames);
                }
            }
        });

        final Button player_one_score = findViewById(R.id.player_one_add);
        player_one_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePlayer1 = scorePlayer1 + 1;
                display_game_point_p1(scorePlayer1);
                display_score_player_one(scorePlayer1);

                TextView setmatch = findViewById(R.id.set_match);
                String all_set = setmatch.getText().toString();
                numberGames = Integer.valueOf(all_set);
                if (numberGames == 1) {
                    if ((set_set_win_p1 == numberGames) || (set_set_win_p1 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                } else if (numberGames == 3) {
                    if ((set_set_win_p1 == 2) || (set_set_win_p1 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                } else if (numberGames == 5) {
                    if ((set_set_win_p1 == 3 && scorePlayer2 <= 2) || (set_set_win_p1 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                } else if (numberGames == 7) {
                    if ((set_set_win_p1 == 4 && scorePlayer2 <= 3) || (set_set_win_p1 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button player_one_fault = findViewById(R.id.player_one_fault);
        player_one_fault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scorePlayer1 < 1) {
                    Toast.makeText(Tabletennis.this, "No negative scores", Toast.LENGTH_SHORT).show();
                    scorePlayer1 = 0;
                    display_game_point_p1(scorePlayer1);
                } else {
                    scorePlayer1 = scorePlayer1 - 1;
                    display_game_point_p1(scorePlayer1);
                    display_score_player_one(scorePlayer1);
                }
            }
        });
        final Button player_two_score = findViewById(R.id.player_two_add);
        player_two_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePlayer2 = scorePlayer2 + 1;
                display_game_point_p2(scorePlayer2);
                display_score_player_two(scorePlayer2);
                TextView setmatch = findViewById(R.id.set_match);
                String all_set = setmatch.getText().toString();
                numberGames = Integer.valueOf(all_set);
                if (numberGames == 1) {
                    if ((set_set_win_p2 == numberGames) || (set_set_win_p2 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                } else if (numberGames == 3) {
                    if ((set_set_win_p2 == 2) || (set_set_win_p2 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                } else if (numberGames == 5) {
                    if ((set_set_win_p2 == 3 && scorePlayer2 <= 2) || (set_set_win_p2 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                } else if (numberGames == 7) {
                    if ((set_set_win_p2 == 4 && scorePlayer2 <= 3) || (set_set_win_p2 > numberGames)) {
                        Toast.makeText(Tabletennis.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button player_two_fault = findViewById(R.id.player_two_fault);
        player_two_fault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scorePlayer2 < 1) {
                    Toast.makeText(Tabletennis.this, "No negative scores", Toast.LENGTH_SHORT).show();
                    scorePlayer2 = 0;
                    display_game_point_p1(scorePlayer2);
                } else {
                    scorePlayer2 = scorePlayer2 - 1;
                    display_game_point_p2(scorePlayer2);
                    display_score_player_two(scorePlayer2);
                }
            }
        });


        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_all();
            }
        });



    }

    //check for game point
    private void display_game_point_p1(int scorePlayer1) {
        EditText name1 = findViewById(R.id.pl1name);
        String player_name_one = name1.getText().toString();


        if (scorePlayer1 == 10 && scorePlayer2 <= 10) {
            Toast.makeText(Tabletennis.this, "Game point", Toast.LENGTH_SHORT).show();
        }
        if (scorePlayer1 == 11 && scorePlayer2 <= 9) {
            Toast.makeText(this, " "+player_name_one+" wins", Toast.LENGTH_SHORT).show();
            set_set_win_p1 = set_set_win_p1 + 1;
            display_setwin_player_one(set_set_win_p1);
            reset_score();
        }
        if (scorePlayer1 > 10 && scorePlayer2 == scorePlayer1 - 1) {
            Toast.makeText(this, "Advantage player one", Toast.LENGTH_SHORT).show();
        }
        if (scorePlayer1 >= 10 && scorePlayer2 == scorePlayer1 - 2) {
            Toast.makeText(this, " "+player_name_one+" wins", Toast.LENGTH_SHORT).show();
            set_set_win_p1 = set_set_win_p1 + 1;
            display_setwin_player_one(set_set_win_p1);
            reset_score();
        }
        if (scorePlayer1 > 10 && scorePlayer2 == scorePlayer1) {
            Toast.makeText(this, "Dues", Toast.LENGTH_SHORT).show();
        }


    }

    private void display_game_point_p2(int scorePlayer2) {
        EditText name2 = findViewById(R.id.p2name);
        String player_name_two = name2.getText().toString();
        if (scorePlayer2 == 10 && scorePlayer1 <= 10) {
            Toast.makeText(Tabletennis.this, "Game point", Toast.LENGTH_SHORT).show();
        }
        if (scorePlayer2 == 11 && scorePlayer1 <= 9) {
            Toast.makeText(this, " "+player_name_two+" wins", Toast.LENGTH_SHORT).show();
            set_set_win_p2 = set_set_win_p2 + 1;
            display_setwin_player_two(set_set_win_p2);
            reset_score();
        }
        if (scorePlayer2 > 10 && scorePlayer1 == scorePlayer2 - 1) {
            Toast.makeText(this, "Advantage player two", Toast.LENGTH_SHORT).show();
        }
        if (scorePlayer2 >= 10 && scorePlayer2 == scorePlayer1) {
            Toast.makeText(this, "Dues", Toast.LENGTH_SHORT).show();
        }
        if (scorePlayer2 > 10 && scorePlayer1 == scorePlayer2 - 2) {
            Toast.makeText(this, " "+player_name_two+" wins", Toast.LENGTH_SHORT).show();
            set_set_win_p2 = set_set_win_p2 + 1;
            display_setwin_player_two(set_set_win_p2);
            reset_score();
        }
    }
    private void reset_score() {
        resetScoreOne(scorePlayer1 = 0);
        resetScoreTwo(scorePlayer2 = 0);
    }

    private void reset_all() {
        resetScoreOne(scorePlayer1 = 0);
        resetScoreTwo(scorePlayer2 = 0);
        resetSetp1(set_set_win_p1 = 0);
        resetSetp2(set_set_win_p2 = 0);
        resetbestof(numberGames = 1);
        Toast.makeText(this, "Start new Match", Toast.LENGTH_SHORT).show();
    }

    private void display_setwin_player_one(int setwin1) {
        TextView scorePlayerOne = findViewById(R.id.setwinp1);
        scorePlayerOne.setText("" + setwin1);
    }

    private void display_setwin_player_two(int setwin2) {
        TextView scorePlayerOne = findViewById(R.id.setwinp2);
        scorePlayerOne.setText("" + setwin2);
    }


    private void display_score_player_one(int score) {
        TextView scorePlayerOne = findViewById(R.id.player_one_score);
        scorePlayerOne.setText("" + score);
    }

    private void display_score_player_two(int score) {
        TextView scorePlayerTwo = findViewById(R.id.player_two_score);
        scorePlayerTwo.setText("" + score);
    }

    private void display_number_of_games(int games) {
        TextView numberOfGames = findViewById(R.id.set_match);
        numberOfGames.setText("" + games);
    }

    private void resetScoreOne(int score1) {
        TextView reset1 = findViewById(R.id.player_one_score);
        reset1.setText("" + score1);
    }

    private void resetScoreTwo(int score2) {
        TextView reset1 = findViewById(R.id.player_two_score);
        reset1.setText("" + score2);
    }

    private void resetSetp1(int set_set_win_p1) {
        TextView reset1 = findViewById(R.id.setwinp1);
        reset1.setText("" + set_set_win_p1);
    }

    private void resetSetp2(int set_set_win_p2) {
        TextView reset1 = findViewById(R.id.setwinp2);
        reset1.setText("" + set_set_win_p2);
    }

    private void resetbestof(int bestof) {
        TextView resetbest = findViewById(R.id.set_match);
        resetbest.setText("" + bestof);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.selection_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ittf_website:
                // missing 'http://' will cause crashed
                Uri uri = Uri.parse("https://www.ittf.com/");
                Intent ittf_site = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(ittf_site);
                return true;
            case R.id.developer:
                //code goes here
                return true;
            case R.id.about:
                Intent about = new Intent(Tabletennis.this, About.class);
                if(about.resolveActivity(getPackageManager()) != null){
                    startActivity(about);
                }
                return true;
            case R.id.exitApp:
                finish();
                Toast.makeText(this, "Exiting counter", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
