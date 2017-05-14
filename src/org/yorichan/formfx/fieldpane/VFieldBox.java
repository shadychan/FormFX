package org.yorichan.formfx.fieldpane;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.yorichan.formfx.field.Field;
import org.yorichan.formfx.utils.UiUtil;

/**
 * Created by YoriChan on 2017/4/18
 */
public class VFieldBox extends VBox {

    private Field field;

    public VFieldBox(Field field) {
        this(field, Pos.TOP_LEFT);
    }

    public VFieldBox(Field field, Pos pos) {
        Node icon = field.getIcon();
        Label label = field.getLabel();
        Node control = field.getControl();

        HBox hBox1 = new HBox(2.5);
        hBox1.setAlignment(pos);
        UiUtil.addIfNotNull(hBox1, icon, label);

        HBox hBox2 = new HBox();
        hBox2.setAlignment(pos);
        hBox2.getChildren().add(control);

        this.setSpacing(7.5);
        this.getChildren().addAll(hBox1, hBox2);
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

}
