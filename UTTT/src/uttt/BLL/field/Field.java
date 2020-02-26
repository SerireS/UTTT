/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uttt.BLL.field;

import java.util.List;
import uttt.BLL.move.IMove;

/**
 *
 * @author jigzi
 */
public class Field implements IField {

    private String[][] macroBoard;
    private String[][] board;

    public Field() {
        macroBoard = new String [3][3];
        board = new String [9][9];
        clearBoard();
    }
    
    
    @Override
    public void clearBoard() {
        for (int x = 0; x < macroBoard.length; x++) {
            for (int y = 0; y < macroBoard[x].length; y++) {
                macroBoard[x][y] = AVAILABLE_FIELD;
            }

                }
                for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    board[x][y] = EMPTY_FIELD;
            }
        }
    }

    @Override
    public List<IMove> getAvailableMoves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlayerId(int column, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if (!board[x][y].equals("."))
                    return false;
                    
                }
            
        }
            return true;
    }

    @Override
    public boolean isFull() {
        
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if (!board[x][y].equals("."))
                    return false;
                    
                }
            
        }
            return true;
    }

    @Override
    public Boolean isInActiveMicroboard(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] getBoard() {
        return board;
    }

    @Override
    public String[][] getMacroboard() {
        return macroBoard;
    }

    @Override
    public void setBoard(String[][] board) {
        this.board = board;
    }

    @Override
    public void setMacroboard(String[][] macroboard) {
        this.macroBoard = macroboard;
    }
    
}
