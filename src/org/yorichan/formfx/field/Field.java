package org.yorichan.formfx.field;

import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Created by YoriChan on 2017/4/24
 * The smallest part of a form
 */
public class Field {

    private Node icon;
    private Label label;
    private Node control;

    public Field(String labelText, Node control) {
        this(new Label(labelText), control);
    }

    public Field(Node icon, String labelText, Node control) {
        this(icon, new Label(labelText), control);
    }

    public Field(Label label, Node control) {
        this(null, label, control);
    }

    public Field(Node icon, Label label, Node control) {
        this.icon = icon;
        this.label = label;
        this.control = control;
    }

    public Node getIcon() {
        return icon;
    }

    public void setIcon(Node icon) {
        this.icon = icon;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Node getControl() {
        return control;
    }

    public void setControl(Node control) {
        this.control = control;
    }

}
