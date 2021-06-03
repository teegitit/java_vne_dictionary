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

//Controller class of the dictionary
public class DictionaryController {
    //User's input of the word
    @FXML private TextField search;
    //List of strings to show that match the user's input
    @FXML private ListView<String> results;
    //Text area to show the definition/explanation
    @FXML private TextArea definition;

    //Initializes the functionality class
    private DictionaryFunc func = new DictionaryFunc();

    //Constant font size for the word
    private static final int WORD_SIZE = 16;

    /**
     * Loads all of the matching results for the searched word
     */
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

    /**
     * Loads the English-Vietnamese dictionary
     * @param event the event of clicking Anh-Viet button
     * @throws IOException if the file of the dictionary cannot be loaded
     */
    @FXML
    public void anhViet(ActionEvent event) throws IOException {
        definition.setText("");
        search.setText("");
        results.getItems().clear();
        func.loadAnhViet();
        loadWords();
    }

    /**
     * Loads the Vietnamese-English dictionary
     * @param event the event of clicking Viet-Anh button
     * @throws IOException if the file of the dictionary cannot be loaded
     */
    @FXML
    public void vietAnh(ActionEvent event) throws IOException {
        definition.setText("");
        search.setText("");
        results.getItems().clear();
        func.loadVietAnh();
        loadWords();
    }

    /**
     * Updates the list view that shows all the matching results
     * Everytime the user enters or deletes a character
     * @param event the event of entering any character
     */
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

    /**
     * Shows the definition/explanation of the word on the text area.
     * @param event the event of clicking on a cell (a word) on the list view
     */
    @FXML
    protected void getMeaning(MouseEvent event){
        String selected = results.getSelectionModel().getSelectedItem();
        definition.clear();
        definition.setFont(new Font(WORD_SIZE));
        definition.setText(func.getDef(selected));
    }
}
