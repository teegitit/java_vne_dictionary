/*
 * Personal project
 * Anh - Viet Dictionary
 * Author: Tee Le
 * Created: 5/26/2020
 */
package personal.project.dictionary;
/*
 * Personal project
 * Anh - Viet Dictionary
 * Author: Tee Le
 * Created: 5/26/2020
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;


import java.io.IOException;
import java.util.SortedSet;


public class DictionaryController {
    @FXML private TextField search;
    @FXML private ListView<String> results;
    @FXML private TextArea definition;
    private DictionaryFunc func = new DictionaryFunc();
    private static final int WORD_SIZE = 16;

    private void loadWords(){
        SortedSet<String> set = func.allThatBeginsWith(search.getText());
        if(set == null){
            definition.setText("No definition found! :(");
            results.getItems().clear();
        } else{
            for(String s : set){
                results.getItems().addAll(s);
            }
        }
    }

    @FXML
    public void anhViet(ActionEvent event) throws IOException {
        definition.setText("");
        search.setText("");
        results.getItems().clear();
        func.loadAnhViet();
        loadWords();
    }

    @FXML
    public void vietAnh(ActionEvent event) throws IOException {
        definition.setText("");
        search.setText("");
        results.getItems().clear();
        func.loadVietAnh();
        loadWords();
    }

    @FXML
    protected void update(KeyEvent event){
        loadWords();
        results.getItems().clear();
        search.setFont(new Font(WORD_SIZE));
        
        SortedSet<String> set = func.allThatBeginsWith(search.getText());
        if(set == null){
            definition.setText("No definition found! :(");
            results.getItems().clear();
        } else{
            for(String s : set){
                results.getItems().addAll(s);
            }
        }
    }

    @FXML
    protected void getMeaning(MouseEvent event){
        String selected = results.getSelectionModel().getSelectedItem();
        definition.clear();
        definition.setFont(new Font(WORD_SIZE));
        definition.setText(func.getDef(selected));
    }
}
