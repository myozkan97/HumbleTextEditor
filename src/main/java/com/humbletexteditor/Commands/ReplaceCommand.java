package com.humbletexteditor.Commands;

import javax.swing.*;

public class ReplaceCommand implements Command {

    private JTextPane textPane;
    private JTextField textField;

    public ReplaceCommand(JTextPane textPane, JTextField textField) {
        this.textPane = textPane;
        this.textField = textField;
    }

    @Override
    public void execute() {
        textPane.replaceSelection(textField.getText());
    }
}
