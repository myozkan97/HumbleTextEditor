package com.humbletexteditor.Commands;

import com.humbletexteditor.SearchIterator;

import javax.swing.*;

public class NextItemCommand implements Command {
    private SearchIterator searchIterator;
    private JTextPane textPane;
    private JTextField textField;
    private String searchString;

    public NextItemCommand(JTextPane textPane, JTextField textField) {
        this.textPane = textPane;
        this.textField = textField;

    }

    @Override
    public void execute() {
        if (searchIterator == null || !searchString.equals(textField.getText()))
            searchIterator = new SearchIterator(textPane, textField);
        textPane.requestFocus();
        textPane.requestFocusInWindow();
        searchIterator.next();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textField.requestFocus();
            }
        });

        searchString = textField.getText();
    }
}
