package org.yorichan.formfx.control;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.yorichan.formfx.control.option.Option;
import org.yorichan.formfx.control.option.OptionList;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.yorichan.formfx.control.mydefine.DirectorySelector;
import org.yorichan.formfx.control.mydefine.FileSelector;

/**
 * Created by YoriChan on 2017/4/18
 * Some utils that help you create input controls quickly
 */
public class Input {

    public static TextField textField() {
        return textField(-1, -1, null, null);
    }

    public static TextField textField(double width, double height) {
        return textField(width, height, null, null);
    }

    public static TextField textField(String promptText) {
        return textField(-1, -1, promptText, null);
    }

    public static TextField textField(String promptText, String defaultValue) {
        return textField(-1, -1, promptText, defaultValue);
    }

    public static TextField textField(double width, double height, String promptText, String defaultValue) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setText(defaultValue);
        if (width != -1)
            textField.setPrefWidth(width);
        if (height != -1)
            textField.setPrefHeight(height);
        return textField;
    }

    public static TextArea textArea() {
        return textArea(-1, -1, null, null);
    }

    public static TextArea textArea(double width, double height) {
        return textArea(width, height, null, null);
    }

    public static TextArea textArea(String promptText) {
        return textArea(-1, -1, promptText, null);
    }

    public static TextArea textArea(double width, double height, String promptText) {
        return textArea(width, height, promptText, null);
    }

    public static TextArea textArea(String promptText, String defaultValue) {
        return textArea(-1, -1, promptText, defaultValue);
    }

    public static TextArea textArea(double width, double height, String promptText, String defaultValue) {
        TextArea textArea = new TextArea();
        textArea.setPromptText(promptText);
        textArea.setText(defaultValue);
        textArea.setWrapText(true);
        if (width != -1)
            textArea.setPrefWidth(width);
        if (height != -1)
            textArea.setPrefHeight(height);
        return textArea;
    }

    public static PasswordField passwordField() {
        return passwordField(-1, -1, null, null);
    }

    public static PasswordField passwordField(double width, double height) {
        return passwordField(width, height, null, null);
    }

    public static PasswordField passwordField(String promptText) {
        return passwordField(-1, -1, promptText, null);
    }

    public static PasswordField passwordField(String promptText, String defaultValue) {
        return passwordField(-1, -1, promptText, defaultValue);
    }

    public static PasswordField passwordField(double width, double height, String promptText, String defaultValue) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(promptText);
        passwordField.setText(defaultValue);
        if (width != -1)
            passwordField.setPrefWidth(width);
        if (height != -1)
            passwordField.setPrefHeight(height);
        return passwordField;
    }

    public static DatePicker datePicker() {
        return datePicker(-1, -1, null, null);
    }

    public static DatePicker datePicker(double width, double height) {
        return datePicker(width, height, null, null);
    }

    public static DatePicker datePicker(String promptText) {
        return datePicker(-1, -1, promptText, null);
    }

    public static DatePicker datePicker(double width, double height, String promptText) {
        return datePicker(width, height, promptText, null);
    }

    public static DatePicker datePicker(String promptText, Date defaultDate) {
        return datePicker(-1, -1, promptText, defaultDate);
    }

    public static DatePicker datePicker(double width, double height, String promptText, Date defaultDate) {
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText(promptText);
        if (defaultDate != null)
            datePicker.getEditor().setText(new SimpleDateFormat("yyyy-MM-dd").format(defaultDate));
        if (width != -1)
            datePicker.setPrefWidth(width);
        if (height != -1)
            datePicker.setPrefHeight(height);
        return datePicker;
    }

    public static GridPane radioButtonBox(OptionList optionList) {
        int count = 0;
        int columnNum = optionList.getColumnNum() == -1 ? optionList.size() : optionList.getColumnNum();
        GridPane gridPane = new GridPane();
        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i < optionList.size(); i++) {
            Option option = optionList.get(i);
            RadioButton radioButton = new RadioButton(option.getName());
            radioButton.setSelected(option.isSelected());
            radioButton.setToggleGroup(group);
            gridPane.add(radioButton, count, i / columnNum + 1);
            if (++count == columnNum)
                count = 0;
        }
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(-10, 0, 0, 0));
        return gridPane;
    }

    public static GridPane checkBox(OptionList optionList) {
        int count = 0;
        int columnNum = optionList.getColumnNum() == -1 ? optionList.size() : optionList.getColumnNum();
        GridPane gridPane = new GridPane();
        for (int i = 0; i < optionList.size(); i++) {
            Option option = optionList.get(i);
            CheckBox checkBox = new CheckBox(option.getName());
            checkBox.setSelected(option.isSelected());
            gridPane.add(checkBox, count, i / columnNum + 1);
            if (++count == columnNum)
                count = 0;
        }
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(-10, 0, 0, 0));
        return gridPane;
    }

    public static ComboBox<String> comboBox() {
        return comboBox(-1, -1, null);
    }

    public static ComboBox<String> comboBox(OptionList optionList) {
        return comboBox(-1, -1, optionList);
    }

    public static ComboBox<String> comboBox(double width, double height, OptionList optionList) {
        ComboBox<String> comboBox = new ComboBox<>();
        for (int i = 0; i < optionList.size(); i++) {
            Option option = optionList.get(i);
            comboBox.getItems().add(option.getName());
            if (option.isSelected())
                comboBox.setValue(option.getName());
        }
        if (width != -1)
            comboBox.setPrefWidth(width);
        if (height != -1)
            comboBox.setPrefHeight(height);
        return comboBox;
    }

    public static ChoiceBox<String> choiceBox() {
        return choiceBox(-1, -1, null);
    }

    public static ChoiceBox<String> choiceBox(OptionList optionList) {
        return choiceBox(-1, -1, optionList);
    }

    public static ChoiceBox<String> choiceBox(double width, double height, OptionList optionList) {
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        for (int i = 0; i < optionList.size(); i++) {
            Option option = optionList.get(i);
            choiceBox.getItems().add(option.getName());
            if (option.isSelected())
                choiceBox.setValue(option.getName());
        }
        if (width != -1)
            choiceBox.setPrefWidth(width);
        if (height != -1)
            choiceBox.setPrefHeight(height);
        return choiceBox;
    }

    public static ToggleButton toggleButton() {
        return toggleButton(-1, -1, null);
    }

    public static ToggleButton toggleButton(String buttonText) {
        return toggleButton(-1, -1, buttonText);
    }

    public static ToggleButton toggleButton(double width, double height, String buttonText) {
        ToggleButton toggleButton = new ToggleButton(buttonText);
        if (width != -1)
            toggleButton.setPrefWidth(width);
        if (height != -1)
            toggleButton.setPrefHeight(height);
        return toggleButton;
    }

    public static ColorPicker colorPicker() {
        return colorPicker(-1, -1, null);
    }

    public static ColorPicker colorPicker(Color defaultColor) {
        return colorPicker(-1, -1, defaultColor);
    }

    public static ColorPicker colorPicker(double width, double height) {
        return colorPicker(width, height, null);
    }

    public static ColorPicker colorPicker(double width, double height, Color defaultColor) {
        ColorPicker colorPicker = new ColorPicker();
        if (defaultColor != null)
            colorPicker.setValue(defaultColor);
        if (width != -1)
            colorPicker.setPrefWidth(width);
        if (height != -1)
            colorPicker.setPrefHeight(height);
        return colorPicker;
    }

    public static FileSelector fileSelector() {
        return fileSelector(-1, -1, "", "...", "Please choose a file");
    }

    public static FileSelector fileSelector(double width, double height) {
        return fileSelector(width, height, "", "...", "Please choose a file");
    }

    public static FileSelector fileSelector(String defaultValue) {
        return fileSelector(-1, -1, defaultValue, "...", "Please choose a file");
    }

    public static FileSelector fileSelector(double width, double height, String defaultValue) {
        return fileSelector(width, height, defaultValue, "...", "Please choose a file");
    }

    public static FileSelector fileSelector(String defaultValue, String buttonText) {
        return fileSelector(-1, -1, defaultValue, buttonText, "Please choose a file");
    }

    public static FileSelector fileSelector(double width, double height, String defaultValue, String buttonText) {
        return fileSelector(width, height, defaultValue, buttonText, "Please choose a file");
    }

    public static FileSelector fileSelector(String defaultValue, String buttonText, String title) {
        return fileSelector(-1, -1, defaultValue, buttonText, title);
    }

    public static FileSelector fileSelector(double width, double height, String defaultValue, String buttonText, String title) {
        FileSelector fileSelector = new FileSelector(defaultValue, buttonText, title);
        if (width != -1)
            fileSelector.getTextField().setPrefWidth(width);
        if (height != -1) {
            fileSelector.getTextField().setPrefHeight(height);
            fileSelector.getButton().setPrefHeight(height);
            fileSelector.getButton().setPrefWidth(height * 1.25);
        }
        return fileSelector;
    }

    public static DirectorySelector directorySelector() {
        return directorySelector(-1, -1, "", "...", "Please choose a directory");
    }

    public static DirectorySelector directorySelector(double width, double height) {
        return directorySelector(width, height, "", "...", "Please choose a directory");
    }

    public static DirectorySelector directorySelector(String defaultValue) {
        return directorySelector(-1, -1, defaultValue, "...", "Please choose a directory");
    }

    public static DirectorySelector directorySelector(double width, double height, String defaultValue) {
        return directorySelector(width, height, defaultValue, "...", "Please choose a directory");
    }

    public static DirectorySelector directorySelector(String defaultValue, String buttonText) {
        return directorySelector(-1, -1, defaultValue, buttonText, "Please choose a directory");
    }

    public static DirectorySelector directorySelector(double width, double height, String defaultValue, String buttonText) {
        return directorySelector(width, height, defaultValue, buttonText, "Please choose a directory");
    }

    public static DirectorySelector directorySelector(String defaultValue, String buttonText, String title) {
        return directorySelector(-1, -1, defaultValue, buttonText, title);
    }

    public static DirectorySelector directorySelector(double width, double height, String defaultValue, String buttonText, String title) {
        DirectorySelector directorySelector = new DirectorySelector(defaultValue, buttonText, title);
        if (width != -1)
            directorySelector.getTextField().setPrefWidth(width);
        if (height != -1) {
            directorySelector.getTextField().setPrefHeight(height);
            directorySelector.getButton().setPrefHeight(height);
            directorySelector.getButton().setPrefWidth(height * 1.25);
        }
        return directorySelector;
    }

}
