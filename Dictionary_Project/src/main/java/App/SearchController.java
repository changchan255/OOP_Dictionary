package App;
import DictionaryCmdLine.Dictionary;
import DictionaryCmdLine.DictionaryManagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    private Dictionary dictionary = new Dictionary();
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();
    private final String path = "Dictionary_Project/src/main/resources/Utils/dictionary.txt";

    Alert alert = new Alert(Alert.AlertType.NONE);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionaryManagement.insertFromCommandline2();
    }

    @FXML
    private void handleClickRemoveBtn() {
        ButtonType yes = new ButtonType("Có", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("Không", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().setAll(yes, no);
        alert.setTitle("Xác nhận");
        alert.setHeaderText("Hãy thật sự chắc chắn nhé");
        alert.setContentText("Bạn chắc chắn muốn xóa từ này?");
        alert.showAndWait();

        if (alert.getResult() == yes) {
            dictionaryManagement.dictionaryRemove();
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Đã xóa thành công!");
            alert.showAndWait();

        }
    }

}
