package com.humbletexteditor;

import javax.swing.*;
import java.util.Iterator;
import java.util.function.Consumer;

public class SearchIterator implements Iterator<Integer> {
    protected JTextPane textPane;
    protected JTextField findField;
    protected int index;

    public SearchIterator(JTextPane textPane, JTextField findField) {
        this.textPane = textPane;
        this.findField = findField;
    }

    @Override
    public boolean hasNext() {
        return textPane.getText().indexOf(findField.getText(), index) != -1;

    }

    @Override
    public Integer next() {
        if(hasNext()) {
            index = textPane.getText().indexOf(findField.getText(), index);
            textPane.setSelectionStart(index - countLines(textPane.getText(), index));
            textPane.setSelectionEnd(textPane.getSelectionStart() + findField.getText().length());
            return index++;
        }
        else
            index = 0;
        return -1;
    }

    private static int countLines(String str, int toIndex) {
        if(str == null || str.isEmpty())
        {
            return 0;
        }
        int lines = 0;
        int pos = 0;
        while (((pos = str.indexOf("\n", pos) + 1) != 0) && (pos <= toIndex)) {
            lines++;
        }
        return lines;
    }



}
