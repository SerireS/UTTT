/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uttt.GUI.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import uttt.BLL.game.GameManager;
import uttt.BLL.game.GameState;
import uttt.BLL.game.IGameState;

/**
 *
 * @author jigzi
 */
public class FXMLDocumentController implements Initializable {
    private GameManager gm;
    private IGameState gameState;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameState = new GameState();
        gm = new GameManager(gameState);
    }    
    
    @FXML
    private void click(ActionEvent event) 
    {
        Button b = (Button)event.getSource();
        if(){
        b.setText("X");
        else{
        b.setText("Y");
        }    }    
    }
}
