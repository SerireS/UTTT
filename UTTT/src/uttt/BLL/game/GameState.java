/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uttt.BLL.game;

import uttt.BLL.field.Field;
import uttt.BLL.field.IField;

/**
 *
 * @author jigzi
 */
public class GameState implements IGameState {

    IField Field;
    private int moveNumber;
    private int roundNumber;
    
    public GameState()
    {
        Field = new Field();
        moveNumber = 0;
        roundNumber = 0;
                     
    }
   
    
    
    @Override
    public IField getField() {
        return Field;
    }

    @Override
    public int getMoveNumber() {
        return moveNumber;
    }

    @Override
    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    @Override
    public int getRoundNumber() {
        return roundNumber;
    }

    @Override
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
    
}
