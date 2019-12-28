package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button TestButton;
    public Label TestLabel;
    public Button B1;
    public Button B2;
    public Button B3;
    public Button B4;
    public Button B5;
    public Button B6;
    public Button B7;
    public Button B8;
    public Button B9;
    public static Button[][] aob; // aob = arrayOfButtons
    static Boolean xTurn = true;
    static int rows; // rows = numberOfButtons
    static int columns;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Controller controller = new Controller();
        aob = new Button[][]{
            {B1, B2, B3},
            {B4, B5, B6},
            {B7, B8, B9}
        };
        ActionEvent actionEvent = new ActionEvent();
        //controller.b1action(actionEvent, controller);
    }

    public void message(ActionEvent actionEvent) {
        aob[0][0].textProperty().set("");
        aob[0][1].textProperty().set("");
        aob[0][2].textProperty().set("");
        aob[1][0].textProperty().set("");
        aob[1][1].textProperty().set("");
        aob[1][2].textProperty().set("");
        aob[2][0].textProperty().set("");
        aob[2][1].textProperty().set("");
        aob[2][2].textProperty().set("");
        TestLabel.textProperty().set("Player 'x' on turn");
        xTurn = true;
        enableButtons();
    }

    public void b1action(ActionEvent actionEvent/*, Controller controller*/) {
        rows = 0;
        columns = 0;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b2action(ActionEvent actionEvent) {
        rows = 0;
        columns = 1;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b3action(ActionEvent actionEvent) {
        rows = 0;
        columns = 2;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b4action(ActionEvent actionEvent) {
        rows = 1;
        columns = 0;
        addXOToButtons();
        checkHorizontally();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b5action(ActionEvent actionEvent) {
        rows = 1;
        columns = 1;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b6action(ActionEvent actionEvent) {
        rows = 1;
        columns = 2;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b7action(ActionEvent actionEvent) {
        rows = 2;
        columns = 0;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b8action(ActionEvent actionEvent) {
        rows = 2;
        columns = 1;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void b9action(ActionEvent actionEvent) {
        rows = 2;
        columns = 2;
        addXOToButtons();
        checkHorizontally();
        checkVertically();
        checkFromUpLeftToRightDown();
        checkFromUpRightToLeftDown();
    }

    public void addXOToButtons() {
        if(xTurn) {
            if(aob[rows][columns].textProperty().get() != "x" && aob[rows][columns].textProperty().get() != "o") {
                aob[rows][columns].textProperty().set("x");
                xTurn = false;
                TestLabel.textProperty().set("Player 'o' on turn");
            }
        } else {
            if(aob[rows][columns].textProperty().get() != "x" && aob[rows][columns].textProperty().get() != "o") {
                aob[rows][columns].textProperty().set("o");
                xTurn = true;
                TestLabel.textProperty().set("Player 'x' on turn");
            }
        }
    }

    public void checkHorizontally() {
        int numberOfX = 0;
        int numberOfO = 0;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(aob[x][y].textProperty().get() == "x") {
                    numberOfX++;
                } else if(aob[x][y].textProperty().get() == "o") {
                    numberOfO++;
                }
                if(numberOfX == 3) {
                    TestLabel.textProperty().set("x won");
                    x = 3;
                    y = 3;
                    disableButtons();
                } else if(numberOfO == 3) {
                    TestLabel.textProperty().set("o won");
                    x = 3;
                    y = 3;
                    disableButtons();
                }
            }
            numberOfX = 0;
            numberOfO = 0;
        }
    }

    public void checkVertically() {
        int numberOfX = 0;
        int numberOfO = 0;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(aob[y][x].textProperty().get() == "x") {
                    numberOfX++;
                } else if(aob[y][x].textProperty().get() == "o") {
                    numberOfO++;
                }
                if(numberOfX == 3) {
                    TestLabel.textProperty().set("x won");
                    x = 3;
                    y = 3;
                    disableButtons();
                } else if(numberOfO == 3) {
                    TestLabel.textProperty().set("o won");
                    x = 3;
                    y = 3;
                    disableButtons();
                }
            }
            numberOfX = 0;
            numberOfO = 0;
        }
    }

    public void checkFromUpLeftToRightDown() {
        int numberOfX = 0;
        int numberOfO = 0;
        for(int x = 0; x < 3; x++) {
            if(aob[x][x].textProperty().get() == "x") {
                numberOfX++;
            } else if(aob[x][x].textProperty().get() == "o") {
                numberOfO++;
            }
            if(numberOfX == 3) {
                TestLabel.textProperty().set("x won");
                x = 3;
                disableButtons();
            } else if(numberOfO == 3) {
                TestLabel.textProperty().set("o won");
                x = 3;
                disableButtons();
            }
        }
        numberOfX = 0;
        numberOfO = 0;
    }

    public void checkFromUpRightToLeftDown() {
        int numberOfX = 0;
        int numberOfO = 0;
        int y = 2;
        for(int x = 0; x < 3; x++) {
            if(aob[x][y].textProperty().get() == "x") {
                numberOfX++;
            } else if(aob[x][y].textProperty().get() == "o") {
                numberOfO++;
            }
            if(numberOfX == 3) {
                TestLabel.textProperty().set("x won");
                x = 3;
                disableButtons();
            } else if(numberOfO == 3) {
                TestLabel.textProperty().set("o won");
                x = 3;
                disableButtons();
            }
            y--;
        }
        numberOfX = 0;
        numberOfO = 0;
    }

    public static void disableButtons() {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                aob[x][y].setDisable(true);
            }
        }
    }

    public static void enableButtons() {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                aob[x][y].setDisable(false);
            }
        }
    }

    public static void checkWinner() {
        //Button[] gameField = {B1, B2, B3, B4, B5, B6, B7, B8, B9};
    }
}
