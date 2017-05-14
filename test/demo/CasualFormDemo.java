package demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.yorichan.formfx.control.Input;
import org.yorichan.formfx.control.option.OptionList;
import org.yorichan.formfx.field.FieldGroup;
import org.yorichan.formfx.form.CasualForm;
import entity.User;

/**
 * Created by YoriChan on 2017/4/25
 * Use FieldGroup to create a CasualForm
 */
public class CasualFormDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // create a FieldGroup
        FieldGroup fieldGroup = new FieldGroup() {{
            join("#username", "Username:", Input.textField("Please input your username"));
            join("#pwd", "Password:", Input.passwordField("Please input your password"));
            join("#gender", "Gender:", Input.radioButtonBox(
                    new OptionList() {{
                        add("boy", true);
                        add("girl");
                    }}));
            separate();     // separate the group into some rows
            join("#bir", "Birthday:", Input.datePicker("Please select your birthday"));
            join("#hobby", "Hobby:", Input.checkBox(
                    new OptionList() {{
                        add("basketball", true);
                        add("soccer");
                        add("program");
                    }}));
            join("#job", "Job:", Input.comboBox(
                    new OptionList() {{
                        add("programmer");
                        add("student", true);
                        add("teacher");
                    }}));
            separate();
            join("#about", "About:", Input.textArea("Write something about you"));
        }};

        /* ---------------------------------------------------------------------------------- */

        CasualForm casualForm = new CasualForm(fieldGroup);
        casualForm.setAlignment(Pos.CENTER);

        /* ---------------------------------------------------------------------------------- */

        Button button = new Button("Fill And Print");
        button.setOnAction(e -> {
            User user = new User();
            casualForm.fill(user);      // fill the form data in your entity
            System.out.println(user);
        });

        /* ---------------------------------------------------------------------------------- */

        VBox vBox = new VBox(35);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(casualForm, button);
        Scene scene = new Scene(vBox);
        stage.setTitle("CasualForm Demo");
        stage.setScene(scene);
        stage.show();

    }

}
