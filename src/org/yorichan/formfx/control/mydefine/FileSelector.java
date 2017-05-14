package org.yorichan.formfx.control.mydefine;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;

/**
 * Created by YoriChan on 2017/4/25
 */
public class FileSelector extends HBox {

    private TextField textField;
    private Button button;

    public FileSelector() {
        this("", "...", "Please choose a file");
    }

    public FileSelector(String defaultValue) {
        this(defaultValue, "...", "Please choose a file");
    }

    public FileSelector(String defaultValue, String buttonText) {
        this(defaultValue, buttonText, "Please choose a file");
    }

    public FileSelector(String defaultValue, String buttonText, String title) {
        textField = new TextField(defaultValue);
        button = new Button(buttonText);
        this.getChildren().addAll(textField, button);
        button.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle(title);
            File file = fileChooser.showOpenDialog(null);
            if (file != null)
                textField.setText(file.getPath());
        });
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public File getValue() {
        return new File(textField.getText());
    }

}
