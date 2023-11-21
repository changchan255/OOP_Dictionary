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

        dictionaryManagement.insertFromCommandline(dictionary, path);

        searchField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (searchField.getText().isEmpty()) {
//                    cancelBtn.setVisible(false);
                    setListDefault(0);
                } else {
//                    cancelBtn.setVisible(true);
                    handleOnKeyTyped();
                }
            }
        });

//        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                searchField.clear();
//                notAvailableAlert.setVisible(false);
//                cancelBtn.setVisible(false);
//                setListDefault(0);
//            }
//        });

        explainField.setEditable(false);


    }


    private void setListDefault(int index) {
        if (index == 0) headerList.setText("15 từ đầu tiên");
        else headerList.setText("Kết quả liên quan");
        list.clear();
        for (int i = index; i < index + 15; i++) list.add(dictionary.get(i).getWordTarget());
        searchList.setItems(list);
        searchedWord.setText(dictionary.get(index).getWordTarget());
        explainField.setText(dictionary.get(index).getWordExplain());
    }

//    @FXML
//    private void handleClickRemoveBtn() {
//        ButtonType yes = new ButtonType("Có", ButtonBar.ButtonData.OK_DONE);
//        ButtonType no = new ButtonType("Không", ButtonBar.ButtonData.CANCEL_CLOSE);
//        alert.setAlertType(Alert.AlertType.CONFIRMATION);
//        alert.getButtonTypes().setAll(yes, no);
//        alert.setTitle("Xác nhận");
//        alert.setHeaderText("Hãy thật sự chắc chắn nhé");
//        alert.setContentText("Bạn chắc chắn muốn xóa từ này?");
//        alert.showAndWait();
//
//        if (alert.getResult() == yes) {
//            dictionaryManagement.dictionaryRemove();
//            alert.setAlertType(Alert.AlertType.INFORMATION);
//            alert.setTitle("Thông báo");
//            alert.setHeaderText(null);
//            alert.setContentText("Đã xóa thành công!");
//            alert.showAndWait();
//
//        }
//    }

    @FXML
    private TextField searchField;


    @FXML
    private ListView<String> searchList;

    @FXML
    private TextArea explainField;

    @FXML
    private Label searchedWord;

    @FXML
    private Button soundBtn, editBtn, removeBtn, saveBtn;
}
