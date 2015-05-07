package com.steiner_consult.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.steiner_consult.tictactoe.models.Board;
import com.steiner_consult.tictactoe.models.Point;


/**
 * Created by Philipp on 28.04.15.
 */
public class SinglePlayerActivity extends BaseGameActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplay);
        board = new Board(this, boxes, true);
        board.displayBoard();
    }

    @Override
    protected void handleUserClick(Point userMove) {
        board.placeAMove(userMove, 2); //2 for O and O is the user
        board.displayBoard();
        if (!board.isGameOver()) {
            board.minimax(0, 1);
            board.placeAMove(board.computersMove, 1);
            board.displayBoard();
        } else {
            if (board.hasXWon()) {
                Toast.makeText(this, "You lost!", Toast.LENGTH_SHORT).show();
            } else if (board.hasOWon()) {
                Toast.makeText(this, "You won!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "It's a draw!", Toast.LENGTH_SHORT).show();
            }
            findViewById(R.id.button_restart).setVisibility(View.VISIBLE);
        }

    }

}
