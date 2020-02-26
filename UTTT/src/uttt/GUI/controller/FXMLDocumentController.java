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
    private GridPane mainGridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameState = new GameState();
        gm = new GameManager(gameState);
        createAll();
    }

    @FXML
    private void createAll() {
        int btnWidth = 30;
        int btnHeight = 30;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                UTTTButton btn = new UTTTButton();
                btn.setPrefSize(btnWidth, btnHeight);
                btn.setLayoutX(27 + btnWidth * x);
                btn.setLayoutY(145 + btnHeight * y);
                btn.setMove(new Move(0, 0));

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
                    mainGridPane.getChildren().add(btn);
                });

            }

        }

    }
}
