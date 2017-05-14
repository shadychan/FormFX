package org.yorichan.formfx.fieldpane;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.yorichan.formfx.field.Field;
import org.yorichan.formfx.utils.UiUtil;

/**
 * Created by YoriChan on 2017/4/19
 */
public class HFieldBox extends HBox {

    private Field field;

    public HFieldBox(Field field) {
        this(field, Pos.TOP_LEFT);
    }

    public HFieldBox(Field field, Pos pos) {

        Node icon = field.getIcon();
        Label label = field.getLabel();
        Node control = field.getControl();
        HBox hBox = new HBox(2.5);
        hBox.setAlignment(pos);
        UiUtil.addIfNotNull(hBox, icon, label);
        this.setAlignment(pos);
        this.setSpacing(7.5);
        this.getChildren().addAll(hBox, control);
        this.field = field;

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

}
