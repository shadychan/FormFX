package demo;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.yorichan.formfx.control.Input;
import org.yorichan.formfx.control.option.OptionList;
import org.yorichan.formfx.field.FieldGroup;
import org.yorichan.formfx.form.GridForm;
import entity.User;

/**
 * Created by YoriChan on 2017/4/25
 * Use FieldGroup to create a GridForm
 */
public class GridFormDemo extends Application {

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
            // I change the preWidth property of the TextArea
            join("#about", "About:", Input.textArea(250, -1, "Write something about you"));
        }};

        /* ---------------------------------------------------------------------------------- */

        GridForm gridForm = new GridForm(fieldGroup);           // the default Orientation of the Fields is VERTICAL
        gridForm.setFieldOrientation(Orientation.HORIZONTAL);   // I change the Orientation of the Fields here
        gridForm.setAlignment(Pos.CENTER);

        /* ---------------------------------------------------------------------------------- */

        Button button = new Button("Fill And Print");
        button.setOnAction(e -> {
            User user = new User();
            gridForm.fill(user);    // fill the form data in your entity
            System.out.println(user);
        });

        /* ---------------------------------------------------------------------------------- */

        VBox vBox = new VBox(35);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(gridForm, button);

        Scene scene = new Scene(vBox);
        stage.setTitle("GridForm Demo");
        stage.setScene(scene);
        stage.show();

    }

}
