package org.yorichan.formfx.form;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.yorichan.formfx.field.Field;
import org.yorichan.formfx.field.FieldGroup;
import org.yorichan.formfx.fieldpane.HFieldBox;
import org.yorichan.formfx.fieldpane.VFieldBox;
import org.yorichan.formfx.utils.ReflectUtil;
import org.yorichan.formfx.utils.ValUtil;

/**
 * Created by YoriChan on 2017/4/25
 * A form that organize the fields casually
 */
public class CasualForm extends VBox {

    private FieldGroup fieldGroup;
    private Orientation fieldOrientation;
    private Pos fieldAlignment;
    private double rowSpacing = 12.5;
    private double columnSpacing = 12.5;

    public CasualForm(FieldGroup fieldGroup) {
        this(fieldGroup, Orientation.HORIZONTAL);
    }

    public CasualForm(FieldGroup fieldGroup, Orientation fieldOrientation) {
        this.fieldGroup = fieldGroup;
        this.fieldOrientation = fieldOrientation;
        this.init();
    }

    public void init() {

        if (fieldOrientation == Orientation.HORIZONTAL) {
            HBox hbox = new HBox(columnSpacing);
            for (int i = 0; i < fieldGroup.size(); i++) {
                Field field = fieldGroup.get(i);
                if (field.getControl().getId() == null) {
                    HFieldBox hFieldBox = new HFieldBox(field, fieldAlignment);
                    hbox.getChildren().add(hFieldBox);
                } else {
                    if (field.getControl().getId().equals("")) {
                        this.getChildren().add(hbox);
                        hbox = new HBox(columnSpacing);
                    } else {
                        HFieldBox hFieldBox = new HFieldBox(field, fieldAlignment);
                        hbox.getChildren().add(hFieldBox);
                    }
                }
                if (i == fieldGroup.size() - 1)
                    this.getChildren().add(hbox);
            }
        }

        else if (fieldOrientation == Orientation.VERTICAL) {
            HBox hbox = new HBox(columnSpacing);
            hbox.setAlignment(Pos.TOP_LEFT);
            for (int i = 0; i < fieldGroup.size(); i++) {
                Field field = fieldGroup.get(i);
                if (field.getControl().getId() == null) {
                    HFieldBox hFieldBox = new HFieldBox(field, fieldAlignment);
                    hbox.getChildren().add(hFieldBox);
                } else {
                    if (field.getControl().getId().equals("")) {
                        this.getChildren().add(hbox);
                        hbox = new HBox(columnSpacing);
                    } else {
                        VFieldBox vFieldBox = new VFieldBox(field, fieldAlignment);
                        hbox.getChildren().add(vFieldBox);
                    }
                }
                if (i == fieldGroup.size() - 1)
                    this.getChildren().add(hbox);
            }
        }

        this.setSpacing(rowSpacing);
        this.setAlignment(Pos.CENTER);

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

    public double getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(double rowSpacing) {
         this.rowSpacing = rowSpacing;
         this.init();
     }

    public double getColumnSpacing() {
        return columnSpacing;
    }

    public void setColumnSpacing(double columnSpacing) {
        this.columnSpacing = columnSpacing;
        this.init();
    }

}
