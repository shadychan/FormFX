package org.yorichan.formfx.control.option;

/**
 * Created by YoriChan on 2017/4/21
 * Common Item of some controls like RadioButton, CheckBox, ComboBox etc.
 */
public class Option {

    private String name;

    private boolean isSelected;

    public Option(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
