package com.humbletexteditor.Commands;

import com.humbletexteditor.FindDialog;

import javax.swing.*;

public class FindCommand implements Command {
    private JTextPane textPane;
    private FindDialog findDialog;

    public FindCommand(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void execute() {
        if (findDialog == null)
            findDialog = new FindDialog(textPane);
        else
            findDialog.setVisible(true);
    }
}
