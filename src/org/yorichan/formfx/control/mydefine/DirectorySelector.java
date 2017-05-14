package org.yorichan.formfx.control.mydefine;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import java.io.File;

/**
 * Created by YoriChan on 2017/4/25
 */
public class DirectorySelector extends HBox {

    private TextField textField;
    private Button button;

    public DirectorySelector() {
        this("", "...", "Please choose a directory");
    }

    public DirectorySelector(String defaultValue) {
        this(defaultValue, "...", "Please choose a directory");
    }

    public DirectorySelector(String defaultValue, String buttonText) {
        this(defaultValue, buttonText, "Please choose a directory");
    }

    public DirectorySelector(String defaultValue, String buttonText, String title) {
        textField = new TextField(defaultValue);
        button = new Button(buttonText);
        this.getChildren().addAll(textField, button);
        button.setOnAction(e -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle(title);
            File file = directoryChooser.showDialog(null);
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
