package com.steiner_consult.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.steiner_consult.tictactoe.models.Board;
import com.steiner_consult.tictactoe.models.Point;

/**
 * Created by Philipp on 07.05.15.
 */
public abstract class BaseGameActivity extends Activity {

    protected int boxes[][] = new int[3][3];
    protected int player = 1;
    protected Board board;

    abstract void handleUserClick(Point userMove);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeBoxes();
    }

    protected void initializeBoxes() {
        boxes[0][0] = R.id.box_1;
        boxes[0][1] = R.id.box_2;
        boxes[0][2] = R.id.box_3;
        boxes[1][0] = R.id.box_4;
        boxes[1][1] = R.id.box_5;
        boxes[1][2] = R.id.box_6;
        boxes[2][0] = R.id.box_7;
        boxes[2][1] = R.id.box_8;
        boxes[2][2] = R.id.box_9;
    }

    private void placeCross(View view) {
        ((ImageView) view).setImageResource(R.drawable.cross);
    }

    private void placeCrossOrCircle(View view) {
        if (player == 1)
            ((ImageView) view).setImageResource(R.drawable.cross);
        else
            ((ImageView) view).setImageResource(R.drawable.circle);
    }

    public void onBoxClick(View view) {
        Log.d("Game", "Player: " + player);
        Point userMove;
        switch (view.getId()) {
            case R.id.box_1:
                userMove = new Point(0, 0);
                break;
            case R.id.box_2:
                userMove = new Point(0, 1);
                break;
            case R.id.box_3:
                userMove = new Point(0, 2);
                break;
            case R.id.box_4:
                userMove = new Point(1, 0);
                break;
            case R.id.box_5:
                userMove = new Point(1, 1);
                break;
            case R.id.box_6:
                userMove = new Point(1, 2);
                break;
            case R.id.box_7:
                userMove = new Point(2, 0);
                break;
            case R.id.box_8:
                userMove = new Point(2, 1);
                break;
            case R.id.box_9:
                userMove = new Point(2, 2);
                break;
            default:
                userMove = new Point(0, 0);
                break;
        }
        if (board.isSinglePlayerGame)
            placeCross(view);
        else
            placeCrossOrCircle(view);
        handleUserClick(userMove);
    }

    public void restartGame(View view) {
        board = new Board(this, boxes, true);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                ((ImageView) findViewById(boxes[i][j])).setImageResource(0);
            }
        }
        findViewById(R.id.button_restart).setVisibility(View.GONE);
    }
}
