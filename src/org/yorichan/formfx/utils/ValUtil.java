package org.yorichan.formfx.utils;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.yorichan.formfx.control.mydefine.DirectorySelector;
import org.yorichan.formfx.control.mydefine.FileSelector;
import org.yorichan.formfx.field.FieldGroup;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YoriChan on 2017/4/25
 * Some utils
 */
public class ValUtil {

    public static Map<String, Object> getValMap(FieldGroup fieldGroup) {
        Map<String, Object> valMap = new HashMap<>();
        for (int i = 0; i < fieldGroup.size(); i++) {
            Node node = fieldGroup.get(i).getControl();
            if (node.getId() != null)
                valMap.put(node.getId(), ValUtil.getValueFromNode(node));
        }
        return valMap;
    }

    /**
     * Get value from a Node
     * @param node
     * @return
     */
    public static Object getValueFromNode(Node node) {
        // TextField/PasswordField/TextArea
        if (node instanceof TextInputControl)
            return  ((TextInputControl)node).getText();
        // DatePicker
        else if (node instanceof DatePicker) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(((DatePicker)node).getEditor().getText());
            } catch (ParseException e) {
                e.printStackTrace();
                return ((DatePicker)node).getEditor().getText();
            }
        }
        // ColorPicker
        else if (node instanceof ColorPicker)
            return  ((ColorPicker)node).getValue();
        // FileSelector
        else if (node instanceof FileSelector)
            return  ((FileSelector)node).getValue();
        // DirectorySelector
        else if (node instanceof DirectorySelector)
            return  ((DirectorySelector)node).getValue();
        // ComboBox
        else if (node instanceof ComboBox)
            return  ((ComboBox)node).getValue();
        // ChoiceBox
        else if (node instanceof ChoiceBox)
            return  ((ChoiceBox)node).getValue();
        // ToggleButton
        else if (node instanceof ToggleButton)
            return  ((ToggleButton)node).isSelected();
        else if (node instanceof GridPane) {
            List<Node> options = ((GridPane)node).getChildren();
            // CheckBox
            if (options.get(0) instanceof CheckBox) {
                List<String> vals = new ArrayList<>();
                for (Node n : options) {
                    CheckBox checkBox = (CheckBox) n;
                    if (checkBox.isSelected())
                        vals.add(checkBox.getText());
                }
                return vals;
            }
            // RadioButton
            if (options.get(0) instanceof RadioButton) {
                for (Node n : options) {
                    RadioButton radioButton = (RadioButton) n;
                    if (radioButton.isSelected())
                        return radioButton.getText();
                }
            }
        }
        // ImageView
        else if (node instanceof ImageView)
            return  ((ImageView)node).getImage().impl_getUrl();
        // Label
        else if (node instanceof Label)
            return  ((Label)node).getText();
        // Hyperlink
        else if (node instanceof Hyperlink)
            return  ((Hyperlink)node).getText();
        return null;
    }

    /**
     * Get value by id
     * @param id
     * @return
     */
    public static Object getValueById(String id, FieldGroup fieldGroup) {
        for (int i = 0; i < fieldGroup.size(); i++) {
            Node node = fieldGroup.get(i).getControl();
            if (node.getId() == null)
                continue;
            if (node.getId().equals(id)) {
                return ValUtil.getValueFromNode(node);
            }
        }
        return null;
    }

}
