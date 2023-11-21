package App;

import MultiChoiceGame.ListQuestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    public ListQuestion listQuestion = new ListQuestion();
    public int x = 0;
    public String path = "/Users/lehung/Documents/OOP/OOP_Dictionary/Dictionary_Project/src/main/resources/Utils/question.txt";

    public Button checkBtn, nextBtn;
    public RadioButton choiceA, choiceB, choiceC, choiceD;
    public Label question;

    public Label result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listQuestion.insertFromCommandline(path);
        this.load();
    }

    @FXML
    public void onClickcheckBtn(ActionEvent event) {
        if (listQuestion.get(x).getAnswer().equals("A")) {
            if (choiceA.isSelected()) {
                result.setText("Exactly!");
            } else {
                result.setText("Wrong!");
            }
        } else if (listQuestion.get(x).getAnswer().equals("B")) {
            if (choiceB.isSelected()) {
                result.setText("Exactly!");
            } else {
                result.setText("Wrong!");
            }
        }else if (listQuestion.get(x).getAnswer().equals("C")) {
            if (choiceC.isSelected()) {
                result.setText("Exactly!");
            } else {
                result.setText("Wrong!");
            }
        } else if (listQuestion.get(x).getAnswer().equals("D")) {
            if (choiceD.isSelected()) {
                result.setText("Exactly!");
            } else {
                result.setText("Wrong!");
            }
        }
    }

    public void load() {
        question.setText(listQuestion.get(x).getContent());
        choiceA.setText(listQuestion.get(x).getChoices().get(0));
        choiceB.setText(listQuestion.get(x).getChoices().get(1));
        choiceC.setText(listQuestion.get(x).getChoices().get(2));
        choiceD.setText(listQuestion.get(x).getChoices().get(3));
    }

    @FXML
    public void onClicknextBtn(ActionEvent event) {
        x++;
        result.setText("");
        choiceA.setSelected(false);
        choiceB.setSelected(false);
        choiceC.setSelected(false);
        choiceD.setSelected(false);
        if (x >= listQuestion.size()) {
            x = 0;
        }
        this.load();
    }
}