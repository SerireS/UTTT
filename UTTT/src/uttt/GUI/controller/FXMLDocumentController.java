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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import uttt.BLL.game.GameManager;
import uttt.BLL.game.GameState;
import uttt.BLL.game.IGameState;
import uttt.BLL.move.Move;

/**
 *
 * @author jigzi
 */
public class FXMLDocumentController implements Initializable {

    private GameManager gm;
    private IGameState gameState;
    private boolean currentPlayer;
    @FXML
    private AnchorPane mainGridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameState = new GameState();
        gm = new GameManager(gameState);
        createAll();
    }

    private void createAll() {
        int btnWidth = 40;
        int btnHeight = 40;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                UTTTButton btn = new UTTTButton();
                btn.setPrefSize(btnWidth, btnHeight);
                btn.setLayoutX(200   + (btnWidth+4) * x);
                btn.setLayoutY(100 + (btnHeight+4) * y);
                btn.setMove(new Move(x, y));

                btn.setOnMouseClicked(event -> {

                    UTTTButton b = (UTTTButton) event.getSource();
                    boolean isSucces = gm.updateGame(b.getMove());
                    if (isSucces) {
                        if (gameState.getMoveNumber() % 2 == 0) {
                            b.setText("x");
                        } else {
                            b.setText("O");
                        }
                    }
                });
                mainGridPane.getChildren().add(btn);
            }

        }

    }
}
