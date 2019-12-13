package com.humbletexteditor.Commands;

import com.humbletexteditor.SearchAndReplaceIterator;

import javax.swing.*;

public class ReplaceAllCommand implements Command {
    private JTextPane textPane;
    private JTextField findField;
    private JTextField replaceField;

    private SearchAndReplaceIterator searchAndReplaceIterator;

    public ReplaceAllCommand(JTextPane textPane, JTextField findField, JTextField replaceField) {
        this.textPane = textPane;
        this.findField = findField;
        this.replaceField = replaceField;
    }

    @Override
    public void execute() {
        if(searchAndReplaceIterator == null)
            searchAndReplaceIterator = new SearchAndReplaceIterator(textPane, findField, replaceField);

        searchAndReplaceIterator.replaceAll();

    }
}
