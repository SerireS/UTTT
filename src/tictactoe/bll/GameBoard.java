/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.scene.control.Button;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    private static final int EMPTY_FIELD = -1;

    private int playerId;
    private int[][] boardModel = new int[3][3];

    public GameBoard()
    {
        newGame();
    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     * 
     * Returns playerId from the variable
     */
    public int getNextPlayer()
    {
        return playerId;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     * 
     * Makes sure you can only make a move in an empty field. Otherwise switches playerId in the field. 
     * Calls the getWinner method to switch player.
     * 
     */
    public boolean play(int col, int row)
    {
        if (isGameOver() || boardModel[col][row] != EMPTY_FIELD)
        {
            return false;
        } else
        {
            boardModel[col][row] = playerId;
        }

        getWinner();
        return true;
    }

    /**
    * Tests the board for a winner horizontally, vertically and diagonally. 
    * Otherwise tests is the board is full and makes the game a draw. If the game is a draw playerId is set to -1.
    */
    public boolean isGameOver()
    {
        for (int i = 0; i < boardModel.length; i++)
        {
            if (boardModel[i][0] != EMPTY_FIELD && boardModel[i][0] == boardModel[i][1] && boardModel[i][1] == boardModel[i][2])
            {
                return true;
            }
        }

        for (int j = 0; j < boardModel.length; j++)
        {
            if (boardModel[0][j] != EMPTY_FIELD && boardModel[0][j] == boardModel[1][j] && boardModel[1][j] == boardModel[2][j])
            {
                return true;
            }
        }

        if (boardModel[0][0] != EMPTY_FIELD && boardModel[0][0] == boardModel[1][1] && boardModel[0][0] == boardModel[2][2])
        {
            return true;
        }

        if (boardModel[0][2] != EMPTY_FIELD && boardModel[0][2] == boardModel[1][1] && boardModel[0][2] == boardModel[2][0])
        {
            return true;
        }

        for (int i = 0; i < boardModel.length; i++)
        {
            for (int j = 0; j < boardModel[i].length; j++)
            {
                if (boardModel[i][j] == EMPTY_FIELD)
                {
                    return false;
                }
            }
        }
        playerId = EMPTY_FIELD;
        return true;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     * 
     * Returns the id of the playerId from isGameOver and decides the winner. 
     * 
     */
    public int getWinner()
    {
        if (playerId == 0)
        {
            playerId = 1;
        } else if (playerId == 1)
        {
            playerId = 0;
        }
        return playerId;
    }

    /**
     * Resets the game to a new game state.
     * 
     * Makes sure starting player is player 0 every time.
     * Sets the value of every field on the board to -1. 
     */
    public void newGame()
    {
        playerId = 0;
        {
            for (int i = 0; i < boardModel.length; i++)
            {
                for (int j = 0; j < boardModel[i].length; j++)
                {
                    boardModel[i][j] = EMPTY_FIELD;
                }
            }
        }
    }
    
}
