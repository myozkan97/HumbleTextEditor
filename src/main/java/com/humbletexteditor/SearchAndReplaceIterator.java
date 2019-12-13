package com.humbletexteditor;

import javax.swing.*;

public class SearchAndReplaceIterator extends SearchIterator{
    private JTextField replaceField;


    public SearchAndReplaceIterator(JTextPane textPane, JTextField findField, JTextField replaceField) {
        super(textPane, findField);
        this.replaceField = replaceField;
    }

    public void replace() {
        if(textPane.getSelectedText().length() > 0)
            textPane.replaceSelection(replaceField.getText());
    }


    public void replaceAll() {
        while(next() != -1) {
            replace();
        }
    }
}
