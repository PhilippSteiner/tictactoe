package com.steiner_consult.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.steiner_consult.tictactoe.models.Board;
import com.steiner_consult.tictactoe.models.Point;

/**
 * Created by Philipp on 28.04.15.
 */
public class MultiplayerActivity extends BaseGameActivity {

    private TextView playerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplay);
        playerTitle = (TextView) findViewById(R.id.playertitle);
        board = new Board(this, boxes, false);
        board.displayBoard();
    }

    @Override
    void handleUserClick(Point userMove) {
        board.placeAMove(userMove, player); //2 for O and O is the user
        board.displayBoard();

        if (board.isGameOver()) {
            if (board.hasXWon()) {
                Toast.makeText(this, "Player 1 won!", Toast.LENGTH_SHORT).show();
            } else if (board.hasOWon()) {
                Toast.makeText(this, "Player 2 won!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "It's a draw!", Toast.LENGTH_SHORT).show();
            }
            findViewById(R.id.button_restart).setVisibility(View.VISIBLE);
        }
        if (player == 1) {
            player = 2;
            playerTitle.setText("It's Player 2's turn!");
        } else {
            player = 1;
            playerTitle.setText("It's Player 1's turn!");
        }

    }
}
