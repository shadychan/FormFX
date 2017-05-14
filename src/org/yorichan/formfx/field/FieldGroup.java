package org.yorichan.formfx.field;

import javafx.scene.Node;
import javafx.scene.layout.Region;

import java.util.LinkedList;

/**
 * Created by YoriChan on 2017/4/18
 * A list of fields to build the form
 */
public class FieldGroup extends LinkedList<Field> {

    public FieldGroup() {}

    public FieldGroup join(Node icon, Node control) {
        return join(null, icon, null, control);
    }

    public FieldGroup join(String id, Node icon, Node control) {
        return join(id, icon, null, control);
    }

    public FieldGroup join(String labelText, Node control) {
        return join(null, null, labelText, control);
    }

    public FieldGroup join(Node icon, String labelText, Node control) {
        return join(null, icon, labelText, control);
    }

    public FieldGroup join(String id, String labelText, Node control) {
        return join(id, null, labelText, control);
    }

    public FieldGroup join(String id, Node icon, String labelText, Node control) {
        if (id != null)
            control.setId(id);
        this.add(new Field(icon, labelText, control));
        return this;
    }

    public FieldGroup separate() {
        return join("", null, null, new Region());
    }

}
