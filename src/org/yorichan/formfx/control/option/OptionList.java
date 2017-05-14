package org.yorichan.formfx.control.option;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by YoriChan on 2017/4/21
 * Common Items of some controls like RadioButton, CheckBox, ComboBox etc.
 */
public class OptionList {

    private List<Option> list = new LinkedList<>();
    private int columnNum;

    public OptionList() {
        this(-1);
    }

    public OptionList(int columnNum) {
        this.columnNum = columnNum;
    }

    public OptionList add(String name) {
        return this.add(name, false);
    }

    public OptionList add(String name, boolean selected) {
        list.add(new Option(name, selected));
        return this;
    }

    public int size() {
        return list.size();
    }

    public Option get(int index) {
        return list.get(index);
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

}
