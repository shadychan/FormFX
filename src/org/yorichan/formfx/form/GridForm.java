package org.yorichan.formfx.form;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.yorichan.formfx.field.Field;
import org.yorichan.formfx.field.FieldGroup;
import org.yorichan.formfx.fieldpane.VFieldBox;
import org.yorichan.formfx.utils.ReflectUtil;
import org.yorichan.formfx.utils.UiUtil;
import org.yorichan.formfx.utils.ValUtil;

/**
 * Created by YoriChan on 2017/4/18
 * A form that use grid to organize the fields, which looks regular
 */
public class GridForm extends GridPane {

    private FieldGroup fieldGroup;
    private int columnNum;
    private Orientation fieldOrientation;
    private Pos fieldAlignment;

    public GridForm(FieldGroup fieldGroup) {
        this(fieldGroup, 1, Orientation.VERTICAL);
    }

    public GridForm(FieldGroup fieldGroup, int columnNum) {
        this(fieldGroup, columnNum, Orientation.VERTICAL);
    }

    public GridForm(FieldGroup fieldGroup, Orientation fieldOrientation) {
        this(fieldGroup, 1, fieldOrientation);
    }

    public GridForm(FieldGroup fieldGroup, int columnNum, Orientation fieldOrientation) {
        this.fieldGroup = fieldGroup;
        this.columnNum = columnNum;
        this.fieldOrientation = fieldOrientation;
        this.init();
    }

    public void init() {

        int count = 0;
        if (fieldAlignment == null)
            fieldAlignment = Pos.TOP_LEFT;

        if (fieldOrientation == Orientation.VERTICAL) {
            for (int i = 0; i < fieldGroup.size(); i++) {
                Field field = fieldGroup.get(i);
                if (field.getControl().getId() != null)
                    if (field.getControl().getId().equals(""))
                        continue;
                this.add(new VFieldBox(field, fieldAlignment), count, i / columnNum + 1);
                if (++count == columnNum)
                    count = 0;
            }
            this.setHgap(25);
            this.setVgap(15);
        }

        else if (fieldOrientation == Orientation.HORIZONTAL) {
            for (int i = 0; i < fieldGroup.size(); i++) {
                Field field = fieldGroup.get(i);
                Node icon = field.getIcon();
                Label label = field.getLabel();
                Node control = field.getControl();

                if (control.getId() != null)
                    if (control.getId().equals(""))
                        continue;

                HBox hBox = new HBox();
                UiUtil.addIfNotNull(hBox, icon, label);

                VBox vBox1 = new VBox(hBox);
                vBox1.setAlignment(fieldAlignment);

                VBox vBox2 = new VBox(control);
                vBox2.setAlignment(fieldAlignment);

                this.add(vBox1, count, i / columnNum + 1);
                this.add(vBox2, ++count, i / columnNum + 1);
                if (++count == 2 * columnNum + (columnNum - 1))
                    count = 0;
                if (count != 0) {
                    VBox emptyBox = new VBox();
                    emptyBox.setPrefWidth(25);
                    this.add(emptyBox, count++, i / columnNum + 1);
                }
            }
            this.setHgap(10);
            this.setVgap(25);
        }

    }

    public Object getValue(String id) {
        return ValUtil.getValueById(id, fieldGroup);
    }

    public void fill(Object obj) {
        ReflectUtil.setValueFromValMap(ValUtil.getValMap(fieldGroup), obj);
    }

    public FieldGroup getFieldGroup() {
        return fieldGroup;
    }

    public void setFieldGroup(FieldGroup fieldGroup) {
        this.fieldGroup = fieldGroup;
        this.init();
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
        this.init();
    }

    public Orientation getFieldOrientation() {
        return fieldOrientation;
    }

    public void setFieldOrientation(Orientation fieldOrientation) {
        this.fieldOrientation = fieldOrientation;
        this.init();
    }

    public Pos getFieldAlignment() {
        return fieldAlignment;
    }

    public void setFieldAlignment(Pos fieldAlignment) {
        this.fieldAlignment = fieldAlignment;
        this.init();
    }

}
